package Tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C13_Get_ExpectedDataOlusturma {
    @Test
    public void test01(){

                    /*
                    https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
            yolladigimizda donen response body’sinin asagida verilen ile ayni oldugunutest ediniz
            Response body :
            {
            "userId": 3,
            "id": 22,
            "title": "dolor sint quo a velit explicabo quia nam",
            "body": "eos qui et ipsum ipsam suscipit autsed omnis non odioexpedita ear
            um mollitia molestiae aut atque rem suscipitnam impedit esse"
            }
                     */

        String url = "ttps://jsonplaceholder.typicode.com/posts/22";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId",3);
        jsonObject.put("id",22);
        jsonObject.put("title","dolor sint quo a velit explicabo quia nam");
        jsonObject.put("body","eos qui et ipsum ipsam suscipit autsed omnis non odioexpedita ear um mollitia molestiae aut atque rem suscipitnam impedit esse");

        Response response =given().when().get(url);
        /*
        response.then().assertThat()
                .body("userId", equalTo(3),"id",equalTo(22),"title",equalTo("dolor sint quo a velit explicabo quia nam"));
            */

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(jsonObject.get("id"),jsonPath.get("id"));























    }
}
