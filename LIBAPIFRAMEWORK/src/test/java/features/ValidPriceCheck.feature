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
Feature: API Call was successfull and Verify valid prices were returned
  
## (AC := API call is successful and returns valid price)
	@tag1
  Scenario: Validate successfull API returns valid prices
    When user makes a call to API Endpoint URL
		Then the API response should have status code <statusCode>
		And  the response should have valid price for <stringJsonPath> : <stringExpectedValue>
		Examples: 
      | statusCode | stringJsonPath| stringExpectedValue|
      | 	      200| "rates.USD"   |  "1"				   |
    Examples: 
      | statusCode | stringJsonPath| stringExpectedValue|
      | 	      200| "rates.AED"   |  "3.6725"	   |
    Examples: 
      | statusCode | stringJsonPath| stringExpectedValue|
      | 	      200| "rates.AMD"   |  "395.75128"  |
    Examples: 
      | statusCode | stringJsonPath| stringExpectedValue|
      | 	      200| "rates.ALL"   |  "95.866"	   |


  
