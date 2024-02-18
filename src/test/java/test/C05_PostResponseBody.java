package test;

import baseURLDeposu.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class C05_PostResponseBody extends JsonPlaceHolderBaseURL {
    @Test
    public void post(){

/*
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

 String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject jO = new JSONObject();
        jO.put("title","API");
        jO.put("body","API ogrenmek ne guzel");
        jO.put("userId",10);

 Response response = given().contentType(ContentType.JSON).when().body(jO.toString()).post(url);

 response.prettyPrint();
 response.then().assertThat()
         .statusCode(201)
         .contentType("application/json")
         .body("title", equalTo("API"),"body",equalTo("API ogrenmek ne guzel"),"userId",lessThan(100));









    }
}
