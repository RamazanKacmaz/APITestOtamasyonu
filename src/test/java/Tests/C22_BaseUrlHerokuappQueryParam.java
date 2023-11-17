package Tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C22_BaseUrlHerokuappQueryParam extends BaseUrlHerokuapp {


    @Test
    public void test01(){
        /*
                    2- https://restful-booker.herokuapp.com/booking endpointine gerekli Query parametrelerini
            yazarak “firstname” degeri “Jim” ve “lastname” degeri “Jackson” olan rezervasyon
            oldugunu test edecek bir GET request gonderdigimizde, donen response’un status
            code’unun 200 oldugunu ve “Jim Jackson” ismine sahip en az bir booking oldugunu test
            edin
         */

        specHerokuapp.pathParam("pp1","booking")
                .pathParams("firstname","John","lastname","Smith");

        Response response = given()
                                    .when().spec(specHerokuapp)
                                    .get("/{pp1}");


        response.prettyPrint();

    }
}
