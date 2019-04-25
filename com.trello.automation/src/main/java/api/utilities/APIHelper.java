package api.utilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIHelper
{
	private static String key;
	private static String token;
	private static String uri;
	
	static
	{
		key = "4776cd9299a2707391fc8cf21f4c5031";
		token = "aacbbf88514cb5dcc68ff127ef9797ebff78d8afdeda72d391db4618ed569b8e";
		uri = "https://api.trello.com/";
		
		RestAssured.baseURI = uri;
	}

	public static String getAuthentication()
	{
		String oAuth = "key=%1s&token=%2s";
		oAuth = String.format(oAuth, key, token);
		
		return oAuth;
	}
	
	public static void sendDeleteRequest(String request)
	{
		getRequestSpecification().delete(request);
	}
	
	public static JSONArray sendGetRequest(String request)
	{
		Response response = getRequestSpecification().get(request);
		return parseResponseBody(response);
	}
	
	public static void sendPostRequest(String request)
	{
		getRequestSpecification().post(request);
	}
	
	public static void sendPutRequest(String request)
	{
		getRequestSpecification().put(request);
	}

	private static RequestSpecification getRequestSpecification()
	{
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.contentType("application/json\r\n");
		
		return requestSpec;
	}

	private static JSONArray parseResponseBody(Response response)
	{
		String responseString = "{\"array\":%s}";
		responseString = String.format(responseString, response.body().asString());

		JSONArray jsonArray = null;
		
		try
		{
			Object _jsonObject = new JSONParser().parse(responseString);
			JSONObject jsonObject = (JSONObject)_jsonObject;
			
			jsonArray = (JSONArray)jsonObject.get("array");
		}
		catch (ParseException e)
		{
			// Do nothing...
		}
		
		return jsonArray;
	}
}