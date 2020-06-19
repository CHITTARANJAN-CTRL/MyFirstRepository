package sdet;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC_003_GetRequest
{
	@Test
	public void m1()
	{
		
		RestAssured.baseURI="https://reqres.in/";
		RestAssured.basePath="/api";
		RequestSpecification req=RestAssured.given();
		Response rep=req.given().log().all().get("/users?page=2");
		String body=rep.getBody().asString();
		
		int status= rep.getStatusCode();
		Assert.assertEquals(status, 200);
		
		System.out.println("status code is:"+status);
		
		String contentheader=rep.header("Content-Type");
		Assert.assertEquals(contentheader, "application/json; charset=utf-8");
		System.out.println("status header is:"+contentheader);
		
		String powerheader= rep.header("X-Powered-By");
		Assert.assertEquals(powerheader, "Express");
		System.out.println("status header is:"+powerheader);
	}

}
