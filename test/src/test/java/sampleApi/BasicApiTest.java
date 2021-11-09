package sampleApi;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BasicApiTest {

	@Test(enabled=false)
	public void getusers() {
		 RestAssured.baseURI="https://reqres.in/" ;
		Response resp = null;
		resp = RestAssured.given().get("api/users?page=2");
		Reporter.log(resp.asString(), true);
		Reporter.log(resp.getStatusLine(), true);
	}
	
	@Test(enabled=false)
	public void getUser() {
		
		RestAssured.baseURI="https://reqres.in/" ;
		Response resp = null;
		resp = RestAssured.given().get("api/users/2");
		Reporter.log(resp.asString(), true);
		Reporter.log(resp.getStatusLine(), true);
	}

	@Test(enabled=false)
	public void creatUser() {
		
		    
		
		
		Map<Object ,Object> data=new HashMap<Object,Object>();
		data.put("name", "mat");
		data.put("job", "amma");
		JSONObject person = new JSONObject(data);
		
		String TestData = person.toJSONString();
		RestAssured.baseURI="https://reqres.in/" ;
		Response resp = null;
		resp = RestAssured.
				given().
				body(TestData).
				post("api/users");
		Reporter.log(resp.asString(), true);
		Reporter.log(resp.getStatusLine(), true);
		
	}
	@Test(enabled=true)
	public void UpdateUser() {

		Map<Object ,Object> data=new HashMap<Object,Object>();
		data.put("name", "ath");
		data.put("job", "leader");
		JSONObject person = new JSONObject(data);
		
		String TestData = person.toJSONString();
		RestAssured.baseURI="https://reqres.in/" ;
		Response resp = null;
		resp = RestAssured.
				given().
				body(TestData).
				post("api/users/2");
		Reporter.log(resp.asString(), true);
		Reporter.log(resp.getStatusLine(), true);
	}
}
