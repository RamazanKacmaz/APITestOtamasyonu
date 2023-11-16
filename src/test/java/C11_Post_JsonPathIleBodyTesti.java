import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C11_Post_JsonPathIleBodyTesti {
                    /*C11_Post_JsonPathIleBodyTesti
                https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST request
                gonderdigimizde
                {
                "firstname" : "Ahmet",
                "lastname" : “Bulut",
                "totalprice" : 500,
                "depositpaid" : false,
                "bookingdates" : {
                "checkin" : "2023-01-10",
                "checkout" : "2023-01-20"
                },
                "additionalneeds" : "wi-fi"
                }
                POST REQUEST, RESPONSE BODY BILGILERINI
                ASSERT YAPARKEN JSONPATH KULLANMA
                donen Response’un,
                status code’unun 200,
                ve content type’inin application-json,
                ve response body’sindeki
                "firstname“in,"Ahmet",
                ve "lastname“in, "Bulut",
                ve "totalprice“in,500,
                ve "depositpaid“in,false,
                ve "checkin" tarihinin 2023-01-10
                ve "checkout" tarihinin 2023-01-20
                ve "additionalneeds“in,"wi-fi"
                oldugunu test edin*/

    @Test
    public void test01(){

        String url = "https://restful-booker.herokuapp.com/booking";
        JSONObject requstBody = new JSONObject();
        JSONObject rezervasyonDate = new JSONObject();


        rezervasyonDate.put("checkin","2023-01-10");
        rezervasyonDate.put("checkout","2023-01-20");

        requstBody.put("firstname","Ahmet");
        requstBody.put("lastname","Bulut");
        requstBody.put("totalprice",500);
        requstBody.put("depositpaid",false);
        requstBody.put("bookingdates",rezervasyonDate);
        requstBody.put("additionalneeds","wi-fi");


        Response response = given().contentType(ContentType.JSON)
                .when().body(requstBody.toString())
                .post(url);


        response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("booking.firstname",equalTo("Ahmet"),
                        "booking.lastname",equalTo("Bulut"),
                        "booking.totalprice",equalTo(500),
                        "booking.depositpaid",equalTo(false),
                        "booking.bookingdates.checkin",equalTo("2023-01-10"),
                        "booking.bookingdates.checkout",equalTo("2023-01-20"));

    }


}
