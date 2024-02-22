package test;

import baseURLDeposu.DummyBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDataKlasoru.DummyTestData;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C013_Tekrar_Dummy extends DummyBaseURL {


    @Test
    public void test() {

    /*
    C20_Get_TestDataKullanimi
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
    gonderdigimizde donen response’un status code’unun 200, content Type’inin
    application/json ve body’sinin asagidaki gibi oldugunu test edin.
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
        specDummyURL.pathParams("pp1", "employee", "pp2", 3);

        JSONObject expData = DummyTestData.getResponseDummyOlustur();

        Response response = given().spec(specDummyURL).when().body(DummyTestData.getResponseDummyOlustur().toString()).get("{pp1}/{pp2}");

        JsonPath ResJP = response.jsonPath();

        assertEquals(DummyTestData.basariliStatusCode, response.getStatusCode());
        assertEquals(expData.get("status"), ResJP.get("status"));
        assertEquals(expData.getJSONObject("data").get("id"), ResJP.get("data.id"));
        assertEquals(expData.getJSONObject("data").get("employee_name"), ResJP.get("data.employee_name"));
        assertEquals(expData.getJSONObject("data").get("employee_salary"), ResJP.get("data.employee_salary"));
        assertEquals(expData.getJSONObject("data").get("employee_age"), ResJP.get("data.employee_age"));
        assertEquals(expData.getJSONObject("data").get("profile_image"), ResJP.get("data.profile_image"));
        assertEquals(expData.get("message"), ResJP.get("message"));

    }

    /*
      C23_Get_TestDataKullanimi
      http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
      gonderdigimizde donen response’un status code’unun 200, content Type’inin
      application/json ve body’sinin asagidaki gibi oldugunu test edin.
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
    @Test
    public void get() {
        specDummyURL.pathParams("pp1", "employee", "pp2", 3);

        Map<String,Object>  expData = DummyTestData.expDummyOlusturMap();

        Response response=given().spec(specDummyURL).when().get("{pp1}/{pp2}");
        response.prettyPrint();

        Map<String,Object> resMap = response.as(Map.class);
        assertEquals(DummyTestData.basariliStatusCode,response.getStatusCode());
        assertEquals(DummyTestData.contentType,response.getContentType());

        assertEquals(expData.get("status"),resMap.get("status"));

        assertEquals(((Map)(expData.get("data"))).get("id"),((Map)(resMap.get("data"))).get("id"));
        assertEquals(((Map)(expData.get("data"))).get("employee_name"),((Map)(resMap.get("data"))).get("employee_name"));
        assertEquals(((Map)(expData.get("data"))).get("employee_salary"),((Map)(resMap.get("data"))).get("employee_salary"));
        assertEquals(((Map)(expData.get("data"))).get("profile_image"),((Map)(resMap.get("data"))).get("profile_image"));

    }
}