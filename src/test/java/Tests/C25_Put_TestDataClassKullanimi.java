package Tests;

import TestDatalari.TestDataPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C25_Put_TestDataClassKullanimi extends BaseUrlJsonPlaceholder {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT request
yolladigimizda donen response’in
status kodunun 200, content type’inin “application/json; charset=utf-8”, Connection header
degerinin “keep-alive”
ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
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

        specJsonPlaceholder.pathParams("pp1","posts","pp2",70);

        JSONObject requestBody = TestDataPlaceholder.reponseJsonBodyOlustur(10,70,"Ahmet","Merhaba");
        System.out.println(requestBody);

        JSONObject expectedData = TestDataPlaceholder.reponseJsonBodyOlustur(10,70,"Ahmet","Merhaba");

        Response response = given().spec(specJsonPlaceholder)
                                    .when().body(requestBody.toString()).contentType(ContentType.JSON)
                                    .put("{pp1}/{pp2}");

        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
/*
status kodunun 200, content type’inin “application/json; charset=utf-8”, Connection header
degerinin “keep-alive”
 */
        Assert.assertEquals(TestDataPlaceholder.basariliSorguStatusCode,response.statusCode());

        Assert.assertEquals(TestDataPlaceholder.contenType,response.contentType());
        Assert.assertEquals(TestDataPlaceholder.headerConnettion,response.header("Connection"));

        Assert.assertEquals(expectedData.getInt("id"),jsonPath.getInt("id"));
        Assert.assertEquals(expectedData.getInt("userId"),jsonPath.getInt("userId"));
        Assert.assertEquals(expectedData.getString("title"),jsonPath.getString("title"));
        Assert.assertEquals(expectedData.getString("body"),jsonPath.getString("body"));

    }
}
