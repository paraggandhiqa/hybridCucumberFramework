package com.tutorialninja.stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tutorialninja.hooks.Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Search extends Hooks {

	WebDriver driver;

	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo");
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Given("user is on search page")
	public void user_is_on_search_page() {

	}

	@When("user enters product {string}")
	public void user_enters_produdct(String product) {
		driver.findElement(By.cssSelector("[name='search']")).sendKeys(product);
	}

	@When("user clicks on search")
	public void user_clicks_on_search() {
		driver.findElement(By.xpath("//button/i[contains(@class,'search')]")).click();
	}

	@Then("user gets searched product in search result")
	public void user_gets_searched_product_in_search_result() {
		String searchedProductText = driver
				.findElement(By.xpath("//div[contains(@class,'product-layout')]//div[contains(@class,'caption')]//a"))
				.getText();
		Assert.assertEquals(searchedProductText, "iPhone");
	}

	@Then("user gets no product found warning message")
	public void user_gets_no_product_found_warning_message() {
		String noProductFoundText = driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p"))
				.getText();
		Assert.assertEquals(noProductFoundText, "There is no product that matches the search criteria.");
	}

	@When("user dont enter any product")
	public void user_dont_enter_any_product() {
		driver.findElement(By.cssSelector("[name='search']")).sendKeys("");
	}

}
