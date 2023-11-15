import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C1_GetRequest_ResponseBodyYazdirma {
    @Test
    public void get01(){

        //1- Request body ve end-point hazirlama
        String url = "https://restful-booker.herokuapp.com/booking/10";

        //2- Expected data hazirlama

        //3- Request gonderip, donen response kaydetme
        Response response = given().when().get(url);
        response.prettyPrint();

        //4- Assertion

    }
}
