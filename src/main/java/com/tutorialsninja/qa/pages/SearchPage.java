package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
WebDriver driver;

@FindBy(xpath = "//span[@data-ui-id='page-title-wrapper']")
private WebElement ValidSearchWarningMessage;

@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div")
private WebElement InvalidSearchWarningMessage;

public SearchPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	
}

public String displayStatuSearchValidWarningMessage() {
	String validstatus = ValidSearchWarningMessage.getText();
	return validstatus;
}

public String displayStatusSearchInvalidWarningMessage() {
	String invalidstatus = InvalidSearchWarningMessage.getText();
	return invalidstatus;
}

}
