package sdet;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC_004_GetAllHeaders 
{
	@Test
	public void getRequestWithAllHeaders()
	{   
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification req=RestAssured.given();
		Response rep=req.get("/api/users?page=2");
		
		
		int status= rep.getStatusCode();
		Assert.assertEquals(status, 200);
		
		System.out.println("status code is:"+status);
		
		Headers allheader=rep.headers();
		
		for(Header header:allheader)
		{
			System.out.println(header.getName()+" "+header.getValue());			
		}	
	}

}
