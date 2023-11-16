import org.json.JSONObject;
import org.testng.annotations.Test;

public class C04_JsonObjesiOlusturma {


   @Test
    public void test03(){

       /*{
    "title": "Ahmet",
    "body": "Merhaba",
    "userId": 10,
    "id": 70
    }*/
       JSONObject obj1 = new JSONObject();
       obj1.put("title", "Ahmet");
       obj1.put("body", "Merhaba");
       obj1.put("userId", 1);

       System.out.println(obj1);
   }




}
