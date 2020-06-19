package mukeshotwani;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC_001_PostRequest
{
	@Test
	public void m1()
	{
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api";
		RequestSpecification request=RestAssured.given().log().all();
		request.header("Content-Type","application/json");
		JSONObject json=new JSONObject();
		json.put("name","chitta");
		json.put("job","boss");
		
		request.body(json.toJSONString());
		
		Response rep=request.log().all().post("/users");
		
	int statuscode=rep.getStatusCode();
	Assert.assertEquals(statuscode, 201);
		
		
	}

}
