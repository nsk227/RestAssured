package com.reqres.testcases;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class Reqres_Requests {
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
    @Test
    (priority=1)
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
        @Test(priority=2)
        public void CreateUser() {
        	System.out.println("======================================");
        	System.out.println("CreateUser");
        	System.out.println("======================================");
        	JSONObject requestparams = new JSONObject();
        	requestparams.put("name","morpheus");
        	requestparams.put("job","leader");
        	httpRequest.body(requestparams.toJSONString());
        	response = httpRequest.post("/api/users");
        	System.out.println("Resopnse Code = "+response.statusCode());
        	System.out.println("Status Line = "+response.getStatusLine());
        	System.out.println("Resopnse Body = "+response.body().asString());
        	JsonPath js =response.jsonPath();
        	System.out.println("name = "+js.get("name"));//name=null
        	System.out.println("id = "+js.get("id"));
        	System.out.println("job = "+js.get("job"));//job=null
        	System.out.println("createdAt = "+js.get("createdAt"));
        	
    }

        @Test(priority=3)
        public void UpdateUser() {
        	System.out.println("======================================");
        	System.out.println("UpdateUser");
        	System.out.println("======================================");
        	int id =2;
        	JSONObject requestparams = new JSONObject();
        	requestparams.put("name","morpheus");
        	requestparams.put("job","zion resident");
        	httpRequest.body(requestparams.toJSONString());
        	response = httpRequest.put("/api/users/"+ id);
        	System.out.println("Resopnse Code = "+response.statusCode());
        	System.out.println("Status Line = "+response.getStatusLine());
        	System.out.println("Resopnse Body = "+response.body().asString());
        	JsonPath js =response.jsonPath();
        	System.out.println("name = "+js.get("name"));//name=null
        	System.out.println("id = "+js.get("id"));
        	System.out.println("job = "+js.get("job"));//job=null
        	System.out.println("createdAt = "+js.get("createdAt"));
        	
    }
        @Test(priority=4)
        public void DeleteUser() {
        	System.out.println("======================================");
        	System.out.println("DeleteUser");
        	System.out.println("======================================");
        	response = httpRequest.delete("/api/users/2");
        	System.out.println("Response Code = "+response.statusCode());
        	System.out.println("Status Line = "+response.getStatusLine());
        	System.out.println("Response Body = "+response.body());
        	
    }
    
}
