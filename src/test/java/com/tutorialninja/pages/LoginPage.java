package com.tutorialninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	// Page object model and page factory
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement password;
	
	@FindBy(xpath="//input[contains(@class,'btn-primary')]")
	private WebElement loginButton;
	
	@FindBy(linkText="Edit your account information")
	private WebElement loginSuccessMessage;
	
	@FindBy(xpath="//div[contains(@class,'alert-danger')]")
	private WebElement invalidCredentialMessage;

	
	public void enterEmail(String emailText) {
		email.sendKeys(emailText);
	}
	
	public void enterPassword(String passwordText) {
		password.sendKeys(passwordText);
	}
	
	public void clickOnLogin() {
		loginButton.click();
	}
	
	public boolean isLoginSuccess() {
		return loginSuccessMessage.isDisplayed();
	}
	
	public String getInvalidCredentialMessage() {
		return invalidCredentialMessage.getText();
	}

}
