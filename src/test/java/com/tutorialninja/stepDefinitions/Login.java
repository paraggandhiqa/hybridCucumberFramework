package com.tutorialninja.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.tutorialninja.factory.DriverFactory;
import com.tutorialninja.pages.HomePage;
import com.tutorialninja.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Login {

	WebDriver driver;
	LoginPage loginPage;

	@Given("user is on login page")
	public void user_is_on_login_page() {
		// call the driver

		driver = DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.clickOnLogin();
		loginPage = new LoginPage(driver);
	}

	@When("user enters valid email address {string}")
	public void user_enters_valid_email_address(String email) {
		loginPage.enterEmail(email);

	}

	@When("use enters valid password {string}")
	public void use_enters_valid_password(String password) {
		loginPage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLogin();
	}

	@Then("user successfully logged in")
	public void user_successfully_logged_in() {
		Assert.assertTrue(loginPage.isLoginSuccess());
	}

	@When("user enters invalid email address {string}")
	public void user_enters_invalid_email_address(String email) {
		loginPage.enterEmail(email);
	}

	@When("use enters invalid password {string}")
	public void use_enters_invalid_password(String password) {
		loginPage.enterPassword(password);
	}

	@Then("user gets invalid credentials warning message")
	public void user_gets_invalid_credentials_warning_message() {
		Assert.assertEquals(loginPage.getInvalidCredentialMessage(),
				"Warning: No match for E-Mail Address and/or Password.");
	}

	@When("user enters email address {string}")
	public void user_enters_email_address(String email) {
		loginPage.enterEmail(email);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}

}
