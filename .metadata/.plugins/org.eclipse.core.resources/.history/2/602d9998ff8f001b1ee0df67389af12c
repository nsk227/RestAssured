package StepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

public class reqresStepDefinitions {
	RequestSpecification httpRequest = null;
	Response response = null;
	ValidatableResponse json = null;

@Given("^Set the Parameter to page as (\\d+)$")
public void set_the_Parameter_to_page_as(int arg1) throws Exception {
    // Write code here that turns the phrase above into concrete actions
	//RestAssured.baseURI = "https://reqres.in";
	RestAssured.baseURI=RequestURL;
	httpRequest = RestAssured.given();
	//httpRequest.given().param("page","2");
	httpRequest.given().param("page",page);
	
	
}

@When("^Perform Get Operation to get the list of users$")
public void perform_Get_Operation_to_get_the_list_of_users(String relativeurl) throws Exception {
    // Write code here that turns the phrase above into concrete actions
   //response = httpRequest.when().get("/api/users");
	response=httpRequest.when().get(relativeurl);
			}

@Then("^Verify the Status Code$")
public void verify_the_status_code() throws Exception {
    // Write code here that turns the phrase above into concrete actions
	json = response.then().assertThat().statusCode(200);
}

@Then("^Verify the Response Header Content-Type$")
public void verify_the_Response_Header_Content_Type() throws Exception {
    // Write code here that turns the phrase above into concrete actions
	json = response.then().assertThat().header("Content-Type","application/json; charset=utf-8");
}

@Then("^Verify the Response Header Server$")
public void verify_the_Response_Header_server() throws Exception {
    // Write code here that turns the phrase above into concrete actions
	json = response.then().assertThat().header("Server","cloudflare");
}

@Then("^Verify the Response Header Content-Encoding$")
public void verify_the_Response_Header_content_encoding() throws Exception {
    // Write code here that turns the phrase above into concrete actions
	json = response.then().assertThat().header("Content-Encoding","gzip");

}

@Then("^Verify the Response Body for page$")
public void verify_the_Response_Body_for_Page() throws Exception {
    // Write code here that turns the phrase above into concrete actions
	json = response.then().assertThat().body("page",equalTo(2));
}

@Then("^Verify the Response Body for per_page$")
public void verify_the_Response_Body_for_per_page() throws Exception{
	json = response.then().assertThat().body("per_page",equalTo(6));

}

@Then("^Verify the Response Body for data id of the first user$")
public void verify_the_data_id_of_the_first_user() throws Exception {
    // Write code here that turns the phrase above into concrete actions
	json = response.then().assertThat().body("data[0].id",equalTo(7));
}

@Then("^Verify the Response Body for data email of the first user$")
public void verify_the_data_email_of_the_first_user() throws Exception {
    // Write code here that turns the phrase above into concrete actions
	json = response.then().assertThat().body("data[0].email",equalTo("michael.lawson@reqres.in"));
}

@Then("^Verify the Response Body for support url of the  first user$")
public void verify_the_support_url_of_the_first_user() throws Exception {
    // Write code here that turns the phrase above into concrete actions
	json = response.then().assertThat().body("support.url",equalTo("https://reqres.in/#support-heading"));

}

@Given("^The Request End Point is \"([^\"]*)\"$")
public void the_Request_End_Point_is(String arg1) throws Exception {
    // Write code here that turns the phrase above into concrete actions
   
}

@When("^Perform Get Operation  with relative url \"([^\"]*)\" to get the list of users$")
public void perform_Get_Operation_with_relative_url_to_get_the_list_of_users(String arg1) throws Exception {
    // Write code here that turns the phrase above into concrete actions
   
}

@Then("^Verify the Status Code (\\d+)$")
public void verify_the_Status_Code(int arg1) throws Exception {
    // Write code here that turns the phrase above into concrete actions
    
}

@Then("^Verify the Response Header Content-Type \"([^\"]*)\"$")
public void verify_the_Response_Header_Content_Type(String arg1) throws Exception {
    // Write code here that turns the phrase above into concrete actions
    
}

@Then("^Verify the Response Header Server \"([^\"]*)\"$")
public void verify_the_Response_Header_Server(String arg1) throws Exception {
    // Write code here that turns the phrase above into concrete actions
   
}

@Then("^Verify the Response Header Content-Encoding \"([^\"]*)\"$")
public void verify_the_Response_Header_Content_Encoding(String arg1) throws Exception {
    // Write code here that turns the phrase above into concrete actions
    
}

@Then("^Verify the Response Body for data id (\\d+)$")
public void verify_the_Response_Body_for_data_id(int id) throws Exception {
    // Write code here that turns the phrase above into concrete actions
	json =response.then().assertThat().body("data.id",equalTo(id));
}

@Then("^Verify the Response Body for data email \"([^\"]*)\"$")
public void verify_the_Response_Body_for_data_email(String email) throws Exception {
    // Write code here that turns the phrase above into concrete actions
	json =response.then().assertThat().body("data.email",equalTo(email));
}

@Then("^Verify the Response Body for data first_name \"([^\"]*)\"$")
public void verify_the_Response_Body_for_data_first_name(String firstname) throws Exception {
    // Write code here that turns the phrase above into concrete actions
	json =response.then().assertThat().body("data.firstname",equalTo(firstname));
}

@Then("^Verify the Response Body for data last_name \"([^\"]*)\"$")
public void verify_the_Response_Body_for_data_last_name(String lastname) throws Exception {
    // Write code here that turns the phrase above into concrete actions
	json =response.then().assertThat().body("data.lastname",equalTo(lastname));
}

@Then("^Verify the Response Body for data avatar \"([^\"]*)\"$")
public void verify_the_Response_Body_for_data_avatar(String avatar) throws Exception {
    // Write code here that turns the phrase above into concrete actions
	json =response.then().assertThat().body("data.avatar",equalTo(avatar));
}

@Then("^Verify the Response Body for support text \"([^\"]*)\"$")
public void verify_the_Response_Body_for_support_url(String supporttext) throws Exception {
    // Write code here that turns the phrase above into concrete actions
   json =response.then().assertThat().body("suppoort.text",equalTo(supporttext));
}



}