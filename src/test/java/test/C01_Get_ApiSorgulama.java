package test;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class C01_Get_ApiSorgulama{

/*
https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde donen Response’un,
  status code’unun 200,
 ve content type’inin application/json; charset=utf-8,
 ve Server isimli Header’in degerinin Cowboy,
 ve status Line’in HTTP/1.1 200 OK
 ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
 */

// 1- Request body ve end-point hazirlama
// 2- Expected Data hazirlama
// 3- Request gönderip, dönen response'i kaydetme
// 4- Assertion
@Test
    public void get(){
    // 1- Request body ve end-point hazirlama

    String url = "https://restful-booker.herokuapp.com/booking/10";

    // 3- Request gönderip, dönen response'i kaydetme
    Response response = given().when().get(url);

    response.prettyPrint();
    System.out.println(response.getStatusCode());
    System.out.println(response.getContentType());
    System.out.println(response.getHeader("Server"));
    System.out.println(response.getStatusLine());
    System.out.println(response.getTime());

}




}
