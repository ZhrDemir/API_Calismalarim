package test;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C02_Get_ResponseBilgileri {
 /*   https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request
    gonderdigimizde donen Response’un,
    status code’unun 200,
    ve content type’inin application/json; charset=utf-8,
    ve Server isimli Header’in degerinin Cowboy,
    ve status Line’in HTTP/1.1 200 OK

  */
    @Test
    public void get02() {

        String url = "https://restful-booker.herokuapp.com/booking/10 ";

        Response response = given().when().get(url);

        response.then().assertThat()
                .contentType("application/json; charset=utf-8")
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .header("Server", "Cowboy");

    }


    }





