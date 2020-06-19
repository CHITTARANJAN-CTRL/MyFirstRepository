package sdet;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC_001_GetRequest {
	

	 @Test
	 public void WeatherDetails() {
	  RestAssured.baseURI="https://reqres.in/";
	  RestAssured.basePath="api/users?page=2";
	  
	  Response rep=RestAssured.given().log().all().get();
	  
	  
	  int x=rep.getStatusCode(); 
	  System.out.println("status code is:"+x);
	  Assert.assertEquals(x,200);
	  
	  String statuscode1=rep.getStatusLine();
	  System.out.println("status line is:"+statuscode1);
	  rep.then().log().all();
	 

	 }


}


