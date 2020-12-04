package com.stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.globalClasses.ApiPaths;
import com.globalClasses.ApiTools;
import com.globalClasses.BasicSecurityUtil;
import com.globalClasses.MongoDBUtils;
import com.globalClasses.TestValues;

import domain.RequestPOST;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Post {
	private BasicSecurityUtil base;
	TestValues values = new TestValues();
	RequestPOST req = new RequestPOST();
	JSONObject obj = new JSONObject();
	JSONArray jsonResult = new JSONArray();

	public Post(BasicSecurityUtil base){
		this.base = base;
	}

	@Given("I create a request as follow")
	public void i_create_a_request_as_follow(Map<String, String> request) {
		//name validations
		if(StringUtils.isNotBlank(request.get("name"))) {
			if("random".equalsIgnoreCase(request.get("name"))) {	    		
				req.setName(values.randomFirstName());
			} else if("empty".equalsIgnoreCase(request.get("name"))) {
				req.setName("");
			} else if("null".equalsIgnoreCase(request.get("name"))) {
				req.setName(null);
			} else if("dont".equalsIgnoreCase(request.get("name"))) {
				req.setName("dont");
			} else {
				req.setName(request.get("name"));
			}
		}

		//firstName validations
		if(StringUtils.isNotBlank(request.get("firstName"))) {
			if("random".equalsIgnoreCase(request.get("firstName"))) {	    		
				req.setFirstName(values.randomFirstName());
			} else if("empty".equalsIgnoreCase(request.get("firstName"))) {
				req.setFirstName("");
			} else if("null".equalsIgnoreCase(request.get("firstName"))) {
				req.setFirstName(null);
			} else if("dont".equalsIgnoreCase(request.get("firstName"))) {
				req.setFirstName("dont");
			} else {
				req.setFirstName(request.get("firstName"));
			}
		}

		//lastName validations
		if(StringUtils.isNotBlank(request.get("lastName"))) {
			if("random".equalsIgnoreCase(request.get("lastName"))) {	    		
				req.setLastName(values.randomLastName());
			} else if("empty".equalsIgnoreCase(request.get("lastName"))) {
				req.setLastName("");
			} else if("null".equalsIgnoreCase(request.get("lastName"))) {
				req.setLastName(null);
			} else if("dont".equalsIgnoreCase(request.get("lastName"))) {
				req.setLastName("dont");
			} else {
				req.setLastName(request.get("lastName"));
			}
		}

		//email validations
		if(StringUtils.isNotBlank(request.get("email"))) {
			if("random".equalsIgnoreCase(request.get("email"))) {	    		
				req.setEmail(values.randomEmail());
			} else if("doubleAt".equalsIgnoreCase(request.get("email"))) {
				req.setEmail(values.randomFirstName()+"@"+values.randomEmail());
			} else if("finalDot".equalsIgnoreCase(request.get("email"))) {
				req.setEmail(values.randomEmail()+".");
			} else if("domain".equalsIgnoreCase(request.get("email"))) {
				req.setEmail(values.randomDomainPart());
			} else if("name".equalsIgnoreCase(request.get("email"))) {
				req.setEmail(values.randomFirstName().toLowerCase());
			} else if("nameSpecialCaracters".equalsIgnoreCase(request.get("email"))) {
				req.setEmail(values.randomFirstName().toLowerCase()+values.randomSpecialCharacteres()+values.randomDomainPart());
			} else if("nameUpperLower".equalsIgnoreCase(request.get("email"))) {
				req.setEmail(values.randomFirstName()+values.randomDomainPart());
			} else if("nameNumber".equalsIgnoreCase(request.get("email"))) {
				req.setEmail(values.randomFirstName().toLowerCase()+values.randomNumber()+values.randomDomainPart());
			} else if("nameAccent".equalsIgnoreCase(request.get("email"))) {
				req.setEmail(values.randomFirstName().toLowerCase()+values.randomAccentMark()+values.randomDomainPart());
			} else if("domainSpecialCaracters".equalsIgnoreCase(request.get("email"))) {
				req.setEmail(values.randomFirstName().toLowerCase()+"@"+values.randomSpecialCharacteres()+values.randomDomainPart());
			} else if("domainUpperLower".equalsIgnoreCase(request.get("email"))) {
				req.setEmail(values.randomFirstName().toLowerCase()+"@"+values.randomLastName()+".com");
			} else if("domainNumber".equalsIgnoreCase(request.get("email"))) {
				req.setEmail(values.randomFirstName().toLowerCase()+"@"+values.randomNumber()+values.randomLastName().toLowerCase()+".com");
			} else if("domainAccent".equalsIgnoreCase(request.get("email"))) {
				req.setEmail(values.randomFirstName().toLowerCase()+"@"+values.randomAccentMark()+values.randomLastName().toLowerCase()+".com");
			} else if("registered".equalsIgnoreCase(request.get("email"))) {
				JSONObject dbres;
				jsonResult = MongoDBUtils.showAll("TEST", "at-sso-db", "users");
				int arrayLength = jsonResult.length()-1;
				dbres = jsonResult.getJSONObject((int) (Math.random()*(arrayLength-0+1)+0));
				req.setEmail(dbres.get("email").toString());
			} else if("empty".equalsIgnoreCase(request.get("email"))) {
				req.setEmail("");
			} else if("null".equalsIgnoreCase(request.get("email"))) {
				req.setEmail(null);
			} else if("dont".equalsIgnoreCase(request.get("email"))) {
				req.setEmail("dont");
			} else {
				req.setEmail(request.get("email"));
			}
		}

		//password validations
		if(StringUtils.isNotBlank(request.get("password"))) {
			if("random".equalsIgnoreCase(request.get("password"))) {	    		
				req.setPassword(values.randomPassword());
			} else if("lineBreak".equalsIgnoreCase(request.get("password"))) {
				req.setPassword(values.randomPassword()+"\n"+values.randomPassword());
			} else if("blankSpace".equalsIgnoreCase(request.get("password"))) {
				req.setPassword(values.randomPassword()+" "+values.randomPassword());
			} else if("empty".equalsIgnoreCase(request.get("password"))) {
				req.setPassword("");
			} else if("null".equalsIgnoreCase(request.get("password"))) {
				req.setPassword(null);
			} else if("dont".equalsIgnoreCase(request.get("password"))) {
				req.setPassword("dont");
			} else {
				req.setPassword(request.get("password"));
			}
		}

		//status validations
		if(StringUtils.isNotBlank(request.get("status"))) {
			if("random".equalsIgnoreCase(request.get("status"))) {	    		
				req.setStatus(String.valueOf((int) (Math.random()*(1-0+1)+0)));
			} else if("letters".equalsIgnoreCase(request.get("status"))) {
				req.setStatus(values.randomFirstName().toLowerCase());
			} else if("alphanumeric".equalsIgnoreCase(request.get("status"))) {
				req.setStatus(values.randomAlphanumeric());
			} else if("specialCaracters".equalsIgnoreCase(request.get("status"))) {
				req.setStatus(values.randomSpecialCharacteres());
			} else if("negative".equalsIgnoreCase(request.get("status"))) {
				req.setStatus(String.valueOf(-1));
			} else if("noCeroOrOne".equalsIgnoreCase(request.get("status"))) {
				req.setStatus(String.valueOf((int) (Math.random()+2)));
			} else if("empty".equalsIgnoreCase(request.get("status"))) {
				req.setStatus("");
			} else if("null".equalsIgnoreCase(request.get("status"))) {
				req.setStatus(null);
			} else if("dont".equalsIgnoreCase(request.get("status"))) {
				req.setStatus("dont");
			} else {
				req.setStatus(request.get("status"));
			}
		}
	}

	//Request Body building
	@Given("I prepare the resource")
	public void i_prepare_the_resource() {
		base.requestBody = req.requestBody();
	}

	@When("I send the info to create the resource at the API")
	public void i_send_the_info_to_create_the_resource_at_the_API() {
		base.apiResource = ApiPaths.SSO_API_JAVA;
		base.ServiceApi = new ApiTools();
		base.response = base.ServiceApi.POSTMethod(base.apiResource,base.requestBody);
	}

	@Then("The API should indicate that the resource was created with a {int} status code")
	public void the_API_should_indicate_that_the_resource_was_created_with_a_status_code(int statusCode) {
		int result = Integer.parseInt(base.response.getStatusCode().toString().substring(0, 3));
		assertEquals(statusCode, result);
	}

	@Then("The API should return a random id")
	public void the_API_should_return_a_random_id() {
		base.responseBody = base.response.getBody();
		JSONObject result = new JSONObject(base.responseBody);
		result.has("id");
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
		assertEquals(req.getEmail().toLowerCase(), json );
	}

	@Then("I validate password should be encoded")
	public void I_validate_password_should_be_encoded() {
		assert true == MongoDBUtils.compareEncodedPassword("TEST", "at-sso-db", "users", base.responseBody, base.requestBody);
	}

	@Then("The name field should have the correct default string in the DB")
	public void the_name_field_should_have_the_correct_default_string_in_the_DB() {
    base.responseBody = base.response.getBody();
		JSONObject result = new JSONObject(base.responseBody);
		JSONObject dbres;
		jsonResult = MongoDBUtils.executeMyQueryID("TEST", "at-sso-db", "users", "_id", result.getString("id"));
		dbres = jsonResult.getJSONObject(0);
		String json = dbres.get("name").toString();
		String name = req.getFirstName()+" "+req.getLastName();
		assertEquals(name, json );
	}

	@Then("The status field should have the correct default value in the DB")
	public void the_status_field_should_have_the_correct_default_value_in_the_DB() {
    base.responseBody = base.response.getBody();
		JSONObject result = new JSONObject(base.responseBody);
		JSONObject dbres;
		jsonResult = MongoDBUtils.executeMyQueryID("TEST", "at-sso-db", "users", "_id", result.getString("id"));
		dbres = jsonResult.getJSONObject(0);
		String json = dbres.get("status").toString();
		assertEquals("1", json);
	}
}
