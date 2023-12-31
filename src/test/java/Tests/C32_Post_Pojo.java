package Tests;

import baseUrl.BaseUrlHerokuapp;
import org.junit.Test;
import pojos.PojoHerokuappBookingdates;
import pojos.PojuHerokuappReuestBody;

public class C32_Post_Pojo extends BaseUrlHerokuapp {

    /*
            https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST request
        gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.
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
        "bookingid": 24,
        "booking": {
        "firstname": "Ahmet",
        "lastname": "Bulut",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
        "checkin": "2021-06-01",
        "checkout": "2021-06-10"
        },
        "additionalneeds": "wi-fi"
        }
        }
     */

    @Test
    public void test(){
        specHerokuapp.pathParam("pp1","booking");

        PojoHerokuappBookingdates bokingdatePojo = new PojoHerokuappBookingdates("2021-06-01","2021-06-10");

        //PojuHerokuappReuestBody requestbodyPojo= new PojuHerokuappReuestBody("Ahmet","Bulut",500,false,bokingdatePojo,"wifi");
    }
}
