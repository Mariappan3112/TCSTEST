package chain;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteEmployee extends BaseRestImpl {

	@Test(dependsOnMethods="chain.GetEmployee.sendGetRequest")
	public void sendDeleteRequest() {
		RestAssured.baseURI= "https://crudcrud.com/api/b78ff13dd2e542ffa75c56768f5abc63/employee/";
		
		RequestSpecification inputRequest = RestAssured
				.given().relaxedHTTPSValidation()
				.contentType(ContentType.JSON);
		
		Response response = inputRequest.delete("_id");
		
		System.out.println(response.getStatusCode());
		response.prettyPrint();
		
		response.then().assertThat().statusCode(404);
		
	}

}
