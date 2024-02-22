package test;

import baseURLDeposu.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;
import testDataKlasoru.JsonObjeleriTestDatalari;

import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class C012_Tekrar_JsonPlaceHolder extends JsonPlaceHolderBaseURL {

    @Test
    public void putTest02(){
        /*
        C4_Put_ResponseBilgileriAssertion
https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki Json formatindaki body ile bir
PUT request gonderdigimizde
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}
donen Response’un,
status code’unun 200,
ve content type’inin application/json; charset=utf-8,
ve Server isimli Header’in degerinin cloudflare,
ve status Line’in HTTP/1.1 200 OK
         */

        specJsonPlace.pathParam("pp1",70);

        Response response=given().spec(specJsonPlace).
                contentType(ContentType.JSON)
                .when().body(JsonObjeleriTestDatalari.putReqOlusturma().toString()).put("{pp1}");

         response.prettyPrint();
         response.then().assertThat()
                 .statusCode(200)
                 .contentType("application/json; charset=utf-8");

    }

    @Test
    public void getTest01(){

    /*
    C5_Get_ResponseBodyTesti
https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET request yolladigimizda
donen Response’in
status code'unun 200,
ve content type'inin application/json; charset=utf-8,
ve response body'sinde bulunan userId'nin 5,
ve response body'sinde bulunan title'in "optio dolor molestias sit"
oldugunu test edin.
     */

        specJsonPlace.pathParam("pp1",44);
        Response response = given().spec(specJsonPlace)
                .when().get("{pp1}");

        response.prettyPrint();
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("userId", equalTo(5),"title",equalTo("optio dolor molestias sit"));

    }



    @Test
    public void postTest01(){

        /*
        C6_Post_ResponseBodyTesti
https://jsonplaceholder.typicode.com/posts url’ine asagidaki body ile bir POST request
gonderdigimizde
{
"title":"API",
"body":"API ogrenmek ne guzel",
"userId":10,
}
donen Response’un,
status code’unun 201,
ve content type’inin application/json
ve Response Body'sindeki,
"title"'in "API" oldugunu
"userId" degerinin 100'den kucuk oldugunu
"body" nin "API" kelimesi icerdigini
test edin.
         */

        JSONObject reqJO = new JSONObject();
        reqJO.put("title","API");
        reqJO.put("body","API ogrenmek ne guzel");
        reqJO.put("userId",10);

        Response response = given().spec(specJsonPlace).contentType(ContentType.JSON).when().body(reqJO.toString()).post();
        response.prettyPrint();

        response.then().assertThat()
                .statusCode(201)
                .contentType("application/json")
                .body("title",equalTo("API"),
                        "userId",lessThan(100),
                        "body",containsString("API"));


    }
/*
C19_Put_TestDataClassKullanimi
https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir
PUT request yolladigimizda donen response’in
status kodunun 200, content type’inin “application/json; charset=utf-8”,
Connection header degerinin “keep-alive”
ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
TEST DATA CLASS KULLANIMI
Expected Data :
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}
Request Body
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70

 */

    @Test
    public void put(){

        //1-Url
        specJsonPlace.pathParam("pp1",70);
        //2-Request
        JSONObject reqBody = JsonObjeleriTestDatalari.putReqOlusturma();
        //3-Expected
        JSONObject expBody = JsonObjeleriTestDatalari.putReqOlusturma();
        //4-Response
        Response response = given().spec(specJsonPlace).contentType(ContentType.JSON).
                body(reqBody.toString()).when().put("{pp1}");
        response.prettyPrint();

        assertEquals(JsonObjeleriTestDatalari.basariliStatusCode,response.getStatusCode());
        assertEquals(JsonObjeleriTestDatalari.contentType,response.getContentType());
        assertEquals(JsonObjeleriTestDatalari.connectionHeaderDeğeri,response.getHeader("Connection"));
        assertEquals(expBody.get("userId"),reqBody.get("userId"));
        assertEquals(expBody.get("id"),reqBody.get("id"));
        assertEquals(expBody.get("title"),reqBody.get("title"));
        assertEquals(expBody.get("body"),reqBody.get("body"));

    }
/*
C19_Put_TestDataClassKullanimi
https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir
PUT request yolladigimizda donen response’in
status kodunun 200, content type’inin “application/json; charset=utf-8”,
Connection header degerinin “keep-alive”
ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
TEST DATA CLASS KULLANIMI
Expected Data :
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}
Request Body
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70

 */
    //---------------DeSerialization----------

    @Test
    public void put1(){

        specJsonPlace.pathParam("pp1",70);

         Map<String, Object> reqBody = JsonObjeleriTestDatalari.putReqOlusturmaMap();
         Map<String, Object> expBody = JsonObjeleriTestDatalari.putReqOlusturmaMap();

         Response response = given().spec(specJsonPlace).
                 contentType(ContentType.JSON).when().body(reqBody).put("{pp1}");

         response.prettyPrint();

         Map<String,Object> resMap = response.as(Map.class);

        Assert.assertEquals(expBody.get("title"),resMap.get("title"));
        Assert.assertEquals(expBody.get("body"),resMap.get("body"));
        Assert.assertEquals(expBody.get("userId"),resMap.get("userId"));
        Assert.assertEquals(expBody.get("id"),resMap.get("id"));

    }


}
