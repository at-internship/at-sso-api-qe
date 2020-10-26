@POSTTESTS
Feature: at-sso post operation

#Happy Path	
	@P1
	Scenario: Create a new user with valid parameters
		Given I have a name
			And I have a first name
			And I have a last name
			And I have an email
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was created with a 201 status code
	  	And The API should return a random id
	  	And I check that the element with this id exist in the DB

#name validations	  	
	@P2
	Scenario: Send a numeric value in the field name
		Given I have a name as numbers
			And I have a first name
			And I have a last name
			And I have an email
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code
	  
	@P3
	Scenario: Send an alphanumeric value in the field name
		Given I have a name as alphanumeric
			And I have a first name
			And I have a last name
			And I have an email
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code
	  
	@P4
	Scenario: Send special caracters as value in the field name
		Given I have a name as special caracters
			And I have a first name
			And I have a last name
			And I have an email
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code
	  
	@P5
	Scenario: Send the field name empty
		Given I have a name as empty field
			And I have a first name
			And I have a last name
			And I have an email
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code

	@P6
	Scenario: Send the field name as null
		Given I have a name as null
			And I have a first name
			And I have a last name
			And I have an email
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code

#first name validations	  
	@P7
	Scenario: Send a numeric value in the field firstName
		Given I have a name
			And I have a first name as numbers
			And I have a last name
			And I have an email
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code
	  
	@P8
	Scenario: Send an alphanumeric value in the field firstName
		Given I have a name
			And I have a first name as alphanumeric
			And I have a last name
			And I have an email
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code
	  
	@P9
	Scenario: Send special caracters value in the field firstName
		Given I have a name
			And I have a first name as special caracters
			And I have a last name
			And I have an email
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code
	  
	@P10
	Scenario: Send the field firstName empty
		Given I have a name
			And I have a first name as empty field
			And I have a last name
			And I have an email
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code
	  
	@P11
	Scenario: Send the field firstName as null
		Given I have a name
			And I have a first name as null
			And I have a last name
			And I have an email
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code

#last name validations
	@P12
	Scenario: Send a numeric value in the field lastName
		Given I have a name
			And I have a first name
			And I have a last name as numbers
			And I have an email
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code
	  
	@P13
	Scenario: Send an alphanumeric value in the field lastName
		Given I have a name
			And I have a first name
			And I have a last name as alphanumeric
			And I have an email
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code
	  
	@P14
	Scenario: Send special caracters value in the field lastName
		Given I have a name
			And I have a first name
			And I have a last name as special caracters
			And I have an email
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code
	  
	@P15
	Scenario: Send the field lastName empty
		Given I have a name
			And I have a first name
			And I have a last name as empty field
			And I have an email
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code
	  
	@P16
	Scenario: Send the field lastName as null
		Given I have a name
			And I have a first name
			And I have a last name as null
			And I have an email
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code
	  
