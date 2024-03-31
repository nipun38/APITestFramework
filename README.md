# APITestFramework
# Check out this project to your local drive
# Compile and build the project using eclipse with maven
# Feature Files can be found under /src/test/java/features where there are multiple feature files which are catered to the assignments to cover the acceptance criteria which covers both positive and negative scenarios
# StepDefinitions.java can be found under /src/test/java/stepDefinitions which includes the definitions of the feature files
# 2 json files are under /src/test/java names as schema.json and schemainvalid.json which are referred in the feature files to cover both positive and negative scenarios
# extent.proerties can be found under /src/test/resources
# TestRunner.java is KEY file which can be found /src/test/org/Runners which can used with below parameters which are customizable.

# The below code will run all the feature files under /src/test/java/features
      @CucumberOptions(features = "src/test/java/features",
				glue = {"stepDefinitions"},
				plugin = { "pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, 
				//plugin = { "pretty","html:target/cucumber-reports" },
				//plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"} ,
				monochrome = true)
      
# To run single feature files use the below code
     @CucumberOptions(features = "src/test/java/features/ValidPriceCheck.feature",
  				glue = {"stepDefinitions"},
  				plugin = { "pretty",
  				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, 
  				//plugin = { "pretty","html:target/cucumber-reports" },
  				//plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"} ,
  				monochrome = true)
     
  
