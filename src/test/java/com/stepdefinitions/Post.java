package com.stepdefinitions;

import static org.junit.Assert.assertEquals;

import org.json.JSONArray;
import org.json.JSONObject;

import com.globalClasses.ApiPaths;
import com.globalClasses.ApiTools;
import com.globalClasses.BasicSecurityUtil;
import com.globalClasses.MongoDBUtils;
import com.globalClasses.TestValues;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Post {
	private BasicSecurityUtil base;
	String name, firstName, lastName, email, password;
	String stat=null;
	long status;
	int flag;
	TestValues values = new TestValues();
	JSONObject obj = new JSONObject();
	JSONArray jsonResult = new JSONArray();
	
	public Post(BasicSecurityUtil base){
		this.base = base;
	}

//Happy Path	
	@Given("I have a name")
	public void i_have_a_name() {
		name = values.randomFirstName();
	}

	@Given("I have a first name")
	public void i_have_a_first_name() {
	    firstName = name;
	}

	@Given("I have a last name")
	public void i_have_a_last_name() {
	    lastName = values.randomLastName();
	}

	@Given("I have an email")
	public void i_have_an_email() {
	    email = values.randomEmail();
	}

	@Given("I have a password")
	public void i_have_a_password() {
	    password = values.randomPassword();
	}

	@Given("I have a status")
	public void i_have_a_status() {
	    status = (int) (Math.random()*(1-0+1)+0);
	    flag=0;
	}

//name validations
	@Given("I have a name as numbers")
	public void i_have_a_name_as_numbers() {
		name = values.randomNumber();
	}
	
	@Given("I have a name as alphanumeric")
	public void i_have_a_name_as_alphanumeric() {
		name = values.randomAlphanumeric();
	}
	
	@Given("I have a name as special caracters")
	public void i_have_a_name_as_special_caracters() {
		name = values.randomSpecialCharacteres();
	}
	
	@Given("I have a name as empty field")
	public void i_have_a_name_as_empty_field() {
		name = "";
	}
	
	@Given("I have a name as null")
	public void i_have_a_name_as_null() {
		name = null;
	}
	
//first name validations	
	@Given("I have a first name as numbers")
	public void i_have_a_first_name_as_numbers() {
	    firstName = values.randomNumber();
	}
	
	@Given("I have a first name as alphanumeric")
	public void i_have_a_first_name_as_alphanumeric() {
	    firstName = values.randomAlphanumeric();
	}
	
	@Given("I have a first name as special caracters")
	public void i_have_a_first_name_as_special_caracters() {
	    firstName = values.randomSpecialCharacteres();
	}
	
	@Given("I have a first name as empty field")
	public void i_have_a_first_name_as_empty_field() {
	    firstName = "";
	}
	
	@Given("I have a first name as null")
	public void i_have_a_first_name_as_null() {
	    firstName = null;
	}
	
//last name validations
	@Given("I have a last name as numbers")
	public void i_have_a_last_name_as_numbers() {
	    lastName = values.randomNumber();
	}
	
	@Given("I have a last name as alphanumeric")
	public void i_have_a_last_name_as_alphanumeric() {
	    lastName = values.randomAlphanumeric();
	}
	
	@Given("I have a last name as special caracters")
	public void i_have_a_last_name_as_special_caracters() {
	    lastName = values.randomSpecialCharacteres();
	}
	
	@Given("I have a last name as empty field")
	public void i_have_a_last_name_as_empty_field() {
	    lastName = "";
	}
	
	@Given("I have a last name as null")
	public void i_have_a_last_name_as_null() {
	    lastName = null;
	}

//email validations	
	@Given("I have an email with double at")
	public void i_have_an_email_with_double_at() {
	    email = values.randomFirstName()+"@"+values.randomEmail();
	}
	
	@Given("I have an email with a dot in the end of the address")
	public void i_have_an_email_with_dot_in_the_end_of_the_address() {
	    email = values.randomEmail()+".";
	}
	
	@Given("I have an email without name part")
	public void i_have_an_email_without_name_part() {
	    email = values.randomDomainPart();
	}
	
	@Given("I have an email without domain part")
	public void i_have_an_email_without_domain_part() {
	    email = values.randomFirstName().toLowerCase();
	}
	
	@Given("I have an email with special caracters in his name part")
	public void i_have_an_email_with_special_caracters_in_his_name_part() {
	    email = values.randomFirstName().toLowerCase()+values.randomSpecialCharacteres()+values.randomDomainPart();
	}
	
	@Given("I have an email with upper and lower case in his name part")
	public void i_have_an_email_with_upper_and_lower_case_in_his_name_part() {
	    email = values.randomFirstName()+values.randomDomainPart();
	}
	
	@Given("I have an email with numbers in his name part")
	public void i_have_an_email_with_numbers_in_his_name_part() {
	    email = values.randomFirstName().toLowerCase()+values.randomNumber()+values.randomDomainPart();
	}

	@Given("I have an email with accent mark in his name part")
	public void i_have_an_email_with_accent_mark_in_his_name_part() {
	    email = values.randomFirstName().toLowerCase()+values.randomAccentMark()+values.randomDomainPart();
	}
	
	@Given("I have an email with special caracters in his domain part")
	public void i_have_an_email_with_special_caracters_in_his_domain_part() {
		email = values.randomFirstName().toLowerCase()+"@"+values.randomSpecialCharacteres()+values.randomLastName().toLowerCase()+".com";
	}
	
	@Given("I have an email with upper and lower case in his domain part")
	public void i_have_an_email_with_upper_and_lower_case_in_his_domain_part() {
		email = values.randomFirstName().toLowerCase()+"@"+values.randomLastName()+".com";
	}
	
	@Given("I have an email with numbers in his domain part")
	public void i_have_an_email_with_numbers_in_his_domain_part() {
		email = values.randomFirstName().toLowerCase()+"@"+values.randomNumber()+values.randomLastName().toLowerCase()+".com";
	}

	@Given("I have an email with accent mark in his domain part")
	public void i_have_an_email_with_accent_mark_in_his_domain_part() {
		email = values.randomFirstName().toLowerCase()+"@"+values.randomAccentMark()+values.randomLastName().toLowerCase()+".com";
	}
	
	@Given("I have an email with a different domain in his last part")
	public void i_have_an_email_with_a_different_domain_in_his_last_part() {
		email = values.randomFirstName().toLowerCase()+"@"+values.randomLastName().toLowerCase()+".uk";
	}

	@Given("I have a registered email")
	public void i_have_a_registered_email() {
		JSONObject dbres;
		jsonResult = MongoDBUtils.showAll("TEST", "at-sso-db", "users");
		int arrayLength = jsonResult.length()-1;
		dbres = jsonResult.getJSONObject((int) (Math.random()*(arrayLength-0+1)+0));
		email = dbres.get("email").toString();
	} 
	
	@Given("I have a email as empty field")
	public void i_have_a_email_as_empty_field() {
		email = "";
	} 
	
	@Given("I have a email as null")
	public void i_have_a_email_as_null() {
		email = null;
	} 
	
//password validations
	@Given("I have a password with a blank space")
	public void i_have_a_password_with_a_blank_space() {
		password = values.randomPassword()+" ";
	}
	
	@Given("I have a password as empty")
	public void i_have_a_password_as_empty() {
		password = "";
	}
	
	@Given("I have a password as null")
	public void i_have_a_password_as_null() {
		password = null;
	}
	
//status validations
	@Given("I have a status as letters")
	public void i_have_a_status_as_letters() {
		stat = values.randomFirstName().toLowerCase();
		flag = 1;
	}
	
	@Given("I have a status as alphanumeric")
	public void i_have_a_status_as_alphanumeric() {
		stat = values.randomAlphanumeric();
		flag = 1;
	}
	
	@Given("I have a status as special caracters")
	public void i_have_a_status_as_special_caracters() {
		stat = values.randomSpecialCharacteres();
		flag = 1;
	}
	
	@Given("I have a status as negative")
	public void i_have_a_status_as_negative() {
		status = -1;
		flag = 0;
	}
	
	@Given("I have a status as a longer number")
	public void i_have_a_status_as_a_longer_number() {
		status = 2147483648L;
		flag = 0;
	}
	
	@Given("I have a status as null")
	public void i_have_a_status_as_null() {
		stat = null;
		flag = 1;
	}
	
	@Given("I have a status as empty field")
	public void i_have_a_status_as_empty_field() {
		stat = "";
		flag = 1;
	}
	
	@Given("I have a status as another value than zero or one")
	public void i_have_a_status_as_another_value_than_zero_or_one() {
		status = (int) (Math.random()*(9-2+1)+0);
		flag = 0;
	}
	
	
//last steps, existence validations and status codes
	@Given("I prepare the resource")
	public void i_prepare_the_resource() {
	    obj.put("name", name);
	    obj.put("firstName", firstName);
	    obj.put("lastName", lastName);
	    obj.put("email",email);
	    obj.put("password", password);
	    
	    if(flag==0) {
	    	obj.put("status", status);
	    } else {
	    	obj.put("status", stat);
	    }
	    base.requestBody = obj.toString();
	    stat = null;
	}
	
	@When("I send the info to create the resource at the API")
	public void i_send_the_info_to_create_the_resource_at_the_API() {
		 base.apiResource = ApiPaths.SSO_API_JAVA;
	     base.ServiceApi = new ApiTools();
	     base.response = base.ServiceApi.POSTMethod(base.apiResource,base.requestBody);
	     base.method = "POST";
	}

	@Then("The API should indicate that the resource was created with a {int} status code")
	public void the_API_should_indicate_that_the_resource_was_created_with_a_status_code(int statusCode) {
		int result = Integer.parseInt(base.response.getStatusCode().toString().substring(0, 3));
	  assertEquals(statusCode, result);
	}
	
	@Then("The API should return a random id")
	public void the_API_should_return_a_random_id() {
		base.responseBody = base.response.getBody();	
	}
	
	@Then("I check that the element with this id exist in the DB")
	public void i_check_that_the_element_with_this_id_exist_in_the_DB() {
		JSONObject result = new JSONObject(base.responseBody);
		JSONObject dbres;
		String idResp;
		jsonResult = MongoDBUtils.executeMyQueryID("TEST", "at-sso-db", "users", "_id", result.getString("id"));
		dbres = jsonResult.getJSONObject(0);
		String json = dbres.getJSONObject("_id").get("$oid").toString();
		idResp = result.get("id").toString();
		assertEquals(idResp, json );
	}
	
	@Then("The API should indicate that the resource was not created with a {int} status code")
	public void the_API_should_indicate_that_the_resource_was_not_created_with_a_status_code(int statusCode) {
		int result = Integer.parseInt(base.response.getStatusCode().toString().substring(0, 3));
	  assertEquals(statusCode, result);
	}
	
	@Then("It should be registered in lowercase")
	public void it_should_be_registered_in_lowercase() {
		JSONObject result = new JSONObject(base.responseBody);
		JSONObject dbres;
		jsonResult = MongoDBUtils.executeMyQueryID("TEST", "at-sso-db", "users", "_id", result.getString("id"));
		dbres = jsonResult.getJSONObject(0);
		String json = dbres.get("email").toString();
		assertEquals(email.toLowerCase(), json );
	}

	@Then("I validate password should be encoded")
	public void I_validate_password_should_be_encoded() {
		assert true == MongoDBUtils.compareEncodedPassword("TEST", "at-sso-db", "users", base.responseBody, base.requestBody);
	}
}
