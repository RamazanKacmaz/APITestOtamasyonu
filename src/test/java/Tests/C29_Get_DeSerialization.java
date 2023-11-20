package Tests;

import TestDatalari.TestDataDummyExampel;
import baseUrl.BaseUrldummyexampel;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C29_Get_DeSerialization extends BaseUrldummyexampel {
    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine
    bir GET request gonderdigimizde
    donen response’un status code’unun 200,
    content Type’inin application/json
    ve body’sinin asagidaki gibi oldugunu test edin.
        Expected Response Body
        {
            "status":"success",
            "data":{
                    "id":3,
                    "employee_name":"Ashton Cox",
                    "employee_salary":86000,
                    "employee_age":66,
                    "profile_image":""
                    },
            "message":"Successfully! Record has been fetched."
        }
     */

    @Test
    public void test(){
        specDummyExampel.pathParams("pp1","employee","pp2","3");

        Map<String,Object> expecteddata = TestDataDummyExampel.mapBodyolustur();

        Response response = given().spec(specDummyExampel)
                                    .when()
                                        .get("{pp1}/{pp2}");


        Map<String,Object> reponseMap = response.as(HashMap.class);

        Assert.assertEquals(TestDataDummyExampel.statusCode,response.statusCode());
        Assert.assertEquals(TestDataDummyExampel.contenteyp,response.contentType());

        Assert.assertEquals(expecteddata.get("message"),reponseMap.get("message"));
        Assert.assertEquals(expecteddata.get("status"),reponseMap.get("status"));

        Assert.assertEquals(((Map)expecteddata.get("data")).get("profile_image"),((Map)reponseMap.get("data")).get("profile_image"));
        Assert.assertEquals(((Map)expecteddata.get("data")).get("employee_name"),((Map)reponseMap.get("data")).get("employee_name"));
        Assert.assertEquals(((Map)expecteddata.get("data")).get("employee_salary"),((Map)reponseMap.get("data")).get("employee_salary"));
        Assert.assertEquals(((Map)expecteddata.get("data")).get("id"),((Map)reponseMap.get("data")).get("id"));
        Assert.assertEquals(((Map)expecteddata.get("data")).get("employee_age"),((Map)reponseMap.get("data")).get("employee_age"));

    }

}
