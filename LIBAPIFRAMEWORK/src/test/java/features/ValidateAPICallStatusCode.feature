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
Feature: API Call Validation with different code
  
## (AC:= • Check the status code and status retuned by the API response)
  @tag1 
  Scenario: Make the API Call and Verify the status code returned
    When user makes a call to API Endpoint URL
		Then the API response should have status code <statusCode>
		Examples: 
      | statusCode |
      | 	      200|
      | 	      400|

  
