package com.stepdefinitions;

import com.globalClasses.ApiPaths;
import com.globalClasses.ApiTools;
import com.globalClasses.BasicSecurityUtil;
import com.globalClasses.MyTools;
import com.globalClasses.MongoDBUtils;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Get {

    private BasicSecurityUtil base;
    int statusCodeRetrieved;
    public Get(BasicSecurityUtil base) {
        this.base = base;
    }

    MyTools myTools = new MyTools();

    @Given("I prepare the get operation for sso api")
    public void i_prepare_the_get_operation_for_sso_api() {
        base.param="";
    }

    @When("I call get request to api")
    public void i_call_get_request_to_api() {
        base.apiResource = ApiPaths.SSO_API_JAVA + base.param;
        base.ServiceApi = new ApiTools();
        base.response = base.ServiceApi.retrieve(base.apiResource);
        base.responseBody = base.response.getBody();
        base.method = "GET";
        statusCodeRetrieved = base.response.getStatusCodeValue();

        myTools.resource( ApiPaths.SSO_API_JAVA + base.param  );
        myTools.statusCode(String.valueOf(statusCodeRetrieved));
        myTools.responseBody(base.responseBody);
    }
    @Then("The status code should be {int}")
    public void the_status_code_should_be(int statusCode) {
        int result = Integer.parseInt(base.response.getStatusCode().toString().substring(0, 3));
        assertEquals(statusCode, result);
    }
    @Then("I validate the response for get all users")
    public void i_validate_the_response_for_get_all_users() {
        assert true == MongoDBUtils.compareAllJsonString("TEST", "at-sso-db", "users", base.responseBody);
    }

}
