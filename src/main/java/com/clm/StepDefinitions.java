package com.clm;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class StepDefinitions {
    RequestSpecification request;
    @Given("^Login API is provided$")
    public void login_API_is_provided() throws Exception {
        RestAssured.baseURI  = "http://dummy.restapiexample.com";
        request = RestAssured.given();

    }
    Response response;
    @When("^User call login API$")
    public void user_call_login_API() throws Exception {
        request.header("Content-Type", "application/json");
        response = request.get("/api/v1/employee/1");

    }

    @Then("^a token will be generated$")
    public void a_token_will_be_generated() throws Exception {
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        System.out.print(response.asString());
      }

 }