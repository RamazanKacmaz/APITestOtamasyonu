package Tests;

import TestDatalari.TestDataPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C24_Get_TestDataClassKullanimi extends BaseUrlJsonPlaceholder {

    @Test
    public void test(){

        specJsonPlaceholder.pathParams("pp1","posts","pp2","40");

        JSONObject expectedData = TestDataPlaceholder.reponseJsonBodyOlustur(4,40,"enim quo cumque","ut voluptatum aliquid illo tenetur nemo sequi quo facilis\\nipsum rem optio mollitia\n" +
                "quas\\nvoluptatem eum voluptas qui\\nunde omnis voluptatem iure quasi maxime voluptas nam");

        Response response = given()
                .when().spec(specJsonPlaceholder)
                .get("/{pp1}/{pp2}");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(TestDataPlaceholder.basariliSorguStatusCode,response.statusCode());
        Assert.assertEquals(expectedData.getInt("userId"),jsonPath.getInt("userId"));
        Assert.assertEquals(expectedData.getInt("id"),jsonPath.getInt("id"));
        Assert.assertEquals(expectedData.getString("title"),jsonPath.getString("title"));
        //Assert.assertEquals(expectedData.getString("body"),jsonPath.getString("body"));
    }
}
