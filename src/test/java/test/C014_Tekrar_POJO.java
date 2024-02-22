package test;

import baseURLDeposu.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.JsonPlaceReqBodyPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C014_Tekrar_POJO extends JsonPlaceHolderBaseURL {


    /*
    C25_Put_PojoClass
https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir
PUT request yolladigimizda donen response’in response body’sinin asagida
verilen ile ayni oldugunu test ediniz
POJO CLASS ILE EXPECTED DATA TESTI
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
}

     */
@Test
    public void put01(){

    //1Url Req
    specJsonPlace.pathParam("pp1","70");

    JsonPlaceReqBodyPojo reqBody = new JsonPlaceReqBodyPojo("Ahmet","Merhaba",10,70);

    System.out.println("reqBody = " + reqBody);

    //2-Expected

    JsonPlaceReqBodyPojo expBody = new JsonPlaceReqBodyPojo("Ahmet","Merhaba",10,70);

   //3-Response

    Response response=given().spec(specJsonPlace).contentType(ContentType.JSON).when().body(reqBody).put("{pp1}");

    response.prettyPrint();

    //4-Assert

    JsonPlaceReqBodyPojo resPojo = response.as(JsonPlaceReqBodyPojo.class);

    assertEquals(expBody.getBody(),resPojo.getBody());
    assertEquals(expBody.getId(),resPojo.getId());
    assertEquals(expBody.getTitle(),resPojo.getTitle());
    assertEquals(expBody.getUserId(),resPojo.getUserId());




}
}
