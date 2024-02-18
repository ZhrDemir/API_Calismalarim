package test;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C06_GetBodyTekrari {
/*
https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde
donen Response’un,
status code’unun 200,
ve content type’inin application-json,
ve response body’sindeki
"firstname“in, "Susan",
ve "lastname“in, "Jackson",
ve "totalprice“in, 612,
ve "depositpaid“in, false,
ve ""additionalneeds"“in, "Breakfast"


 */
    @Test
    public void get(){

        String url = "https://restful-booker.herokuapp.com/booking/10";

        Response response= given().when().get(url);
        response.prettyPrint();
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("firstname", equalTo("Jim"),
                        "lastname",equalTo("Ericsson"),
                        "totalprice",equalTo(886),
                        "depositpaid",equalTo(false)
                        );



    }
}
