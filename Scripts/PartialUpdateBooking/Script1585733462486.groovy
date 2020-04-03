import com.restfulbooker.Helper

import io.restassured.response.Response

Response responseCreate = Helper.createBooking("Azzam", "Nizar", 15000, false, "2020-04-01", "2020-05-01", "Extra bed")

responseCreate.prettyPrint()

bookingID = responseCreate.jsonPath().getInt("bookingid")

Response responsePartialUpdate = Helper.partialUpdateBooking(bookingID, "{'firstname':'azzam','lastname':'rowo'}")

responsePartialUpdate.prettyPrint()