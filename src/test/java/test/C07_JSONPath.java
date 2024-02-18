package test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class C07_JSONPath {

    @Test
    public void jsonPath() {

        JSONObject iphone= new JSONObject();
        iphone.put("type","iphone");
        iphone.put("number","0123-4567-8888");

        JSONObject home= new JSONObject();
        home.put("type","home");
        home.put("number","0123-4567-8910");

        JSONArray phoneArr = new JSONArray();
        phoneArr.put(0,iphone);
        phoneArr.put(1,home);

        JSONObject address= new JSONObject();
        address.put("streetAddress","naist street");
        address.put("city","Nara");
        address.put("postalCode","630-0192");

        JSONObject personel= new JSONObject();
        personel.put("firstName","John");
        personel.put("lastName","doe");
        personel.put("age",26);
        personel.put("address",address);
        personel.put("phoneNumbers",phoneArr);

        System.out.println(personel);
        System.out.println(personel.getJSONObject("address").get("streetAddress"));

    }
}