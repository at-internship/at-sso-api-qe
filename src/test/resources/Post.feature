@Regression @POST
Feature: at-sso post operation

  #Happy Path
  @POST1
  Scenario: Create a new user with valid parameters
    Given I create a request as follow
      | name      | random |
      | firstName | random |
      | lastName  | random |
      | email     | random |
      | password  | random |
      | status    | random |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was created with a 201 status code
    And The API should return a random id
    And I check that the element with this id exist in the DB

  #name validations
  @POST2
  Scenario: Send the field name empty
    Given I create a request as follow
      | name      | empty  |
      | firstName | random |
      | lastName  | random |
      | email     | random |
      | password  | random |
      | status    | random |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was created with a 201 status code
    And The name field should have the correct default string in the DB

  @POST3
  Scenario: Send the field name defined as null
    Given I create a request as follow
      | name      | null   |
      | firstName | random |
      | lastName  | random |
      | email     | random |
      | password  | random |
      | status    | random |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was created with a 201 status code
    And The name field should have the correct default string in the DB

  @POST4
  Scenario: Do not send the field name in the request
    Given I create a request as follow
      | name      | dont   |
      | firstName | random |
      | lastName  | random |
      | email     | random |
      | password  | random |
      | status    | random |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was created with a 201 status code
    And The name field should have the correct default string in the DB

  #first name validations
  @POST5
  Scenario: Send the field firstName empty
    Given I create a request as follow
      | name      | random |
      | firstName | empty  |
      | lastName  | random |
      | email     | random |
      | password  | random |
      | status    | random |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was not created with a 400 status code

  @POST6
  Scenario: Send the field firstName defined as null
    Given I create a request as follow
      | name      | random |
      | firstName | null   |
      | lastName  | random |
      | email     | random |
      | password  | random |
      | status    | random |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was not created with a 400 status code

  @POST7
  Scenario: Do not send the field firstName in the request
    Given I create a request as follow
      | name      | random |
      | firstName | dont   |
      | lastName  | random |
      | email     | random |
      | password  | random |
      | status    | random |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was not created with a 400 status code

  #last name validations
  @POST8
  Scenario: Send the field lastName empty
    Given I create a request as follow
      | name      | random |
      | firstName | random |
      | lastName  | empty  |
      | email     | random |
      | password  | random |
      | status    | random |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was not created with a 400 status code

  @POST9
  Scenario: Send the field lastName defined as null
    Given I create a request as follow
      | name      | random |
      | firstName | random |
      | lastName  | null   |
      | email     | random |
      | password  | random |
      | status    | random |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was not created with a 400 status code

  @POST10
  Scenario: Do not send the field lastName in the request
    Given I create a request as follow
      | name      | random |
      | firstName | random |
      | lastName  | dont   |
      | email     | random |
      | password  | random |
      | status    | random |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was not created with a 400 status code

  #email validations
  @POST11
  Scenario: Send double at in the email field
    Given I create a request as follow
      | name      | random   |
      | firstName | random   |
      | lastName  | random   |
      | email     | doubleAt |
      | password  | random   |
      | status    | random   |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was not created with a 400 status code

  @POST12
  Scenario: Send a dot in the end of the email addres
    Given I create a request as follow
      | name      | random   |
      | firstName | random   |
      | lastName  | random   |
      | email     | finalDot |
      | password  | random   |
      | status    | random   |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was not created with a 400 status code

  @POST13
  Scenario: Send only the domain part of the email
    Given I create a request as follow
      | name      | random |
      | firstName | random |
      | lastName  | random |
      | email     | domain |
      | password  | random |
      | status    | random |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was not created with a 400 status code

  @POST14
  Scenario: Send only the name part of the email
    Given I create a request as follow
      | name      | random |
      | firstName | random |
      | lastName  | random |
      | email     | name   |
      | password  | random |
      | status    | random |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was not created with a 400 status code

  @POST15
  Scenario: Send invalid special caracters in the name part of the email
    Given I create a request as follow
      | name      | random               |
      | firstName | random               |
      | lastName  | random               |
      | email     | nameSpecialCaracters |
      | password  | random               |
      | status    | random               |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was not created with a 400 status code

  @POST16
  Scenario: Send upper and lower case mixed in the name part of the email
    Given I create a request as follow
      | name      | random         |
      | firstName | random         |
      | lastName  | random         |
      | email     | nameUpperLower |
      | password  | random         |
      | status    | random         |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was created with a 201 status code
    And The API should return a random id
    And I check that the element with this id exist in the DB
    And It should be registered in lowercase

  @POST17
  Scenario: Send numbers in the name part of the email
    Given I create a request as follow
      | name      | random     |
      | firstName | random     |
      | lastName  | random     |
      | email     | nameNumber |
      | password  | random     |
      | status    | random     |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was created with a 201 status code
    And The API should return a random id
    And I check that the element with this id exist in the DB

  @POST18
  Scenario: Send an accent mark in the name part of the email
    Given I create a request as follow
      | name      | random     |
      | firstName | random     |
      | lastName  | random     |
      | email     | nameAccent |
      | password  | random     |
      | status    | random     |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was not created with a 400 status code

  @POST19
  Scenario: Send invalid special caracters in the domain part of the email
    Given I create a request as follow
      | name      | random                 |
      | firstName | random                 |
      | lastName  | random                 |
      | email     | domainSpecialCaracters |
      | password  | random                 |
      | status    | random                 |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was not created with a 400 status code

  @POST20
  Scenario: Send upper and lower case mixed in the domain part of the email
    Given I create a request as follow
      | name      | random           |
      | firstName | random           |
      | lastName  | random           |
      | email     | domainUpperLower |
      | password  | random           |
      | status    | random           |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was created with a 201 status code
    And The API should return a random id
    And I check that the element with this id exist in the DB
    And It should be registered in lowercase

  @POST21
  Scenario: Send numbers in the domain part of the email
    Given I create a request as follow
      | name      | random       |
      | firstName | random       |
      | lastName  | random       |
      | email     | domainNumber |
      | password  | random       |
      | status    | random       |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was created with a 201 status code
    And The API should return a random id
    And I check that the element with this id exist in the DB

  @POST22
  Scenario: Send an accent mark in the domain part of the email
    Given I create a request as follow
      | name      | random       |
      | firstName | random       |
      | lastName  | random       |
      | email     | domainAccent |
      | password  | random       |
      | status    | random       |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was not created with a 400 status code

  @POST23
  Scenario: Send a registered email
    Given I create a request as follow
      | name      | random     |
      | firstName | random     |
      | lastName  | random     |
      | email     | registered |
      | password  | random     |
      | status    | random     |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was not created with a 400 status code

  @POST24
  Scenario: Send the email field as empty
    Given I create a request as follow
      | name      | random |
      | firstName | random |
      | lastName  | random |
      | email     | empty  |
      | password  | random |
      | status    | random |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was not created with a 400 status code

  @POST25
  Scenario: Send the email field as null
    Given I create a request as follow
      | name      | random |
      | firstName | random |
      | lastName  | random |
      | email     | null   |
      | password  | random |
      | status    | random |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was not created with a 400 status code

  @POST26
  Scenario: Do not send the email field in the request
    Given I create a request as follow
      | name      | random |
      | firstName | random |
      | lastName  | random |
      | email     | dont   |
      | password  | random |
      | status    | random |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was not created with a 400 status code

  #password validations
  @POST27
  Scenario: Send a line break in the password field
    Given I create a request as follow
      | name      | random    |
      | firstName | random    |
      | lastName  | random    |
      | email     | random    |
      | password  | lineBreak |
      | status    | random    |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was not created with a 400 status code

  @POST28
  Scenario: Send a blank space in the password field
    Given I create a request as follow
      | name      | random     |
      | firstName | random     |
      | lastName  | random     |
      | email     | random     |
      | password  | blankSpace |
      | status    | random     |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was not created with a 400 status code

  @POST29
  Scenario: Send the password field empty
    Given I create a request as follow
      | name      | random |
      | firstName | random |
      | lastName  | random |
      | email     | random |
      | password  | empty  |
      | status    | random |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was not created with a 400 status code

  @POST30
  Scenario: Send the password field as null
    Given I create a request as follow
      | name      | random |
      | firstName | random |
      | lastName  | random |
      | email     | random |
      | password  | null   |
      | status    | random |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was not created with a 400 status code

  @POST31
  Scenario: Do not send the password field in the request
    Given I create a request as follow
      | name      | random |
      | firstName | random |
      | lastName  | random |
      | email     | random |
      | password  | dont   |
      | status    | random |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was not created with a 400 status code

  #status validations
  @POST32
  Scenario: Send letters in the status field
    Given I create a request as follow
      | name      | random  |
      | firstName | random  |
      | lastName  | random  |
      | email     | random  |
      | password  | random  |
      | status    | letters |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was not created with a 400 status code

  @POST33
  Scenario: Send alphanumeric value in the status field
    Given I create a request as follow
      | name      | random       |
      | firstName | random       |
      | lastName  | random       |
      | email     | random       |
      | password  | random       |
      | status    | alphanumeric |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was not created with a 400 status code

  @POST34
  Scenario: Send special caracters in the status field
    Given I create a request as follow
      | name      | random           |
      | firstName | random           |
      | lastName  | random           |
      | email     | random           |
      | password  | random           |
      | status    | specialCaracters |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was not created with a 400 status code

  @POST35
  Scenario: Send a negative number in the status field
    Given I create a request as follow
      | name      | random   |
      | firstName | random   |
      | lastName  | random   |
      | email     | random   |
      | password  | random   |
      | status    | negative |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was not created with a 400 status code

  @POST36
  Scenario: Send a differen value than zero or one in the status field
    Given I create a request as follow
      | name      | random      |
      | firstName | random      |
      | lastName  | random      |
      | email     | random      |
      | password  | random      |
      | status    | noCeroOrOne |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was not created with a 400 status code

  @POST37
  Scenario: Send the status field empty
    Given I create a request as follow
      | name      | random |
      | firstName | random |
      | lastName  | random |
      | email     | random |
      | password  | random |
      | status    | empty  |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was created with a 201 status code
    And The status field should have the correct default value in the DB

  @POST38
  Scenario: Send the status field as null
    Given I create a request as follow
      | name      | random |
      | firstName | random |
      | lastName  | random |
      | email     | random |
      | password  | random |
      | status    | null   |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was created with a 201 status code
    And The status field should have the correct default value in the DB

  @POST39
  Scenario: Do not send the status field in the request
    Given I create a request as follow
      | name      | random |
      | firstName | random |
      | lastName  | random |
      | email     | random |
      | password  | random |
      | status    | dont   |
    And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was created with a 201 status code
    And The status field should have the correct default value in the DB
