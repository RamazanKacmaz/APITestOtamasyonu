package Tests;

import TestDatalari.TestDataPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C23_Get_TestDataClassKullanimi extends BaseUrlJsonPlaceholder {

    @Test
    public void test(){

        /*
                    https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request yolladigimizda donen
            response’in status kodunun 200 ve response body’sinin asagida verilen ile ayni oldugunutest
            ediniz
            Response body :
            {
            "userId": 3,
            "id": 22,
            "title": "dolor sint quo a velit explicabo quia nam",
            "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
            um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
            }

         */
        specJsonPlaceholder.pathParams("pp1","posts","pp2","22");

        JSONObject expectedData = TestDataPlaceholder.responseBody22();

        Response response = given()
                                        .when().spec(specJsonPlaceholder)
                                        .get("/{pp1}/{pp2}");

        JsonPath responseJsonPath = response.jsonPath();

        Assert.assertEquals(TestDataPlaceholder.basariliSorguStatusCode,response.statusCode());
        Assert.assertEquals(expectedData.getInt("userId"),responseJsonPath.getInt("userId"));
        Assert.assertEquals(expectedData.getInt("id"),responseJsonPath.getInt("id"));
        Assert.assertEquals(expectedData.get("title"),responseJsonPath.get("title"));
        //Assert.assertTrue(expectedData.getString("body").contains(responseJsonPath.getString("body")));
    }
}
