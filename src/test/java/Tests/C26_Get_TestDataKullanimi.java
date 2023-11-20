package Tests;

import TestDatalari.TestDataDummyExampel;
import baseUrl.BaseUrldummyexampel;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class C26_Get_TestDataKullanimi extends BaseUrldummyexampel {
    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request gonderdigimizde
donen response’un status code’unun 200, content Type’inin application/json ve body’sinin
asagidaki gibi oldugunu test edin.
Response Body
{
"status": "success",
"data": {
"id": 3,
"employee_name": "Ashton Cox",
"employee_salary": 86000,
"employee_age": 66,
"profile_image": ""
},
"message": "Successfully! Record has been fetched."
}
     */


    @Test
    public void test() {
        specDummyExampel.pathParams("pp1","employee","pp2","3");

        JSONObject expectedData = TestDataDummyExampel.reponseJsonBodyOlustur(3,"Ashton Cox",86000,66,"");


        Response response = given().spec(specDummyExampel)
                                    .when()
                                    .get("{pp1}/{pp2}");

        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(TestDataDummyExampel.statusCode,response.statusCode());
        Assert.assertEquals(TestDataDummyExampel.contenteyp,response.contentType());

        Assert.assertEquals(expectedData.getJSONObject("data").getString("profile_image"),jsonPath.getString("data.profile_image"));
        Assert.assertEquals(expectedData.getJSONObject("data").getString("employee_name"),jsonPath.getString("data.employee_name"));
        Assert.assertEquals(expectedData.getJSONObject("data").getInt("id"),jsonPath.getInt("data.id"));
        Assert.assertEquals(expectedData.getJSONObject("data").getInt("employee_salary"),jsonPath.getInt("data.employee_salary"));
        Assert.assertEquals(expectedData.getJSONObject("data").getInt("employee_age"),jsonPath.getInt("data.employee_age"));

        Assert.assertEquals(expectedData.getString("message"),jsonPath.getString("message"));
        Assert.assertEquals(expectedData.getString("status"),jsonPath.getString("status"));


    }
}
