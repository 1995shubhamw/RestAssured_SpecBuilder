package SpecBuilder;

import io.restassured.RestAssured;
import pojo.AddPlace;
import pojo.Location;

import static io.restassured.RestAssured.*;
import java.util.ArrayList;
import java.util.List;

public class ResponseGenerate 
{

	public static void main(String[] args) 
	
	{   
		
		
		AddPlace ap=new AddPlace();
		ap.setAccuracy(50);
		ap.setName("Frontline house");
		ap.setPhone_number("(+91) 983 893 3937");
		ap.setAddress("29, side layout, cohen 09");
		
		//For Types accept List of string so for that we have to use like 
		
		List<String> ls=new ArrayList <String>() ;
		ls.add("shoe park");
		ls.add("Shop");
		ap.setTypes(ls);
		
		ap.setWebsite("http://google.com");
		ap.setLanguage("French-IN");
		
		
		Location lo=new Location();
		lo.setLat(-38.383494);
		lo.setLng(33.427362);
		
		ap.setLocation(lo);
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		String response=given().queryParam("key ", "qaclick123")
				.header("Content-Type","application/json").body(ap) 
				// instead of passing whole body into the 
			    // body argument we will create object and pass object 
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().asString();
		
		System.out.println(response);
		
		
		
		
		
		
		
		

	}

}
