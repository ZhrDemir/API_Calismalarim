package test;

import baseURLDeposu.JsonPlaceHolderBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDataKlasoru.JsonObjeleriTestDatalari;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class P04_TestDataKullanimi extends JsonPlaceHolderBaseURL {

    /*
https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET
request yolladigimizda donen response'in status kodunun 200 ve
response body'sinin asagida verilen ile ayni oldugunu test ediniz
 Response body :
  {
  "userId":3,
  "id":22,
  "title":"dolor sint quo a velit explicabo quia nam",
  "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
  um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
  }
   */

@Test
    public void test01(){

    specJsonPlace.pathParam("pp1",22);

    JSONObject expData = JsonObjeleriTestDatalari.expectedBodyOlusturJSON();

    Response response=given().spec(specJsonPlace).when().get("{pp1}");

    JsonPath responseJP=response.jsonPath();

   assertEquals(JsonObjeleriTestDatalari.basariliStatusCode,response.getStatusCode());
   assertEquals(expData.getInt("userId"),responseJP.getInt("userId"));
   assertEquals(expData.getInt("id"),responseJP.getInt("id"));
   assertEquals(expData.getString("body"),responseJP.getString("body"));
   assertEquals(expData.getString("title"),responseJP.getString("title"));








}




}
