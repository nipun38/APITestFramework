#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Verify he USD price against the AED and make sure the prices are in range on 3.6 – 3.7
  
## (AC := Fetch the USD price against the AED and make sure the prices are in range on 3.6 –3.7.)

	@tag1
	  Scenario: Fetch the USD price against the AED and make sure the prices are in range on 3.6 – 3.7
    When user makes a call to API Endpoint URL
		Then the API response should have status code <statusCode>
		And  Validate the response returns valid price in range for <stringCurrency> is between <stringrangeFrom> to <stringrangeTo>
  
		Examples: 
      | statusCode | stringCurrency|stringrangeFrom|stringrangeTo|
      | 	      200|    "rates.USD"| "4.6" |"4.7"|
      
     Examples: 
      | statusCode | stringCurrency|stringrangeFrom|stringrangeTo|
      | 	      200|    "rates.AED"| "3.6" |"3.7"|