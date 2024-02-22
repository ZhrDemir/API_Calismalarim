package testDataKlasoru;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DummyTestData {

    public static int basariliStatusCode = 200;
    public static String contentType = "application/json";

    public static JSONObject getResponseDummyOlustur() {

/*
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
        JSONObject innerRecJO = new JSONObject();
        innerRecJO.put("id", 3);
        innerRecJO.put("employee_name", "Ashton Cox");
        innerRecJO.put("employee_salary", 86000);
        innerRecJO.put("employee_age", 66);
        innerRecJO.put("profile_image", "");

        JSONObject reqJO = new JSONObject();
        reqJO.put("status", "success");
        reqJO.put("data", innerRecJO);
        reqJO.put("message", "Successfully! Record has been fetched.");

        return reqJO;
    }

    public static Map<String, Object> dataDummyOlusturMap() {

        Map<String,Object> innerRecMap=new HashMap<>();
        innerRecMap.put("id", 3.0);
        innerRecMap.put("employee_name", "Ashton Cox");
        innerRecMap.put("employee_salary", 86000.0);
        innerRecMap.put("employee_age", 66.0);
        innerRecMap.put("profile_image", "");
      return innerRecMap;
    }
    public static Map<String, Object> expDummyOlusturMap() {

        Map<String, Object> recMap = new HashMap<>();
        recMap.put("status", "success");
        recMap.put("data", dataDummyOlusturMap());
        recMap.put("message", "Successfully! Record has been fetched.");
    return recMap;
    }
}