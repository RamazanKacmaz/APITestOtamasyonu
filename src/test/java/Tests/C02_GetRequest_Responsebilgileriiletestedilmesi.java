package Tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C02_GetRequest_Responsebilgileriiletestedilmesi {

    @Test
    public void test01(){

        String url = "https://restful-booker.herokuapp.com/booking/10";

        Response response = given().when().get(url);
        System.out.println("_________________________");
        System.out.println(response.getStatusCode());
        System.out.println("_________________________");
        System.out.println(response.getContentType());
        System.out.println("_________________________");
        System.out.println(response.getHeader("Server"));
        System.out.println("_________________________");
        System.out.println(response.getStatusLine());
        System.out.println("_________________________");
        System.out.println(response.getTime());
        System.out.println("_________________________");
        response.prettyPrint();
        System.out.println("_________________________");

    }
}
