package com.restfulbooker

import org.json.JSONObject
import org.testng.Assert

import com.kms.katalon.core.annotation.Keyword

import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.http.ContentType
import io.restassured.response.Response
import io.restassured.specification.RequestSpecification

class Helper {

	static RequestSpecification spec

	public static void setUp() {
		spec = new RequestSpecBuilder().
				setBaseUri("https://restful-booker.herokuapp.com").
				build()
	}

	@Keyword
	public static Response createBooking(String firstName, String lastName, int totalPrice, boolean depositPaid, String checkIn, String checkOut, String additionalNeeds) {

		BookingDates bookingDates = new BookingDates(checkIn, checkOut)
		Booking booking = new Booking(firstName, lastName, totalPrice, bookingDates, depositPaid, additionalNeeds)


		//Response from API
		Response response = RestAssured.given(spec).
				contentType(ContentType.JSON).
				body(booking).
				post("/booking")
		
		response.prettyPrint()
				
		BookingResponse bookingResponse = response.as(BookingResponse.class)
		
		Assert.assertEquals(bookingResponse.getBooking().toString(), booking.toString(), "It's different data!")
				
		return response
	}

	@Keyword
	public static Response updateBooking(int bookingID, String firstName, String lastName, int totalPrice, boolean depositPaid, String checkIn, String checkOut, String additionalNeeds) {

		BookingDates bookingDates = new BookingDates(checkIn, checkOut)
		Booking booking = new Booking(firstName, lastName, totalPrice, bookingDates, depositPaid, additionalNeeds)

		//Response from API
		Response response = RestAssured.given(spec).
				auth().preemptive().basic("admin", "password123").
				contentType(ContentType.JSON).
				body().
				pathParam("bookingid", bookingID).
				put("/booking/{bookingid}")

		response.prettyPrint()
		
		BookingResponse bookingResponse = response.as(BookingResponse.class)
		
		Assert.assertEquals(bookingResponse.getBooking().toString(), booking.toString(), "It's different data!")
				
		return response
	}

	@Keyword
	public static Response partialUpdateBooking(int bookingID, String jsonBody) {
		JSONObject bodyRequest = new JSONObject(jsonBody)

		//Response from API
		Response response = RestAssured.given(spec).
				auth().preemptive().basic("admin", "password123").
				contentType(ContentType.JSON).
				body(bodyRequest.toString()).
				pathParam("bookingid", bookingID).
				patch("/booking/{bookingid}")

		return response
	}

	public static Response DeleteBooking(int bookingID) {
		//Response from API
		Response response = RestAssured.given(spec).
				auth().preemptive().basic("admin", "password123").
				contentType(ContentType.JSON).
				pathParam("bookingid", bookingID).
				delete("/booking/{bookingid}")

		return response
	}
}