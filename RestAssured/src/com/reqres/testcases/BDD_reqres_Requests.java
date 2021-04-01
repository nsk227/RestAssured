package com.reqres.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BDD_reqres_Requests {
	RequestSpecification httpRequest = null;
    Response response = null;
    
    @BeforeMethod
    public void InitializeRequestURL() {
        RestAssured.baseURI = "https://reqres.in";
        httpRequest = RestAssured.given();
    }
    
    @Test(priority=0)
    public void GetSingleUser() {
    	System.out.println("======================================");
    	System.out.println("GetSingleUser");
    	System.out.println("======================================");
    	 response = httpRequest.get("/api/users/2");
    	 given --> precondition that applies to the testcase -
    	 when --> the actual steps or actions taken execute the testcase
    	 then --> verifies the outcome or verifies actual vs expected result
    	 GetListOfUsers - 
    	 Request URL = https://reqres.in/api/users?page=2
    	 Request Type = GET
    	 given => set param as  page=2
    	 when => request type with the relative url
    	         .get("/api/users")
    	 then => assert statuscode = 200
    	 and header Content-Type = application/json; charset=utf-8
    	 and header Server = cloudflare
    	 and header Content-Encoding = gzip
    	 and body page = 2
    	 and body per_page = 6
    	 and body data[0].id = 7
    	 and body data[0].email = michael.lawson@reqres.in
    	 and body support.url = "https://reqres.in/#support-heading"
}
