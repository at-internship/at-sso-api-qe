@Regression
Feature: at-sso get operation

    @Scenario1
  Scenario: Get all the users registered in the SSO-API database
    Given I prepare the get operation for sso api
    When I call get request to api
    Then The status code should be 200
    And I validate the response for get all users