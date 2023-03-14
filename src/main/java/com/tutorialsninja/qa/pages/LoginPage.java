package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@title='Email']")
	private WebElement emailAddress;
	
	@FindBy(xpath = "//input[@title='Password']")
	private WebElement password;
	
	@FindBy(xpath = "//fieldset[@data-hasrequired='* Required Fields']//div//div//button[@name='send']")
	private WebElement Signinbutton;
	
	
	
	public LoginPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
		}
	
	public void enterEmailAddress(String emailtext) {
		emailAddress.sendKeys(emailtext);
	}
	
	public void enterPassword(String passwordtext) {
		password.sendKeys(passwordtext);
	}
	
	public void signinclick() {
		Signinbutton.click();
	}
	
	
}
