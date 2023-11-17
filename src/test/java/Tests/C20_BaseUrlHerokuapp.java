package Tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C20_BaseUrlHerokuapp extends BaseUrlHerokuapp {

    @Test
    public void test(){
        /*
        https://restful-booker.herokuapp.com/booking
        endpointine yandaki body’ye sahip bir POST request
        gonderdigimizde donen response’un status code’unun
        200 oldugunu ve “firstname” degerinin “Ahmet”
        oldugunu test edin
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

        specHerokuapp.pathParam("pp1","booking");

        JSONObject bookingdates = new JSONObject();
        JSONObject requestBody = new JSONObject();
        bookingdates.put("checkin","2021-06-01");
        bookingdates.put("checkout","2021-06-10");

        requestBody.put("firstname","Ahmet");
        requestBody.put("lastname","Bulut");
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates",bookingdates);
        requestBody.put("additionalneeds","wi-fi");

        Response response = given().contentType(ContentType.JSON)
                                    .when().spec(specHerokuapp).body(requestBody.toString())
                                    .post("/{pp1}");

        response.then().assertThat().statusCode(200).body("booking.firstname", Matchers.equalTo("Ahmet"));

    }
}
