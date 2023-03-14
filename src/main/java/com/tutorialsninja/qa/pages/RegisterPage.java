package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	
	@FindBy(xpath = "//input[@title='First Name']")
	private WebElement firstNameField;
	
	@FindBy(xpath="//input[@title='Last Name']")
	private WebElement lastNameField;
	
	@FindBy(xpath = "//input[@title='Email']")
	private WebElement EmailIDField;
	
	@FindBy(xpath = "//input[@title='Password']")
	private WebElement passwordField;
	
	@FindBy(xpath = "//input[@title='Confirm Password']")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath = "//button[@title='Create an Account']")
	private WebElement createAnAccountButton;
	
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void enterFirstName(String fname) {
		firstNameField.sendKeys(fname);
	}
	
	public void enterLastName(String lname) {
		lastNameField.sendKeys(lname);
	}
	
	public void enterEmail(String emailid) {
		EmailIDField.sendKeys(emailid);
	}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
		
	}
	
	public void enterConfirmPassword(String confirmpassword) {
		confirmPasswordField.sendKeys(confirmpassword);
	}
	
	public void createAnAccountbtn() {
		createAnAccountButton.click();
	}
	

}
