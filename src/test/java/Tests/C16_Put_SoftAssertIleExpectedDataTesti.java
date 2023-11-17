package Tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C16_Put_SoftAssertIleExpectedDataTesti {
    @Test
    public void test(){
        /*
                    http://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki body’ye sahip bir PUT
            request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
            Request Body
            {
            "status": "success",
            "data": {
            "name": “Ahmet",
            "salary": "1230",
            "age": "44",
            "id": 40
            }
            }
            Response Body
            { "status": "success",
            "data": {
            "status": "success",
            "data": {
            "name": “Ahmet",
            "salary": "1230",
            "age": "44",
            "id": 40 }
            },
            "message": "Successfully! Record has been updated."}
         */

        String url = "http://dummy.restapiexample.com/api/v1/update/21";

        JSONObject requestBody = new JSONObject();
        JSONObject data = new JSONObject();

        data.put("name","Ahmet");
        data.put("salary","1230");
        data.put("age","44");
        data.put("id",40);

        requestBody.put("status","success");
        requestBody.put("data",data);


        JSONObject expectedData = new JSONObject();
        expectedData.put("status","success");
        expectedData.put("data",requestBody);
        expectedData.put("message","Successfully! Record has been updated.");


        Response response = given().contentType(ContentType.JSON)
                .when().body(requestBody.toString())
                .post(url);
        response.prettyPrint();


        SoftAssert softAssert = new SoftAssert();
        JsonPath actualJspath = response.jsonPath();

        softAssert.assertEquals(actualJspath.get("status"),expectedData.get("status"));


        softAssert.assertAll();


    }
}