#email validations
	@P17
	Scenario: Send double at in the email field
		Given I have a name
			And I have a first name
			And I have a last name
			And I have an email with double at
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code
	  
	@P18
	Scenario: Send a dot in the end of the email addres
		Given I have a name
			And I have a first name
			And I have a last name
			And I have an email with a dot in the end of the address
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code
	  
	@P19
	Scenario: Send only the domain part of the email
		Given I have a name
			And I have a first name
			And I have a last name
			And I have an email without name part
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code
	
	@P20
	Scenario: Send only the name part of the email
		Given I have a name
			And I have a first name
			And I have a last name
			And I have an email without domain part
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code

	@P21
	Scenario: Send invalid special caracters in the name part of the email
		Given I have a name
			And I have a first name
			And I have a last name
			And I have an email with special caracters in his name part
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code
	  
	@P22
	Scenario: Send upper and lower case mixed in the name part of the email
		Given I have a name
			And I have a first name
			And I have a last name
			And I have an email with upper and lower case in his name part
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was created with a 201 status code
	  	And The API should return a random id
	  	And I check that the element with this id exist in the DB
	  	And It should be registered in lowercase
	  	
	@P23
	Scenario: Send numbers in the name part of the email
		Given I have a name
			And I have a first name
			And I have a last name
			And I have an email with numbers in his name part
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was created with a 201 status code
	  	And The API should return a random id
	  	And I check that the element with this id exist in the DB
	  	
	@P24
	Scenario: Send an accent mark in the name part of the email
		Given I have a name
			And I have a first name
			And I have a last name
			And I have an email with accent mark in his name part
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code
	  
	@P25
	Scenario: Send invalid special caracters in the domain part of the email
		Given I have a name
			And I have a first name
			And I have a last name
			And I have an email with special caracters in his domain part
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code
	  
	@P26
	Scenario: Send upper and lower case mixed in the domain part of the email
		Given I have a name
			And I have a first name
			And I have a last name
			And I have an email with upper and lower case in his domain part
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was created with a 201 status code
	  	And The API should return a random id
	  	And I check that the element with this id exist in the DB
	  	And It should be registered in lowercase
	  	
	@P27
	Scenario: Send numbers in the domain part of the email
		Given I have a name
			And I have a first name
			And I have a last name
			And I have an email with numbers in his domain part
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was created with a 201 status code
	  	And The API should return a random id
	  	And I check that the element with this id exist in the DB
	  	
	@P28
	Scenario: Send an accent mark in the domain part of the email
		Given I have a name
			And I have a first name
			And I have a last name
			And I have an email with accent mark in his domain part
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code
	  
	@P29
	Scenario: Send a different domain than com or es in the email
		Given I have a name
			And I have a first name
			And I have a last name
			And I have an email with a different domain in his last part
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code
	  
	@P30
	Scenario: Send a registered email
		Given I have a name
			And I have a first name
			And I have a last name
			And I have a registered email
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code
	  
	@P31
	Scenario: Send the email field as empty
		Given I have a name
			And I have a first name
			And I have a last name
			And I have a email as empty field
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code

	@P32
	Scenario: Send a the email field defined as null
		Given I have a name
			And I have a first name
			And I have a last name
			And I have a email as null
			And I have a password
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code

#password validations
	@P33
	Scenario: Send a blank space in the password field
		Given I have a name
			And I have a first name
			And I have a last name
			And I have an email
			And I have a password with a blank space
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code
	  
	@P34
	Scenario: Send the password field empty
		Given I have a name
			And I have a first name
			And I have a last name
			And I have an email
			And I have a password as empty
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code
	  
	@P35
	Scenario: Send the password field as null
		Given I have a name
			And I have a first name
			And I have a last name
			And I have an email
			And I have a password as null
			And I have a status
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code

#status validations
	@P36
	Scenario: Send letters in the status field
		Given I have a name
			And I have a first name
			And I have a last name
			And I have an email
			And I have a password
			And I have a status as letters
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code

	@P37
	Scenario: Send alphanumeric value in the status field
		Given I have a name
			And I have a first name
			And I have a last name
			And I have an email
			And I have a password
			And I have a status as alphanumeric
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code
	  
	@P38
	Scenario: Send special caracters in the status field
		Given I have a name
			And I have a first name
			And I have a last name
			And I have an email
			And I have a password
			And I have a status as special caracters
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code
	  
	@P39
	Scenario: Send a negative number in the status field
		Given I have a name
			And I have a first name
			And I have a last name
			And I have an email
			And I have a password
			And I have a status as negative
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code
	  
	@P40
	Scenario: Send a longer number in the status field
		Given I have a name
			And I have a first name
			And I have a last name
			And I have an email
			And I have a password
			And I have a status as a longer number
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code
	  
	@P41
	Scenario: Send the status field empty
		Given I have a name
			And I have a first name
			And I have a last name
			And I have an email
			And I have a password
			And I have a status as empty field
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code
	  
	@P42
	Scenario: Send the status field as null
		Given I have a name
			And I have a first name
			And I have a last name
			And I have an email
			And I have a password
			And I have a status as null
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code
	  
	@P43
	Scenario: Send a differen value than zero or one in the status field
		Given I have a name
			And I have a first name
			And I have a last name
			And I have an email
			And I have a password
			And I have a status as another value than zero or one
			And I prepare the resource
	  When I send the info to create the resource at the API
	  Then The API should indicate that the resource was not created with a 400 status code

  @P44
  Scenario: POST request should return encoded passwords on SSO-API database
    Given I have a name
      And I have a first name
      And I have a last name
      And I have an email
      And I have a password
      And I have a status
      And I prepare the resource
    When I send the info to create the resource at the API
    Then The API should indicate that the resource was created with a 201 status code
	  And The API should return a random id
	  And I validate password should be encoded