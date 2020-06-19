package sdet;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_002_POST 
{
	@Test
	public void postmethod()
	{
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification req=RestAssured.given();
		//RestAssured.basePath="";
		req.header("Content-Type","application/json");
		JSONObject obj=new JSONObject();
		obj.put("name","chitta");
		obj.put("job", "lead");
		req.body(obj.toJSONString());
	
		Response rep=req.post("/api/users");
		
		String responsebody=rep.getBody().asString();//we will get result in string format
		
		
		Assert.assertEquals(rep.getStatusCode(),201);
		System.out.println("status code is:"+rep.getStatusCode());
		rep.then().log().all();
		
	}

}
