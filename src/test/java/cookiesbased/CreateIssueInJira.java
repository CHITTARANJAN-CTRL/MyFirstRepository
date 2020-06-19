package cookiesbased;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateIssueInJira 
{
	
	@Test
	public void createID()
	{
		JSONObject json=new JSONObject();
		json.put("username","myuser");
		json.put("password","mypassword");
		
		Response rep=RestAssured.given()
		.header("Content_type","Application/Json")
		.body(json)
		.post("http://jira.example.com:8090/jira/rest/auth/1/session");
		
		System.out.println(rep.getStatusCode());
	}

}
