package iOSWhiteLabelReg;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GetRegCode {
	
	public String RegistrationCode(String username, String ClientKey)
	{
		RestAssured.baseURI = "https://sptapi001.paypoint.com/PP.SmartPay.Api/query/code/registration";//UAT
		//RestAssured.baseURI = "http://81.93.224.158/HttpProxyServer/SmartPayQueryApi/code/registration"; //external dev
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/?emailaddress="+username+"&clientkey="+ClientKey);
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		JsonPath jp = new JsonPath(responseBody);
		String RegCode = jp.getString("Code");
		return RegCode;
	}
	

}
