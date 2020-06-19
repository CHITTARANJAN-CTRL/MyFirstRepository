package sdet;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testutil.Utilities;

public class TC_006_DataProvider 
{
	@Test(dataProvider="mydata")
	public void m1(String name,String position)
	{
	RestAssured.baseURI="https://reqres.in/";
	RequestSpecification req=RestAssured.given();
	
	
	req.header("Content-Type","application/json");
	JSONObject obj=new JSONObject();
	obj.put("name","name");
	obj.put("job", "position");
	req.body(obj.toJSONString());
    
	
	Response rep=req.post("/api/users");
	
	String responsebody=rep.getBody().asString();
	System.out.println("the resonse body is:"+responsebody);
}
	@DataProvider(name="mydata")
	public Object[][] data() throws IOException
	{
		
		String path="D:\\Chittaranjan\\RestAPI\\src\\test\\java\\testutil\\apidata.xlsx";
		int rowCount=Utilities.getRowCount(path, "Sheet1");
		int columnCount=Utilities.getCellCount(path, "Sheet1", 1);
		Object [][]obj= new Object[rowCount][columnCount];
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<columnCount;j++)
			{
				obj[i-1][j]=Utilities.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return obj;
	}
}