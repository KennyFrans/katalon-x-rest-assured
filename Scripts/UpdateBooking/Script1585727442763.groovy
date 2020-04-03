import org.testng.Assert
import org.testng.asserts.SoftAssert

import com.restfulbooker.Helper

import io.restassured.response.Response

Response responseCreate = Helper.createBooking("Azzam", "Nizar", 15000, false, "2020-04-01", "2020-05-01", "Extra bed")

responseCreate.prettyPrint()

bookingID = responseCreate.jsonPath().getInt("bookingid")

Response responseUpdate = Helper.updateBooking(bookingID, "Nizar", "Azzam", 15000, false, "2020-04-01", "2020-05-01", "Extra bed")

responseUpdate.prettyPrint()

SoftAssert softAssert = new SoftAssert()

actualFirstName = responseUpdate.jsonPath().getString("firstname")
actualLastName = responseUpdate.jsonPath().getString("lastname")
actualTotalPrice = responseUpdate.jsonPath().getInt("totalprice")
actualDepositPaid = responseUpdate.jsonPath().getBoolean("depositpaid")
actualCheckIn = responseUpdate.jsonPath().getString("bookingdates.checkin")
actualCheckOut = responseUpdate.jsonPath().getString("bookingdates.checkout")
actualAdditionalNeeds = responseUpdate.jsonPath().getString("additionalneeds")

Assert.assertEquals(responseUpdate.getStatusCode(), 200, "Not same!")

softAssert.assertEquals(actualFirstName, "Nizar", "Not Same!")

softAssert.assertEquals(actualLastName, "Azzam", "Not Same!")

softAssert.assertEquals(actualTotalPrice, 15000, "Not Same!")

softAssert.assertFalse(actualDepositPaid, "Not Same!")

softAssert.assertEquals(actualCheckIn, "2020-04-01", "Not Same!")

softAssert.assertEquals(actualCheckOut, "2020-05-01", "Not Same!")

softAssert.assertEquals(actualAdditionalNeeds, "Extra bed", "Not Same!")

softAssert.assertAll()