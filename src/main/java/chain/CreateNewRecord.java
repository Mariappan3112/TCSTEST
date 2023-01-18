package chain;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateNewRecord extends BaseRestImpl {

	@Test
	public void sendPostRequest() {

		RestAssured.baseURI = "https://crudcrud.com/api/b78ff13dd2e542ffa75c56768f5abc63/employee";

		RequestSpecification inputRequest = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON)
				.body("{\r\n" +

						"       \"name\": \"Mariappan\",\r\n" + "       \"emp_id\": \"556800\",\r\n"
						+ "       \"account\": \"AC\"\r\n" + "}");

		Response response = inputRequest.post();
		System.out.println(response.getStatusCode());
		response.prettyPrint();

		String id = response.jsonPath().get("_id");
		System.out.println("ID: " + id);

		response.then().assertThat().statusCode(201);

	}

}
