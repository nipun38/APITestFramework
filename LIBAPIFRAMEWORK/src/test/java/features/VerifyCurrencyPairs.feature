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
Feature: Verify currency pairs are returned by the API
  
## (AC := Verify that 162 currency pairs are retuned by the API.)
	@tag1
  Scenario: Validate currency pairs are returned by the API
    When user makes a call to API Endpoint URL
		Then the API response should have status code <statusCode>
		And  the response should have valid count of Currency pairs <intExpectedValue>
		Examples: 
      | statusCode |   intExpectedValue |
      | 	      200|           162| 
      
    Examples: 
      | statusCode |   intExpectedValue |
      | 	      200|           169| 