package mukeshotwani;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_002_DeleteRequest 
{
	@Test
	public void m1()
	{
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api";
		RequestSpecification request=RestAssured.given().log().all();
		Response rep=request.delete("/users/1");
		int status=rep.getStatusCode();
		System.out.println("code is:"+status);

}
}