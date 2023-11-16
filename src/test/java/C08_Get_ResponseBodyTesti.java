import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C08_Get_ResponseBodyTesti {
    @Test
    public void test01(){
       /* https://jsonplaceholder.typicode.com/posts url’ine asagidaki body ile bir POST request
        gonderdigimizde
        {
            "title":"API",
                "body":"API ogrenmek ne guzel",
                "userId":10,
        }
        donen Response’un,
                status code’unun 201,
                ve content type’inin application/json
        ve Response Body'sindeki,
        "title"'in "API" oldugunu
        "userId" degerinin 100'den kucuk oldugunu
        "body" nin "API" kelimesi icerdigini
        test edin.*/

        String url = "https://jsonplaceholder.typicode.com/posts ";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title","API");
        jsonObject.put("body","API ogrenmek ne guzel");
        jsonObject.put("userId",10);

        Response response = given().contentType(ContentType.JSON)
                .when()
                .body(jsonObject.toString())
                .post(url);
        response
                .then()
                .assertThat()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("userId", Matchers.lessThan(100))
                .body("title",Matchers.equalTo("API"))
                .body("body",Matchers.containsString("API"));

    }
}
