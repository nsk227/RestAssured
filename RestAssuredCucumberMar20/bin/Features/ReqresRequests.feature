Feature: Verify all reqres.in Requests for GEt, POST, PUT and Delete Operations

# GetListOfUser - Scenario 1
Scenario: Verify the Get List of Users Request
Given  Set the Parameter to page as 2
When Perform Get Operation to get the list of users
Then Verify the Status Code 
And Verify the Response Header Content-Type
And Verify the Response Header Server
And Verify the Response Header Content-Encoding
And Verify the Response Body for page
And Verify the Response Body for per_page
And Verify the Response Body for data id of the first user
And Verify the Response Body for data email of the first user
And Verify the Response Body for support url of the  first user

# GetListOfUser - Scenario 2
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