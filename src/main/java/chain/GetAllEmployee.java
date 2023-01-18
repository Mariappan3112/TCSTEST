package chain;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllEmployee extends BaseRestImpl {

	@Test(dependsOnMethods="chain.CreateNewRecord.sendPostRequest")
	public void sendGetRequest() {

		RestAssured.baseURI = "https://crudcrud.com/api/b78ff13dd2e542ffa75c56768f5abc63/employee";

		RequestSpecification inputRequest = RestAssured.given().relaxedHTTPSValidation();
		Response response = inputRequest.get();
		
		System.out.println(response.getStatusCode());
		response.prettyPrint();
		
		response.then().assertThat().statusCode(200);

	}

}
