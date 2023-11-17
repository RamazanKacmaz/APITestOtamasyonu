package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C09_Get_BodyTekrarlardanKurtulma {
    @Test
    public void test(){
        /*https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde
donen Response’un,
status code’unun 200,
ve content type’inin application-json,
ve response body’sindeki
"firstname“in, "Susan",
ve "lastname“in, "Jackson",
ve "Jackson“in, 612,
ve "depositpaid“in, false,
ve "additionalneeds“in, "Breakfast"
oldugunu test edin*/

        String url = "https://restful-booker.herokuapp.com/booking/10";

        Response response = given().when().get(url);
        response.prettyPrint();
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON)
                .body("firstname", equalTo("Susan"),
                        "lastname", equalTo("Brown"),
                        "totalprice", lessThan(1000),
                        "depositpaid", equalTo(false),
                        "additionalneeds", notNullValue());




    }
}
