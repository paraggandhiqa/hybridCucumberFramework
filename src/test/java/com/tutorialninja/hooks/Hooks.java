package com.tutorialninja.hooks;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.tutorialninja.factory.DriverFactory;
import com.tutorialninja.utils.Utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	WebDriver driver;
	Properties properties;

	@Before
	public void setup() throws IOException {
		properties = Utility.getProperties();
		DriverFactory.initializeBrowser(properties.getProperty("browser"));
		// this will return driver and we can use this in put tests
		driver = DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(properties.getProperty("url"));
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
