package org.blazedemo.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Reserve {

	public WebDriver driver;
	
	public Reserve(WebDriver driver) {
		this.driver=driver;
	}
	
	
	private By chooseflight = By.xpath("//input[@type='submit']");
	
	
	public WebElement getChooseFlight() {
		return driver.findElement(chooseflight);
	}
	
}
