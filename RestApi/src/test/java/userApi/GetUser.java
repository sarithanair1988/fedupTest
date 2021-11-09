package userApi;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import  io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetUser {
	
	
	@Test
	public void getUser() {
		
		RestAssured.baseURI="https://reqres.in/";
		
		Response resp =null;
	resp=	RestAssured.given().
							get("api/users?page=2");
		
		System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 200);
									}

	@Test
	public void postUser() {
		
		String body ="{ \"name\": \"morpheus\", \"job\": \"leader\"}";
		RestAssured.baseURI="https://reqres.in/";
		
		Response resp =null;
	resp=	RestAssured.given().
								body(body).
						when().
							post("api/users");
	System.out.println(resp.asPrettyString());		     
		
		System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 201);
									}
	
	@Test
	public void patchUser() {
		
		Map<String,Object> body =new HashMap<String,Object>();
		body.put( "name", "morpheus");
		body.put("job", "zion resident");
		
		JSONObject data=new JSONObject(body);
		RestAssured.baseURI="https://reqres.in/";
		
		Response resp =null;
	resp=	RestAssured.given().
								body(data.toJSONString()).
						when().
							patch("api/users/2");
	System.out.println(resp.asPrettyString());		     
		
		System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 200);
									}
	@Test
	public void deleteUser() {
		
		RestAssured.baseURI="https://reqres.in/";
		
		Response resp =null;
	resp=	RestAssured.given().
						when().delete("api/users/2");	
		
		System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 204);
									}

	
}
