package com.tutorialsninja.qa.testcases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo1 {

	WebDriver driver;
	public static void main(String[] args) try {
		{

			WebDriverManager.chromedriver().setup();
			try {
				try {
					driver = new ChromeDriver();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			

	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		public void switchwindows() {
			
			WebElement parent_window= driver.findElement(By.id("ID"));
			String Parent_window = driver.getWindowHandle();

		 Set<String> all_window = driver.getWindowHandles();

			<Iterator> itr = all_window.Iterator;
			itr.next();
			String child_window = itr.next();
			driver.switchTo().window(child_window);
			driver.close();
			driver.switchTo().window(parent_window);
			driver.close();

			
		}
		
	}


