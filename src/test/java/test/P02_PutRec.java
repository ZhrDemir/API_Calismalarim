package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class P02_PutRec {

    /*
http://dummy.restapiexample.com/api/v1/update/21 url'ine asagidaki
body'ye sahip bir PUT request gonderdigimizde donen response'un asagidaki gibi oldugunu test edin.
        Request Body
        {
            "status":"success",
            "data":{
                    "name":"Ahmet",
                    "salary":"1230",
                    "age":"44",
                    "id":40
                    }
        }
        Response Body
        {
        "status":"success",
        "data":{
            "status":"success",
            "data":{
                    "name":"Ahmet",
                    "salary":"1230",
                    "age":"44",
                    "id":40
                    }
               },
        "message":"Successfully! Record has been updated."
        }
             */

    @Test
    public void test01(){

        String url = "http://dummy.restapiexample.com/api/v1/update/21";

        JSONObject reqBody = new JSONObject();
        JSONObject innerReqBody = new JSONObject();

        innerReqBody.put("name","Ahmet");
        innerReqBody.put( "salary","1230");
        innerReqBody.put("age","44");
        innerReqBody.put("id",40);

        reqBody.put("status","success");
        reqBody.put("data",innerReqBody);

        //ExpectedData
        JSONObject expDat = new JSONObject();
        expDat.put( "status","success");
        expDat.put( "data",reqBody);
        expDat.put( "message","Successfully! Record has been updated.");

        Response response = given().contentType(ContentType.JSON).when().body(reqBody.toString()).put(url);
        response.prettyPrint();

        JsonPath resJPath = response.jsonPath();

        assertEquals(expDat.get("status"),resJPath.get("status"));
        assertEquals(expDat.get("message"),resJPath.get("message"));
        assertEquals(expDat.getJSONObject("data").get("status"),resJPath.get("data.status"));
        assertEquals(expDat.getJSONObject("data").getJSONObject("data").get("name"),resJPath.get("data.data.name"));
        assertEquals(expDat.getJSONObject("data").getJSONObject("data").get("salary"),resJPath.get("data.data.salary"));
        assertEquals(expDat.getJSONObject("data").getJSONObject("data").get("age"),resJPath.get("data.data.age"));
        assertEquals(expDat.getJSONObject("data").getJSONObject("data").get("id"),resJPath.get("data.data.id"));





    }


}
