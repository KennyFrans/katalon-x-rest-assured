import org.testng.Assert
import org.testng.asserts.SoftAssert

import io.restassured.RestAssured
import io.restassured.response.Response

SoftAssert softAssert = new SoftAssert()

Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking/1")
response.prettyPrint()

actualFirstName = response.jsonPath().getString("firstname")
actualLastName = response.jsonPath().getString("lastname")
actualTotalPrice = response.jsonPath().getInt("totalprice")
actualDepositPaid = response.jsonPath().getBoolean("depositpaid")
actualCheckIn = response.jsonPath().getString("bookingdates.checkin")
actualCheckOut = response.jsonPath().getString("bookingdates.checkout")

Assert.assertEquals(response.getStatusCode(), 200, "Not same!")

softAssert.assertEquals(actualFirstName, "Susan", "Not Same!")

softAssert.assertEquals(actualLastName, "Wilson", "Not Same!")

softAssert.assertEquals(actualTotalPrice, 360, "Not Same!")

softAssert.assertTrue(actualDepositPaid, "Not Same!")

softAssert.assertEquals(actualCheckIn, "2018-09-17", "Not Same!")

softAssert.assertEquals(actualCheckOut, "2019-04-21", "Not Same!")

softAssert.assertAll()

