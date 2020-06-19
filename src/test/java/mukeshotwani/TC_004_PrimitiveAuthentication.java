package mukeshotwani;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_004_PrimitiveAuthentication 
{
	@Test
	public void m1()
	{
		RestAssured.given().auth().preemptive().basic("ToolsQA","TestPassword")
		.get("http://restapi.demoqa.com/authentication/CheckForAuthentication");
		
		//System.out.println("response is:"+rep.getStatusCode());
	}

}
