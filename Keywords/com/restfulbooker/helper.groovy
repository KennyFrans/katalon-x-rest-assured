package com.restfulbooker

import org.json.JSONObject

import com.kms.katalon.core.annotation.Keyword

import io.restassured.RestAssured
import io.restassured.http.ContentType
import io.restassured.response.Response

class helper {
	
	@Keyword
	public static Response createBooking(String firstName, String lastName, int totalPrice, boolean depositPaid, String checkIn, String checkOut, String additionalNeeds) {
		
		//Declare JSON
		JSONObject body = new JSONObject()
		JSONObject bookingdates = new JSONObject()
		
		//Put data into body
		body.put("firstname", firstName)
		body.put("lastname", lastName)
		body.put("totalprice", totalPrice)
		body.put("depositpaid", depositPaid)
		bookingdates.put("checkin", checkIn)
		bookingdates.put("checkout", checkOut)
		body.put("bookingdates", bookingdates)
		body.put("additionalneeds", additionalNeeds)
		
		//Response from API
		Response response = RestAssured.given().
				contentType(ContentType.JSON).
				body(body.toString()).
				post("https://restful-booker.herokuapp.com/booking")
				
		return response
	}

}