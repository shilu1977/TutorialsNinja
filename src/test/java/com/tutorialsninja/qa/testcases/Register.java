package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class Register extends Base {
	
	
	public Register() throws IOException
	{
		super();
	}
	public WebDriver driver;

	
	@BeforeMethod
	public void setup()
	{
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		HomePage homepage = new HomePage(driver);			
		homepage.clickOnCreateAnAccount();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

	
	@Test(priority=1)
	public void verifyRegisterWithMandatoryFields() throws InterruptedException
	{
		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(dataProp.getProperty("FirstName"));
		registerpage.enterLastName(dataProp.getProperty("LastName"));
		registerpage.enterEmail(com.tutorialsninja.qa.utils.Utilities.generateTimeStamp());
		registerpage.enterPassword(prop.getProperty("validPassword"));
		registerpage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerpage.createAnAccountbtn();
		
	}
		
	
	@Test(priority=2)

	public void verifyRegisterWithDifferentPasswords()
	{
		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(dataProp.getProperty("FirstName"));
		registerpage.enterLastName(dataProp.getProperty("LastName"));
		registerpage.enterEmail(com.tutorialsninja.qa.utils.Utilities.generateTimeStamp());
		registerpage.enterPassword(dataProp.getProperty("Password1"));
		registerpage.enterConfirmPassword(dataProp.getProperty("Password2"));
		registerpage.createAnAccountbtn();
		
		String actualWarningMessage = driver.findElement(By.xpath("//div[@for='password-confirmation']")).getText();
		System.out.println(actualWarningMessage);
		Assert.assertEquals(actualWarningMessage, "Please enter the same value again.");
		
	}
	
}
