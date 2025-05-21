package org.blazedemo.tests.pages;

import java.util.List;

import org.blazedemo.tests.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class HomePage extends BaseClass{

	public WebDriver webdriver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By destlink = By.xpath("//a[contains(text(),\"destination\")]");
	private By login = By.xpath("//a[text()='home']");
	private By travel = By.xpath("//a[contains(text(),\"Travel\")]");
	private By findFlights = By.xpath("//input[@value='Find Flights']");

	private By depart = By.xpath("//select[@name='fromPort']"); 
	
	private By dest = By.xpath("//select[@name='toPort']"); 
	
	public WebElement getdestLink() {
		return driver.findElement(destlink);		
	}
	
	public WebElement getLogin() {
		return driver.findElement(login);		
	}
	
	public WebElement getTravel() {
		return driver.findElement(travel);		
	}
	
	public WebElement getFindFlights() {
		return driver.findElement(findFlights);		
	}
	
	public WebElement getDepart() {
		return driver.findElement(depart);
	}
	
	public void setDepart(String departure) {
		 this.driver.findElement(depart).sendKeys(departure);
	}
	
	public WebElement getDest() {
		return driver.findElement(dest);
	}
	
	
	
	public void departSelect(String option) {
		Select s = new Select(driver.findElement(depart));
		s.selectByVisibleText(option);
		
	}
	
	public void destSelect(String option) {
		Select s = new Select(driver.findElement(dest));
		s.selectByVisibleText(option);
	}


	
}
