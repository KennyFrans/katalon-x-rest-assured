import org.testng.Assert

import com.restfulbooker.helper

import io.restassured.response.Response

Response responseCreate = helper.createBooking("Azzam", "Nizar", 15000, false, "2020-04-01", "2020-05-01", "Extra bed")

responseCreate.prettyPrint()

bookingID = responseCreate.jsonPath().getInt("bookingid")

Response responseUpdate = helper.updateBooking(bookingID, "Nizar", "Azzam", 15000, false, "2020-04-01", "2020-05-01", "Extra bed")

responseUpdate.prettyPrint()