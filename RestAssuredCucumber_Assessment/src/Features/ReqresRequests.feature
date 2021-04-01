Feature: Verify all reqres.in Requests for GEt, POST, PUT and Delete Operations

# GetListOfUser - Scenario 1
Scenario: Verify the Get List of Users Request
Given The Request End Point is "https://reqres.in"
And  Set the Parameter to page as "2"
When Perform Get Operation  with relative url "/api/users"
Then Verify the Status Code 200
And Verify the Response Header Content-Type "application/json; charset=utf-8" 
And Verify the Response Header Server "cloudflare"
And Verify the Response Header Content-Encoding "gzip"
And Verify the Response Body for page 2
And Verify the Response Body for per_page 6
And Verify the Response Body for data id 7 of the first user
And Verify the Response Body for data email "michael.lawson@reqres.in" of the first user
And Verify the Response Body for support url "https://reqres.in/#support-heading" of the  first user

# GetSingleUser - Scenario 2
Scenario: Verify the Get Single User Request
Given The Request End Point is "https://reqres.in"
When Perform Get Operation  with relative url "/api/users/2"
Then Verify the Status Code 200
And Verify the Response Header Content-Type "application/json; charset=utf-8" 
And Verify the Response Header Server "cloudflare"
And Verify the Response Header Content-Encoding "gzip"
And Verify the Response Body for data id 2 
And Verify the Response Body for data email "janet.weaver@reqres.in"
And Verify the Response Body for data first_name "Janet"
And Verify the Response Body for data last_name "Weaver" 
And Verify the Response Body for data avatar "https://reqres.in/img/faces/2-image.jpg" 
And Verify the Response Body for support text "To keep ReqRes free, contributions towards server costs are appreciated!"

# CreateUser - Scenario 3
Scenario: Verify the Create User Request
Given The Request End Point is "https://reqres.in"
And Set the Request Header Content-Type "application/json; charset=utf-8" 
And Set the Request Body requestParamsAsString "name:morpheus,ob:leader"
When Perform Post Operation  with relative url "/api/users"
Then Verify the Status Code 201
And Verify the Response Header Content-Type "application/json; charset=utf-8" 
And Verify the Response Header Server "cloudflare"
And Verify the Response Body for name "morpheus"
And Verify the Response Body for job "leader" 

# UpdateUser - Scenario 4
Scenario: Verify the Update User Request
Given The Request End Point is "https://reqres.in"
And Set the Request Header Content-Type "application/json; charset=utf-8" 
And Set the Request Body requestParamsAsString "name:morpheus,ob:zion resident"
When Perform Put Operation  with relative url "/api/users/2"
Then Verify the Status Code 200
And Verify the Response Header Content-Type "application/json; charset=utf-8" 
And Verify the Response Header Server "cloudflare"
And Verify the Response Body for name "morpheus"
#And Verify the Response Body for job "zion resident" 


# DeleteUser - Scenario 5
Scenario: Verify the Delete User Request
Given The Request End Point is "https://reqres.in"
When Perform Delete Operation  with relative url "/api/users/2"
Then Verify the Status Code 204

