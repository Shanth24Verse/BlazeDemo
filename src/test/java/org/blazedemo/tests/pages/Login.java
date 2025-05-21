package org.blazedemo.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {

	WebDriver driver;
	
	public Login(WebDriver driver) {
		this.driver = driver;
	}
	
	private By email = By.xpath("//input[@id='email']");
	private By password = By.xpath("//input[@id='password']");
	
	private By check = By.xpath("//input[@type='checkbox']");
	
	private By login = By.xpath("//button[@type='submit']");
	
	private By forgot = By.xpath("//a[@class='btn btn-link']");
	
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public void setEmail(String emailid) {
		this.driver.findElement(email).sendKeys(emailid);
	}
	
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public void setPassword(String pass) {
		this.driver.findElement(password).sendKeys(pass);
	}
	
	public WebElement getCheck() {
		return driver.findElement(check);
	}
	
	public WebElement getLogin() {
		return driver.findElement(login);
	}
	
	public WebElement getForgot() {
		return driver.findElement(forgot);
	}
}
