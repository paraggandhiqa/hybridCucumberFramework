package com.tutorialninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//page factory
	// it should intialize automatically with initelements
	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	private WebElement myAccountOption;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	public void clickOnMyAccount() {
		myAccountOption.click();
	}
	
	public void clickOnLogin() {
		loginOption.click();
	}
	
	public void clickOnRegister() {
		registerOption.click();
		
	}
	

}
