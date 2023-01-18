package chain;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateEmployee extends BaseRestImpl {

	@Test(dependsOnMethods = "chain.CreateNewRecord.sendPostRequest")

	public void sendPutRequest() {
		RestAssured.baseURI = "https://crudcrud.com/api/b78ff13dd2e542ffa75c56768f5abc63/employee/";

		RequestSpecification inputRequest = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON)
				.body("{\r\n" +

						"       \"name\": \"Mariappan\",\r\n" + "       \"emp_id\": \"556800\",\r\n"
						+ "       \"account\": \"AC_1\"\r\n" + "}");

		Response response = inputRequest.put("_id");

		System.out.println(response.getStatusCode());
		response.prettyPrint();

		response.then().assertThat().statusCode(200);

	}

}