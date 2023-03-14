package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class Login extends Base{
	
	//To read the property file from Base class create a constructor
	public Login() throws IOException
	{
	super();	
	}

	public WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		driver=initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		
		HomePage homepage = new HomePage(driver);
		homepage.clickOnSignInOption();
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	    
	
		@Test(dataProvider="testdata")
	public void verifyLoginWithValidCredentials(String LoginName, String Password)
	{

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(LoginName);
		loginpage.enterPassword(Password);
		loginpage.signinclick();
		
		}
		
		@DataProvider(name="testdata")
		public Object[][] supplyTestData() throws IOException
		{
			return new Object[][]
					{
					{"alisha1@gmail.com", "secret1@123"},
					{"sh.co.uk", "adasdas"},
					{"shilu_1977@gmail.com", "adasda"},
					};
		}
	
	@Test
	public void verifyLoginWithInvalidEmail()
	{

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(dataProp.getProperty("InvalidEmailid"));
		loginpage.enterPassword(prop.getProperty("validPassword"));
		loginpage.signinclick();

		String actualWarningMessage = driver.findElement(By.xpath("//*[@id=\'email-error\']")).getText();
		Assert.assertEquals(actualWarningMessage, "Please enter a valid email address (Ex: johndoe@domain.com).");

}
		
	@Test
	public void verifyLoginWithNoEmail()
	{
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress("");
		loginpage.enterPassword(prop.getProperty("validPassword"));
		loginpage.signinclick();
		
		String actualWarningMessage = driver.findElement(By.xpath("//*[@id=\"email-error\"]")).getText();
		Assert.assertEquals(actualWarningMessage, "This is a required field.");
		
	}

	@Test (enabled=false)
	public void verifyLoginWithNoPassword()
	{
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress("alisha2" + Utilities.generateTimeStamp() + "@gmail.com");
		loginpage.enterPassword("");
		loginpage.signinclick();
		
		String actualWarningMessage = driver.findElement(By.id("pass-error")).getText();
		Assert.assertEquals(actualWarningMessage, "This is a required field.");
		
	}	
}

