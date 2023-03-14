package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tutorialsninja.qa.utils.Utilities;

public class Base {
	
	WebDriver driver;
	
	//Making it public so child class can access it.
	public Properties prop;
	public Properties dataProp;
	
	//create constructor as Base which is same name as class
	public Base()throws IOException
	{
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		FileInputStream fis = new FileInputStream(propFile);
		prop.load(fis);

		dataProp = new Properties();
		File dataPropFile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
		FileInputStream fis1 = new FileInputStream(dataPropFile);
		dataProp.load(fis1);
	}	
	
		
	public WebDriver initializeBrowserAndOpenApplication(String browserName)
	{
		
		if(browserName.equals("chrome")) {
		driver=new ChromeDriver();
		}
		if(browserName.equals("firefox")) {
			driver= new FirefoxDriver();
		}
		if(browserName.equals("edge")) {
			driver=new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_WAIT_TIME));
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	public void teardown()
	{
		driver.quit();
	}
	
	}
