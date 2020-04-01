import org.testng.Assert
import org.testng.asserts.SoftAssert

import com.restfulbooker.helper

import io.restassured.response.Response

Response response = helper.createBooking("Azzam", "Nizar", 15000, false, "2020-04-01", "2020-05-01", "Extra bed")

response.prettyPrint()

SoftAssert softAssert = new SoftAssert()

actualFirstName = response.jsonPath().getString("booking.firstname")
actualLastName = response.jsonPath().getString("booking.lastname")
actualTotalPrice = response.jsonPath().getInt("booking.totalprice")
actualDepositPaid = response.jsonPath().getBoolean("booking.depositpaid")
actualCheckIn = response.jsonPath().getString("booking.bookingdates.checkin")
actualCheckOut = response.jsonPath().getString("booking.bookingdates.checkout")
actualAdditionalNeeds = response.jsonPath().getString("booking.additionalneeds")

Assert.assertEquals(response.getStatusCode(), 200, "Not same!")

softAssert.assertEquals(actualFirstName, "Azzam", "Not Same!")

softAssert.assertEquals(actualLastName, "Nizar", "Not Same!")

softAssert.assertEquals(actualTotalPrice, 15000, "Not Same!")

softAssert.assertTrue(!actualDepositPaid, "Not Same!")

softAssert.assertEquals(actualCheckIn, "2020-04-01", "Not Same!")

softAssert.assertEquals(actualCheckOut, "2020-05-01", "Not Same!")

softAssert.assertEquals(actualAdditionalNeeds, "Extra bed", "Not Same!")

softAssert.assertAll()