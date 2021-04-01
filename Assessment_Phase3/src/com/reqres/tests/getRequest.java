package com.reqres.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getRequest {
	RequestSpecification httpRequest = null;
	Response response = null;

	@BeforeMethod
	public void InitializeRequestURL() {
		RestAssured.baseURI = "https://reqres.in";
		httpRequest = RestAssured.given();
	}
	@Test
	(priority=0)
	public void GetListOfUsers() {
		response  = httpRequest.get("/api/users?page=2");
		System.out.println("======================================");
		System.out.println("GetListOfUsers");
		System.out.println("======================================");
		System.out.println("Response Code = " + response.statusCode());
		System.out.println("Status Line = " + response.getStatusLine());
		System.out.println("Response Body = " + response.body().asString());
		int size = response.jsonPath().get("data.size");
		JsonPath js=response.jsonPath();
		for (int i=0; i<size; i++) {
			System.out.println(i+"th element - id=" + js.get("data["+i+"].id"));
			System.out.println(i+"th element - email=" + js.get("data["+i+"].email"));
			System.out.println(i+"th element - first_name=" + js.get("data["+i+"].first_name"));
			System.out.println(i+"th element - last_name=" + js.get("data["+i+"].last_name"));
			System.out.println(i+"th element - avatar=" + js.get("data["+i+"].avatar"));
		}
		Headers headers=response.getHeaders();
		for(Header header:headers) {
			System.out.println(header.getName()+ "=" + header.getValue());
		}
	}

	@Test(priority=1)
	public void GetSingleUser() {
		System.out.println("======================================");
		System.out.println("GetSingleUser");
		System.out.println("======================================");
		response = httpRequest.get("/api/users/2");
		System.out.println("Response Code = " + response.statusCode());
		System.out.println("Status Line = " + response.getStatusLine());
		System.out.println("Response Body = " + response.body().asString());
		JsonPath js=response.jsonPath();
		System.out.println("Get id = "+js.get("data.id"));
		System.out.println("Get email = "+js.get("data.email"));
		System.out.println("Get first_name = "+js.get("data.first_name"));
		System.out.println("Get last_name = "+js.get("data.last_name"));
		System.out.println("Get avatar = "+js.get("data.avatar"));
		System.out.println("Get text = "+js.get("support.text"));
		System.out.println("Get url = "+js.get("support.url"));
	}
	@Test(priority=2)
	public void SingleUserNotFound() {
		System.out.println("======================================");
		System.out.println("SingleUserNotFound");
		System.out.println("======================================");
		response = httpRequest.get("/api/users/23");
		System.out.println("Response Code = " + response.statusCode());
		System.out.println("Status Line = " + response.getStatusLine());
		System.out.println("Response Body = " + response.body().asString());

	}
	@Test
	(priority=3)
	public void GetListOfResources() {
		response  = httpRequest.get("/api/unknown");
		System.out.println("======================================");
		System.out.println("GetListOfResources");
		System.out.println("======================================");
		System.out.println("Response Code = " + response.statusCode());
		System.out.println("Status Line = " + response.getStatusLine());
		System.out.println("Response Body = " + response.body().asString());
		int size = response.jsonPath().get("data.size");
		JsonPath js=response.jsonPath();
		for (int j=0; j<size; j++) {
			System.out.println(j+"th element - id=" + js.get("data["+j+"].id"));
			System.out.println(j+"th element - name=" + js.get("data["+j+"].name"));
			System.out.println(j+"th element - year=" + js.get("data["+j+"].year"));
			System.out.println(j+"th element - color=" + js.get("data["+j+"].color"));
			System.out.println(j+"th element - pantone_value=" + js.get("data["+j+"].pantone_value"));
		}
	}
	@Test
	(priority=4)
	public void GetSingleResources() {
		response  = httpRequest.get("/api/unknown/2");
		System.out.println("======================================");
		System.out.println("GetSingleResources");
		System.out.println("======================================");
		System.out.println("Response Code = " + response.statusCode());
		System.out.println("Status Line = " + response.getStatusLine());
		System.out.println("Response Body = " + response.body().asString());

	}
	@Test(priority=5)
	public void SingleResourceNotFound() {
		System.out.println("======================================");
		System.out.println("SingleResourceNotFound");
		System.out.println("======================================");
		response = httpRequest.get("/api/users/23");
		System.out.println("Response Code = " + response.statusCode());
		System.out.println("Status Line = " + response.getStatusLine());
		System.out.println("Response Body = " + response.body().asString());
	}
}
