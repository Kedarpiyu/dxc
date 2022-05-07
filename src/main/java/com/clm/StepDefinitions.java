package com.clm;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

import java.nio.file.Files;
import java.nio.file.Paths;

public class StepDefinitions {

    RequestSpecification request;
    Response response;

    @Given("^user calling API for nace number (\\d+)$")
    public void calling_getNaceDetails(int naceNumber) throws Exception {
        RestAssured.baseURI  = "http://dummy.restapiexample.com";
        request = RestAssured.given();
        response = request.header("Content-Type", "application/json")
                   .when().get("/api/v1/getNaceDetail/{naceNumber}",naceNumber);
    }
    
    @When("^getNaceDetail API should return status 200$")
    public void called_API_Status_Check() throws Exception {
        int statusCode = response.getStatusCode();
        response.then().assertThat().statusCode(200);
        System.out.println(statusCode);
    }

    @Then("^Response should contains nace details$")
    public void response_validation() throws Exception {
        
        System.out.print(response.asString());
        response.then().assertThat.body(Matchers.equalTo(new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + 
         "\\src\\test\\resources\\userDetails398481.json")))));
      }

 }
