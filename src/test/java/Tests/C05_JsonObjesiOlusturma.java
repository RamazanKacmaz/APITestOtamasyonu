package Tests;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class C05_JsonObjesiOlusturma {

    @Test
    public void test04(){
        /*{
            "firstname":"Jim",
                "additionalneeds":"Breakfast",
                "bookingdates":{
            "checkin":"2018-01-01",
             "checkout":"2019-01-01"
        },
            "totalprice":111,
                "depositpaid":true,
                "lastname":"Brown"
        }*/

        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin","2018-01-01");
        bookingdates.put("checkout","2019-01-01");

        JSONObject reqbody = new JSONObject();
        reqbody.put("firstname","Jim");
        reqbody.put("additionalneeds","Breakfast");
        reqbody.put("bookingdates",bookingdates);
        reqbody.put("totalprice",111);
        reqbody.put("depositpaid",true);
        reqbody.put( "lastname","Brown");
        System.out.println(reqbody);
        System.out.println("_____________________");
        System.out.println(bookingdates);
    }
}
