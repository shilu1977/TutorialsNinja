package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	//These WebElements are objects
	@FindBy(linkText="Sign In")
	private WebElement Signin;
	
	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[3]/a")
	private WebElement CreateAnAccount;
	
	@FindBy(xpath = "//input[@placeholder='Search entire store here...']")
	private WebElement enterSearchField;
	
	@FindBy(xpath="//button[@title='Search']")
	private WebElement searchbutton;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnCreateAnAccount() {
		CreateAnAccount.click();
	}
	
	public void clickOnSignInOption() {
		Signin.click();
	}
	
	public void searchfield(String searchtext) {
		enterSearchField.sendKeys(searchtext);
	
	}
	
	public void searchbuttonclick() {
		searchbutton.click();
	}
		
	
}
