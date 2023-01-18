package cucumber.steps;

import java.io.File;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EMPLOYEE {

	public static String _id;

	RequestSpecification inputRequest;
	Response response;

	@Given("Set the endpoint for EMPLOYEE")
	public void setEndPoint() {
		RestAssured.baseURI = "https://crudcrud.com/api/b78ff13dd2e542ffa75c56768f5abc63/employee";
	}

	@And("Set the authentication for EMPLOYEE")
	public void setAuth() {
		inputRequest = RestAssured.given();

	}

	@Given("Set the request header content-type in the create EMPLOYEE request")
	public void setContentType() {
		inputRequest.contentType(ContentType.JSON);
	}

	@And("Set the request body as {string} in the create EMPLOYEE request")
	public void setRequestBody(String fileName1) {
		File inputFile = new File("./data/" + fileName1 + ".json");
		inputRequest.body(inputFile);
	}

	@When("User send the POST request to EMPLOYEE")
	public void sendPostRequest() {
		response = inputRequest.when().post();
		response.then().log().all();

		_id = response.jsonPath().get("_id");
		System.out.println("ID: " + _id);
	}

	@Given("Set the request header content-type in the update EMPLOYEE request")
	public void setContentType2() {
		inputRequest.contentType(ContentType.JSON);
	}

	@And("Set the request body as {string} in the update EMPLOYEE request")
	public void setRequestBody1(String fileName1) {
		File inputFile = new File("./data/" + fileName1 + ".json");
		inputRequest.body(inputFile);
	}

	@When("User send the PUT request to EMPLOYEE")
	public void sendPUTRequest() {
		response = inputRequest.when().put();
		response.then().log().all();
	}

	@When("User send the Particular Get request to EMPLOYEE request")
	public void sendGetRequest() {
		response = inputRequest.when().get(_id);
		response.then().log().all();
	}

	@When("User send the Get All request")
	public void sendGetRequest1() {
		response = inputRequest.when().get();
		response.then().log().all();
	}

	@When("User send the Particular Delete request to EMPLOYEE request")
	public void sendDeleteRequest() {
		response = inputRequest.when().delete(_id);
		response.then().log().all();
	}

	@Then("Validate the status code as {int} in the create EMPLOYEE request")
	public void validateStatusCode(int statusCode) {
		response.then().assertThat().statusCode(statusCode);
	}

	@Then("Validate the status code as {int} in the update EMPLOYEE request")
	public void validateStatusCode5(int statusCode) {
		response.then().assertThat().statusCode(statusCode);

	}

	@Then("Validate the status code as {int} in the Get EMPLOYEE request")
	public void validateStatusCode2(int statusCode) {
		response.then().assertThat().statusCode(statusCode);

	}

	@Then("Validate the status code as {int} in the Get EMPLOYEES request")
	public void validateStatusCode3(int statusCode) {
		response.then().assertThat().statusCode(statusCode);

	}

	@Then("Validate the status code as {int} in the Delete EMPLOYEE request")
	public void validateStatusCode4(int statusCode) {
		response.then().assertThat().statusCode(statusCode);

	}

}
