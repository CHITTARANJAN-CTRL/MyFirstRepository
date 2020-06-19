package sdet;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC_005_GetResponseBody 
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
		System.out.println("status code is:"+status);		
		Assert.assertEquals(body.contains("per_page"),true);
		
        // multiple Response body
		JsonPath json=rep.jsonPath();
		System.out.println(json.get("page"));
		System.out.println(json.get("per_page"));
		System.out.println(json.get("total"));
		System.out.println(json.get("total_pages"));
		System.out.println(json.get("data"));
		
		Assert.assertEquals(json.get("page"),2);
		
}

}