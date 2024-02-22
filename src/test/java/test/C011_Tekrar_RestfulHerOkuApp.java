package test;

import baseURLDeposu.RestfulBookerBaseURL;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testDataKlasoru.JsonObjeleriTestDatalari;

import static io.restassured.RestAssured.given;

public class C011_Tekrar_RestfulHerOkuApp extends RestfulBookerBaseURL {

    /*
    C2_Get_ResponseBilgileriAssertion
https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request
gonderdigimizde donen Response’un,
status code’unun 200,
ve content type’inin application/json; charset=utf-8,
ve Server isimli Header’in degerinin Cowboy,
ve status Line’in HTTP/1.1 200 OK

     */
    @Test
     public void getTest01(){
    String url = "https://restful-booker.herokuapp.com/booking/10 ";
    Response response = given().when().get(url);
    response.prettyPrint();
    response.then().assertThat()
            .statusCode(200)
            .contentType("application/json; charset=utf-8")
            .header("Server","Cowboy")
            .statusLine("HTTP/1.1 200 OK");


}

    @Test
    public void getTest02(){

    specRestful.pathParams("pp1","booking","pp2",10);
    Response response = given().spec(specRestful).when().get("{pp1}/{pp2}");
    response.prettyPrint();
    response.then().assertThat().statusCode(200);




    }
    @Test
    public void jsonObjeOlusturma(){
        /*
C3_JsonObjesiOlusturma
Asagidaki JSON Objesini olusturup
konsolda yazdirin.
{
"title":"Ahmet",
"body":"Merhaba",
"userId":1
}       */


   JSONObject jsonObj= new JSONObject();
   jsonObj.put("title","Ahmet");
   jsonObj.put("body","Merhaba");
   jsonObj.put("userId",1);

        System.out.println(jsonObj);



}
@Test
    public void jsonOlusturma(){
        /*
        Asagidaki JSON Objesini olusturup konsolda yazdirin.
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

    JSONObject expBody = JsonObjeleriTestDatalari.putRequestBodyOlusturma();

    System.out.println(expBody);
    System.out.println(expBody.toString());


}



}






















