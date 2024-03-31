package org.Runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",
				glue = {"stepDefinitions"},
				plugin = { "pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, 
				//plugin = { "pretty","html:target/cucumber-reports" },
				//plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"} ,
				monochrome = true)
public class TestRunner {

}
