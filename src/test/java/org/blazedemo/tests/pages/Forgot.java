package org.blazedemo.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Forgot {

	WebDriver driver;
	
	public Forgot(WebDriver driver) {
		this.driver=driver;
	}
	
	private By email = By.xpath("//input[@id='email']");
	
	private By reset = By.xpath("//button[@type='submit']");
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public void setEmail(String email1) {
		this.driver.findElement(email).sendKeys(email1);
	}
	
	public WebElement getReset() {
		return driver.findElement(reset);
	}
	
}
