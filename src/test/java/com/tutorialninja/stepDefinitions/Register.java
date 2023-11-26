package com.tutorialninja.stepDefinitions;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tutorialninja.factory.DriverFactory;
import com.tutorialninja.pages.HomePage;
import com.tutorialninja.pages.RegisterPage;
import com.tutorialninja.utils.Utility;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Register {

	WebDriver driver;
	HomePage homePage;
	RegisterPage registerPage;

	@Given("user is on register page")
	public void user_is_on_register_page() {

		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.clickOnRegister();
		registerPage = new RegisterPage(driver);
	}

	@When("user enters details as below")
	public void user_enters_details_as_below(DataTable dataTable) {

		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("lastName"));
		if (dataMap.get("email") == null) {
			registerPage.enterEmail(Utility.generateUniqueEmailString());
		} else {
			registerPage.enterEmail(dataMap.get("email"));

		}
		registerPage.enterTelephone(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterConfirmPassword(dataMap.get("password"));
	}

	@And("user selects privacy policy")
	public void user_selects_privacy_policy() throws InterruptedException {
		registerPage.clickOnPrivacyPolicy();
	}

	@And("user clicks on continue button")
	public void user_clicks_on_continue_button() {
		registerPage.clickOnContiue();
	}

	@Then("user account creates successfully")
	public void user_account_creates_successfully() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertEquals("Your Account Has Been Created!", registerPage.getAccountCreationSuccessMessage());

	}

	@And("user selects Yes for newsletter")
	public void user_selects_Yes_for_newsletter() {
		registerPage.selectSubscribe();

	}

	@Then("user gets duplicate email warning message")
	public void user_gets_duplicate_email_warning_message() {

		Assert.assertEquals("Warning: E-Mail Address is already registered!",
				registerPage.getMandatoryMessageInHeader());

	}

	@When("user dont enter any details")
	public void user_dont_enter_any_details() {

		registerPage.clickOnContiue();
	}

	@Then("user gets mandatory fields warning messages")
	public void user_gets_mandatory_fields_warning_messages() {

		Assert.assertEquals("First Name must be between 1 and 32 characters!",
				registerPage.getFirstNameMandatoryMessage());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!",
				registerPage.getLastNameMandatoryMessage());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", registerPage.getEmailMandatoryMessage());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",
				registerPage.getTelephoneMandatoryMessage());
		Assert.assertEquals("Password must be between 4 and 20 characters!",
				registerPage.getPasswordMandatoryMessage());
		Assert.assertEquals("Warning: You must agree to the Privacy Policy!",
				registerPage.getMandatoryMessageInHeader());

	}

}
