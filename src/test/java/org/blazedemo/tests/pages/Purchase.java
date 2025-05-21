package org.blazedemo.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Purchase {

	public WebDriver driver;
	
	public Purchase(WebDriver driver) {
		this.driver = driver;
	}
	
	
	private By name = By.xpath("//input[@id='inputName']");
	private By address = By.xpath("//input[@id='address']");
	private By city = By.xpath("//input[@id='city']");
	private By state = By.xpath("//input[@id='state']");
	private By zip = By.xpath("//input[@id='zipCode']");
	private By credit = By.xpath("//input[@id='creditCardNumber']");
	private By month = By.xpath("//input[@id='creditCardMonth']");
	private By year = By.xpath("//input[@id='creditCardYear']");
	private By cardname = By.xpath("//input[@id='nameOnCard']");
	
	private By type = By.xpath("//select[@id='cardType']");
	
	private By remember = By.xpath("//input[@type='checkbox']");
	
	private By purchase = By.xpath("//input[@type='submit']");
	

	public WebElement getName() {
		return driver.findElement(name);
	}

	public void setName(String names) {
		this.driver.findElement(name).sendKeys(names);
	}

	
	public WebElement getAddress() {
		return driver.findElement(address);
	}

	public void setAddress(String addres) {
		this.driver.findElement(address).sendKeys(addres);
	}

	
	public WebElement getCity() {
		return driver.findElement(city);
	}

	public void setCity(String citie) {
		this.driver.findElement(city).sendKeys(citie);
	}

	
	public WebElement getState() {
		return driver.findElement(state);
	}

	public void setState(String stat) {
		this.driver.findElement(state).sendKeys(stat);
	}

	
	public WebElement getZip() {
		return driver.findElement(zip);
	}

	public void setZip(String zipcode) {
		this.driver.findElement(zip).sendKeys(zipcode);
	}

	
	public WebElement getCredit() {
		return driver.findElement(credit);
	}
	
	public void setCredit(String creditcard) {
		this.driver.findElement(credit).sendKeys(creditcard);
	}

	
	public WebElement getMonth() {
		return driver.findElement(month);
	}
	
	public void setMonth(String mont) {
		this.driver.findElement(month).sendKeys(mont);
	}

	
	public WebElement getYear() {
		return driver.findElement(year);
	}
	
	public void setYear(String yearl) {
		this.driver.findElement(year).sendKeys(yearl);
	}

	
	public WebElement getCardname() {
		return driver.findElement(cardname);
	}

	public void setCardname(String cardNames) {
		this.driver.findElement(cardname).sendKeys(cardNames);
	}

	
	public WebElement getRemember() {
		return driver.findElement(remember);
	}

	
	public WebElement getPurchase() {
		return driver.findElement(purchase);
	}
	
	
	public void getType(String typeOption) {
		Select s = new Select(driver.findElement(type));
		s.selectByVisibleText(typeOption);
	}
	
	
}
