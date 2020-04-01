import com.restfulbooker.helper

import io.restassured.response.Response

Response response = helper.createBooking("Azzam", "Nizar", 15000, false, "2020-04-01", "2020-05-01", "Extra bed")
response.prettyPrint()