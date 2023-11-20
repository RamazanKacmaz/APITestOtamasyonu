package Tests;

import TestDatalari.TestDataPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.PojoJsonPlaceholder;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C31_Put_PojoClass extends BaseUrlJsonPlaceholder {

    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT
request yolladigimizda donen response’in response body’sinin asagida verilen ile ayni
oldugunu test ediniz
Request Body
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}

Expected Data :
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}
     */

    @Test
    public void test(){
        specJsonPlaceholder.pathParams("pp1","posts","pp2","70");

        PojoJsonPlaceholder requestBodyPojo = new PojoJsonPlaceholder("Ahmet","Merhaba",10,70);

        PojoJsonPlaceholder expectedData = new PojoJsonPlaceholder("Ahmet","Merhaba",10,70);

        Response response = given().spec(specJsonPlaceholder).contentType(ContentType.JSON)
                                    .when().body(requestBodyPojo)
                                        .put("{pp1}/{pp2}");

        PojoJsonPlaceholder resposePojo = response.as(PojoJsonPlaceholder.class);

        //status kodunun 200,
        assertEquals(TestDataPlaceholder.basariliSorguStatusCode,response.statusCode());
        //content type’inin “application/json; charset=utf-8”,

        assertEquals(TestDataPlaceholder.contenType,response.contentType());

        //Connection header degerinin “keep-alive”


        // response body’sinin asagida verilen ile ayni oldugunu test ediniz

        assertEquals(expectedData.getTitle(),resposePojo.getTitle());
        assertEquals(expectedData.getBody(),resposePojo.getBody());
        assertEquals(expectedData.getUserId(),resposePojo.getUserId());
        assertEquals(expectedData.getId(),requestBodyPojo.getId());


    }
}
