package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;

public class Search extends Base {
	
	public WebDriver driver;
	
	public Search() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		HomePage homepage = new HomePage(driver);
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void searchWithValidProduct() {
		
		HomePage homepage = new HomePage(driver);
		SearchPage searchpage = new SearchPage(driver);
		
		homepage.searchfield(dataProp.getProperty("ValidSearchProduct"));
		homepage.searchbuttonclick();
		
		Assert.assertEquals("Search results for: 'pants'", searchpage.displayStatuSearchValidWarningMessage());
	}
	
	@Test(priority=2)
	public void searchWithInvalidProduct() {
		
		HomePage homepage = new HomePage(driver);
		SearchPage searchpage = new SearchPage(driver);
		
		homepage.searchfield(dataProp.getProperty("InvalidSearchProduct"));
		homepage.searchbuttonclick();

		Assert.assertEquals("Your search returned no results ABC.", searchpage.displayStatusSearchInvalidWarningMessage());
	}
	
	
}
