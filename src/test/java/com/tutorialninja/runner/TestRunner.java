package com.tutorialninja.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/com/tutorialninja/features", glue = {
		"com/tutorialninja/stepDefinitions", "com/tutorialninja/hooks" }, tags = "@register2")

public class TestRunner {

}
