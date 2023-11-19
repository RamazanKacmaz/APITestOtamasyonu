package TestDatalari;

import org.json.JSONObject;

public class TestDataPlaceholder {

   public static int basariliSorguStatusCode = 200;
   public static String contenType = "application/json; charset=utf-8";
   public static String headerConnettion = "keep-alive";


    public static JSONObject responseBody22(){
        JSONObject expectedData = new JSONObject();

        expectedData.put("userId",3);
        expectedData.put("id",22);
        expectedData.put("title","dolor sint quo a velit explicabo quia nam");
        expectedData.put("body","eos qui et ipsum ipsam suscipit autnsed omnis non odionexpedita ear um mollitia molestiae aut atque rem suscipitnnam impedit esse");

        return expectedData;
    }

    public static JSONObject reponseJsonBodyOlustur(int userId,int id , String title,String body){
        JSONObject expectedData = new JSONObject();

        expectedData.put("userId",userId);
        expectedData.put("id",id);
        expectedData.put("title",title);
        expectedData.put("body",body);

        return expectedData;
    }

}
