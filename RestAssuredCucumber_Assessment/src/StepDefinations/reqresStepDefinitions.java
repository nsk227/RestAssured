package StepDefinations;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class reqresStepDefinitions {
	RequestSpecification httpRequest = null;
	Response response = null;
	ValidatableResponse json = null;
	JSONObject requestParams = new JSONObject();
@Given("^The Request End Point is \"([^\"]*)\"$")
public void the_Request_End_Point_is(String RequestURL) throws Exception {
		//RestAssured.baseURI = "https://reqres.in";  		
	RestAssured.baseURI = RequestURL;
	System.out.println("RequesrURL = " + RequestURL);
	httpRequest = RestAssured.given();
}
	
@Given("^Set the Parameter to page as \"([^\"]*)\"$")
public void set_the_Parameter_to_page_as(String page) throws Exception {
    // Write code here that turns the phrase above into concrete actions
	//httpRequest.given().param("page","2");
	httpRequest.given().param("page",page);
	System.out.println("page = " + page);
}

@When("^Perform ([^\\\"]*) Operation  with relative url \"([^\"]*)\"$")
public void perform_Get_Operation_to_get_the_list_of_users(String RequestType, String relativeurl) throws Exception {
    // Write code here that turns the phrase above into concrete actions
    //response = httpRequest.when().get("/api/users");
	System.out.println("RequestType = " + RequestType);
	if(RequestType.equalsIgnoreCase("GET")) {
		response = httpRequest.when().get(relativeurl);
	}else if (RequestType.equalsIgnoreCase("POST")) {
		response = httpRequest.when().post(relativeurl);
	}else if (RequestType.equalsIgnoreCase("PUT")) {
		response = httpRequest.when().put(relativeurl);
	}else if (RequestType.equalsIgnoreCase("DELETE")) {
		response = httpRequest.when().delete(relativeurl);
	}
	System.out.println("relativeurl = " + relativeurl);
}

@Then("^Verify the Status Code (\\d+)$")
public void verify_the_status_code(int statusCode) throws Exception {
    // Write code here that turns the phrase above into concrete actions
	//json = response.then().assertThat().statusCode(200);
	json = response.then().assertThat().statusCode(statusCode);
	System.out.println("statusCode = " + statusCode);
}

@Then("^Verify the Response Header Content-Type \"([^\"]*)\"$")
public void verify_the_Response_Header_Content_Type(String ContentType) throws Exception {
    // Write code here that turns the phrase above into concrete actions
	//json = response.then().assertThat().header("Content-Type","application/json; charset=utf-8");
	json = response.then().assertThat().header("Content-Type",ContentType);
	System.out.println("Content-Type = " + ContentType);
}

@Then("^Verify the Response Header Server \"([^\"]*)\"$")
public void verify_the_Response_Header_server(String Server) throws Exception {
    // Write code here that turns the phrase above into concrete actions
	//json = response.then().assertThat().header("Server","cloudflare");
	json = response.then().assertThat().header("Server",Server);
	System.out.println("Server = " + Server);
}

@Then("^Verify the Response Header Content-Encoding \"([^\"]*)\"$")
public void verify_the_Response_Header_content_encoding(String ContentEncoding) throws Exception {
    // Write code here that turns the phrase above into concrete actions
	//json = response.then().assertThat().header("Content-Encoding","gzip");
	json = response.then().assertThat().header("Content-Encoding",ContentEncoding);
	System.out.println("ContentEncoding = " + ContentEncoding);
}

@Then("^Verify the Response Body for page (\\d+)$")
public void verify_the_Response_Body_for_Page(int page) throws Exception {
    // Write code here that turns the phrase above into concrete actions
	//json = response.then().assertThat().body("page",equalTo(2));
	json = response.then().assertThat().body("page",equalTo(page));
	System.out.println("page = " + page);
}

@Then("^Verify the Response Body for per_page (\\d+)$")
public void verify_the_Response_Body_for_per_page(int per_page) throws Exception{
	//json = response.then().assertThat().body("per_page",equalTo(6));
	json = response.then().assertThat().body("per_page",equalTo(per_page));
	System.out.println("per_page = " + per_page);
}

@Then("^Verify the Response Body for data id (\\d+) of the first user$")
public void verify_the_data_id_of_the_first_user(int id) throws Exception {
    // Write code here that turns the phrase above into concrete actions
	//json = response.then().assertThat().body("data[0].id",equalTo(7));
	json = response.then().assertThat().body("data[0].id",equalTo(id));
	System.out.println("datat[0].id = " + id);
}

@Then("^Verify the Response Body for data email \"([^\"]*)\" of the first user$")
public void verify_the_data_email_of_the_first_user(String email) throws Exception {
    // Write code here that turns the phrase above into concrete actions
	//json = response.then().assertThat().body("data[0].email",equalTo("michael.lawson@reqres.in"));
	json = response.then().assertThat().body("data[0].email",equalTo(email));
	System.out.println("datat[0].email = " + email);
}

@Then("^Verify the Response Body for support url \"([^\"]*)\" of the  first user$")
public void verify_the_support_url_of_the_first_user(String url) throws Exception {
    // Write code here that turns the phrase above into concrete actions
	//json = response.then().assertThat().body("support.url",equalTo("https://reqres.in/#support-heading"));
	json = response.then().assertThat().body("support.url",equalTo(url));
	System.out.println("support.url = " + url);
}

@Then("^Verify the Response Body for data id (\\d+)$")
public void verify_the_Response_Body_for_data_id(int id) throws Exception {
    // Write code here that turns the phrase above into concrete actions
	//json = response.then().assertThat().body("data.id",equalTo(2));
	json = response.then().assertThat().body("data.id",equalTo(id));
	System.out.println("data.id for Single User = " +id );
}

@Then("^Verify the Response Body for data email \"([^\"]*)\"$")
public void verify_the_Response_Body_for_data_email(String email) throws Exception {
    // Write code here that turns the phrase above into concrete actions
	json = response.then().assertThat().body("data.email",equalTo(email));
	System.out.println("data.id for Single User = " +email );
}

@Then("^Verify the Response Body for data first_name \"([^\"]*)\"$")
public void verify_the_Response_Body_for_data_first_name(String firstname) throws Exception {
    // Write code here that turns the phrase above into concrete actions

	json = response.then().assertThat().body("data.first_name",equalTo(firstname));
	System.out.println("data.id for Single User = " +firstname );

}

@Then("^Verify the Response Body for data last_name \"([^\"]*)\"$")
public void verify_the_Response_Body_for_data_last_name(String lastname) throws Exception {
    // Write code here that turns the phrase above into concrete actions
	//json = response.then().assertThat().body("data.id",equalTo(2));
	json = response.then().assertThat().body("data.last_name",equalTo(lastname));
	System.out.println("data.id for Single User = " +lastname);

}

@Then("^Verify the Response Body for data avatar \"([^\"]*)\"$")
public void verify_the_Response_Body_for_data_avatar(String avatar) throws Exception {
    // Write code here that turns the phrase above into concrete actions
	json = response.then().assertThat().body("data.avatar",equalTo(avatar));
	System.out.println("data.id for Single User = " +avatar );

}

@Then("^Verify the Response Body for support text \"([^\"]*)\"$")
public void verify_the_Response_Body_for_support_text(String supporttext) throws Exception {
    // Write code here that turns the phrase above into concrete actions
	
	json = response.then().assertThat().body("support.text",equalTo(supporttext));
	System.out.println("data.id for Single User = " +supporttext );
}

@Given("^Set the Request Header Content-Type \"([^\"]*)\"$")
public void set_the_Request_Header_Content_Type(String ContentType) throws Exception {
    // Write code here that turns the phrase above into concrete actions
	//httpRequest.given().header("Content-Type","application/json; charset=utf-8");
	httpRequest.given().header("Content-Type",ContentType);
	System.out.println("Content Type  for Create User = " +ContentType );

}

@Given("^Set the Request Body requestParamsAsString \"([^\"]*)\"$")
public void set_the_Request_Body_requestParamsAsString(String Params) throws Exception {
    // Write code here that turns the phrase above into concrete actions
	String[]  p = Params.split(",");
	String[] r = p[0].split(":"); 	
	requestParams.put("name","morpheus");
	requestParams.put("job","leader");
	httpRequest.given().body(requestParams.toJSONString());
}

@Then("^Verify the Response Body for name \"([^\"]*)\"$")
public void verify_the_Response_Body_for_name(String name) throws Exception {
    // Write code here that turns the phrase above into concrete actions
	json = response.then().assertThat().body("name",equalTo(name));
	System.out.println("Response Body name  for Create User = " +name );
}

@Then("^Verify the Response Body for job \"([^\"]*)\"$")
public void verify_the_Response_Body_for_job(String job) throws Exception {
    // Write code here that turns the phrase above into concrete actions
	json = response.then().assertThat().body("job",equalTo(job));
	System.out.println("Response Body job  for Create User = " +job );
}


}
