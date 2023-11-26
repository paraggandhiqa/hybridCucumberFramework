package com.tutorialninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialninja.utils.Utility;

import junit.framework.Assert;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "input-firstname")
	private WebElement firstName;

	@FindBy(xpath = "//*[@placeholder=\"Last Name\"]")
	private WebElement lastName;

	@FindBy(css = "[name=\"email\"]")
	private WebElement email;

	@FindBy(id = "input-telephone")
	private WebElement telephone;

	@FindBy(css = "[name=\"password\"]")
	private WebElement password;

	@FindBy(id = "input-confirm")
	private WebElement confirmPassword;

	@FindBy(css = "input[type=\"checkbox\"]")
	private WebElement privacyPolicyCheckbox;

	@FindBy(xpath = "//input[@name='newsletter'][@value=1]")
	private WebElement subscribeRadioButton;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement continueButton;

	@FindBy(css = "div[id=\"content\"] h1")
	private WebElement accountCreationSuccessMessage;
	
	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameMandatoryMessage;
	
	@FindBy(css = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameMandatoryMessage;
	
	@FindBy(css = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailMandatoryMessage;
	
	@FindBy(css = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneMandatoryMessage;
	
	@FindBy(css = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordMandatoryMessage;
	
	@FindBy(xpath = "//div[contains(@class,' alert-danger')]")
	private WebElement headerMandatoryMessage;

	public void enterFirstName(String firstNameText) {
		firstName.sendKeys(firstNameText);
	}

	public void enterLastName(String lastNameText) {
		lastName.sendKeys(lastNameText);
	}

	public void enterEmail(String emailText) {
		email.sendKeys(emailText);
	}

	public void enterTelephone(String telephoneText) {
		telephone.sendKeys(telephoneText);
	}

	public void enterPassword(String passwordText) {
		password.sendKeys(passwordText);
	}

	public void clickOnPrivacyPolicy() {
		privacyPolicyCheckbox.click();
	}

	public void selectSubscribe() {
		subscribeRadioButton.click();
	}

	public void clickOnContiue() {
		continueButton.click();
	}

	public void enterConfirmPassword(String confirmPasswordText) {
		confirmPassword.sendKeys(confirmPasswordText);
	}

	public String getAccountCreationSuccessMessage() {
		return accountCreationSuccessMessage.getText();
	}
	
	public String getFirstNameMandatoryMessage() {
		return firstNameMandatoryMessage.getText();
	}
	
	public String getLastNameMandatoryMessage() {
		return lastNameMandatoryMessage.getText();
	}
	
	public String getTelephoneMandatoryMessage() {
		return telephoneMandatoryMessage.getText();
	}
	
	public String getPasswordMandatoryMessage() {
		return passwordMandatoryMessage.getText();
	}
	
	public String getEmailMandatoryMessage() {
		return emailMandatoryMessage.getText();
	}
	
	public String getMandatoryMessageInHeader() {
		return headerMandatoryMessage.getText();
	}
}
