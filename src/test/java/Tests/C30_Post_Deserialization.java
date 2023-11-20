package Tests;

import TestDatalari.TestDataHerokuapp;
import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C30_Post_Deserialization extends BaseUrlHerokuapp {
    /*
        https://restful-booker.herokuapp.com/booking url’ine
        asagidaki body'ye sahip bir POST request gonderdigimizde
        donen response’un id haric asagidaki gibi oldugunu test edin.
                            Request body
                       {
                            "firstname" : "Ahmet",
                            "lastname" : “Bulut",
                            "totalprice" : 500,
                            "depositpaid" : false,
                            "bookingdates" : {
                                     "checkin" : "2021-06-01",
                                     "checkout" : "2021-06-10"
                                              },
                            "additionalneeds" : "wi-fi"
                        }
                            Response Body // expected data
                        {
                        "bookingid":24,
                        "booking":{
                            "firstname":"Ahmet",
                            "lastname":"Bulut",
                            "totalprice":500,
                            "depositpaid":false,
                            "bookingdates":{
                                "checkin":"2021-06-01",
                                "checkout":"2021-06-10"
                            ,
                            "additionalneeds":"wi-fi"
                        }
         */

    @Test
    public void test01(){
        specHerokuapp.pathParam("pp1","booking");

        Map<String,Object> requesMap = TestDataHerokuapp.requestBodyMapOlustur();

        Map<String ,Object> expectedData = TestDataHerokuapp.responseBodyMapOlustur();

        Response response = given().contentType(ContentType.JSON).spec(specHerokuapp)
                                    .when().body(requesMap)
                                    .post("{pp1}");
        Map<String,Object> reponseMap = response.as(HashMap.class);

        assertEquals(((Map)expectedData.get("booking")).get("firstname"),
                ((Map)reponseMap.get("booking")).get("firstname"));

        assertEquals(((Map) expectedData.get("booking")).get("lastname"),
                ((Map) reponseMap.get("booking")).get("lastname"));

        assertEquals(((Map) expectedData.get("booking")).get("additionalneeds"),
                ((Map) reponseMap.get("booking")).get("additionalneeds"));

        assertEquals(((Map) expectedData.get("booking")).get("totalprice"),
                ((Map) reponseMap.get("booking")).get("totalprice"));

        assertEquals(((Map) expectedData.get("booking")).get("depositpaid"),
                ((Map) reponseMap.get("booking")).get("depositpaid"));

        assertEquals(((Map)((Map) expectedData.get("booking")).get("bookingdates")).get("checkin"),
                ((Map)((Map) expectedData.get("booking")).get("bookingdates")).get("checkin"));

        assertEquals(((Map)((Map) expectedData.get("booking")).get("bookingdates")).get("checkout"),
                ((Map)((Map) expectedData.get("booking")).get("bookingdates")).get("checkout"));


    }
}
