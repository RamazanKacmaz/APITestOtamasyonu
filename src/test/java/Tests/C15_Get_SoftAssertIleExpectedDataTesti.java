package Tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C15_Get_SoftAssertIleExpectedDataTesti {
    @Test
    public void test(){
        /*
                http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
        gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
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

        String url = "http://dummy.restapiexample.com/api/v1/employee/3";

        JSONObject requestBody = new JSONObject();
        JSONObject data = new JSONObject();
        data.put("id",3);
        data.put("employee_name","Ashton Cox");
        data.put("employee_salary",86000);
        data.put("employee_age",66);
        data.put("rofile_image","");

        requestBody.put("status","success");
        requestBody.put("data",data);
        requestBody.put("message","Successfully! Record has been fetched");

        System.out.println(requestBody.toString());

        Response response = given().when().get(url);
        response.prettyPrint();

        JsonPath responseJsonPath = response.jsonPath();


        SoftAssert softAssert = new SoftAssert();

       /* softAssert.assertEquals(responseJsonPath.get("status"),requestBody.get("status"));
        softAssert.assertEquals(responseJsonPath.get("message"),requestBody.get("message"));

       softAssert.assertEquals(jsonPath.get("data.id"),requestBody.getJSONObject("data").get("id"));
       softAssert.assertEquals(jsonPath.get("data.employee_name"),requestBody.getJSONObject("data").get("employee_name"));
       softAssert.assertEquals(jsonPath.get("data.employee_salary"),requestBody.getJSONObject("data").get("employee_salary"));
       softAssert.assertEquals(jsonPath.get("data.employee_age"),requestBody.getJSONObject("data").get("employee_age"));
       softAssert.assertEquals(jsonPath.get("data.rofile_image"),requestBody.getJSONObject("data").get("rofile_image"));*/


        softAssert.assertAll();





    }
}
