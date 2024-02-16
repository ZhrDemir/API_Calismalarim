package test;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class C03_JsonObjesi {
  /*  Asagidaki JSON Objesini olusturup
    konsolda yazdirin.
    {
        "title":"Ahmet",
            "body":"Merhaba",
            "userId":1

   */


    public void jsonObjesi(){

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("title","Ahmet");
        jsonObject.put("body","Merhaba");
        jsonObject.put("userId",1);

        System.out.println(jsonObject);

    }

    /*Asagidaki JSON Objesini olusturup konsolda yazdirin.
    {
        "firstname":"Jim",
            "additionalneeds":"Breakfast",
            "bookingdates": {
                            "checkin":"2018-01-01",
                            "checkout":"2019-01-01"
    },
            "totalprice":111,
            "depositpaid":true,
            "lastname":"Brown"
    }

     */
    @Test
    public void innerJsonObje(){
        JSONObject innerJson = new JSONObject();
        innerJson.put("checkin","2018-01-01");
        innerJson.put("checkout","2019-01-01");

        JSONObject outerJson=new JSONObject();
        outerJson.put("firstname","Jim");
        outerJson.put( "lastname","Brown");
        outerJson.put( "additionalneeds","Breakfast");
        outerJson.put("bookingdates",innerJson);
        outerJson.put("totalprice",111);
        outerJson.put("depositpaid",true);

        System.out.println(innerJson);
        System.out.println(outerJson);

    }

}
