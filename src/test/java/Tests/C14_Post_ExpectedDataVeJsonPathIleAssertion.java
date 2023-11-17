package Tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C14_Post_ExpectedDataVeJsonPathIleAssertion {
    @Test
    public void test(){
                    /*
                    https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST request
            gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.
            POST REQUEST, RESPONSE BODY BILGILERINI
            ASSERT YAPARKEN JSONPATH KULLANMA
            Response Body
            {
            "bookingid": 24,
            "booking": {
            "firstname": "Ahmet",
            "lastname": "Bulut",
            "totalprice": 500,
            "depositpaid": false,
            "bookingdates": {
            "checkin": "2021-06-01",
            "checkout": "2021-06-10"
            },
            "additionalneeds": "wi-fi"
            }
            }
            Request body
            {
            "firstname" : "Ahmet",
            "lastname" : “Bulut",
            "totalprice" : 500,
            "depositpaid" : false,
            "bookingdates" : {
            "checkin" : "2021-06-01",
            "checkout" : "2021-06-10"
            },
            "additionalneeds" : "wi-fi"
            }
                     */
        // 1- Endpoint ve request body olustur

        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject requestBody = new JSONObject();

        JSONObject rezervasyondate = new JSONObject();

        rezervasyondate.put("checkin","2021-06-01");
        rezervasyondate.put("checkout","2021-06-10");

        requestBody.put("firstname","Ahmet");
        requestBody.put("lastname","Bulut");
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates",rezervasyondate);
        requestBody.put("additionalneeds","wi-fi");


        // 2- Expected data olustur

        JSONObject expectedDate = new JSONObject();
        expectedDate.put("bookingid",24);
        expectedDate.put("booking",requestBody);

        // 3- Reuest gonderip donen response kaydet

        Response response = given().contentType(ContentType.JSON)
                .when().body(requestBody.toString())
                .post(url);
        response.prettyPrint();


        JsonPath responJsonpath = response.jsonPath();

        Assert.assertEquals(expectedDate.getJSONObject("booking").get("firstname"),responJsonpath.get("booking.firstname"));
        Assert.assertEquals(expectedDate.getJSONObject("booking").get("lastname"),responJsonpath.get("booking.lastname"));
        Assert.assertEquals(expectedDate.getJSONObject("booking").get("totalprice"),responJsonpath.get("booking.totalprice"));
        Assert.assertEquals(expectedDate.getJSONObject("booking").get("depositpaid"),responJsonpath.get("booking.depositpaid"));
        Assert.assertEquals(expectedDate.getJSONObject("booking").get("additionalneeds"),responJsonpath.get("booking.additionalneeds"));
        Assert.assertEquals(expectedDate.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),responJsonpath.get("booking.bookingdates.checkin"));


        Assert.assertEquals(expectedDate.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),responJsonpath.get("booking.bookingdates.checkout"));





















































    }
}
