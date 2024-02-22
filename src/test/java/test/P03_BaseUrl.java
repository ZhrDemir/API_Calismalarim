package test;

import baseURLDeposu.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class P03_BaseUrl extends JsonPlaceHolderBaseURL {




        //Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin

    @Test
    public void test01() {
    /*
        1-  https://jsonplaceholder.typicode.com/posts endpointine bir GET
         request gonderdigimizde donen response'un status code'unun 200 oldugunu
         ve Response'ta ("title" degerlerinin) 100 kayit oldugunu test edin.
        */

        Response response = given().spec(specJsonPlace).when().get();
        response.then().assertThat()
                .statusCode(200)
                .body("title", hasSize(100));
    }
        @Test
        public void test02() {
    /*
        2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET
            request gonderdigimizde donen response'un status code'unun 200 oldugunu
            ve "title" degerinin "optio dolor molestias sit" oldugunu test edin
         */
            specJsonPlace.pathParam("pp1", 44);

            Response response = given().spec(specJsonPlace).when().get("{pp1}");

            response.then().assertThat().statusCode(200)
                    .body("title",equalTo("optio dolor molestias sit"));


        }



        @Test
    public void test03() {

        /*
        3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE
            request gonderdigimizde donen response'un status code'unun 200 oldugunu ve
            response body'sinin null oldugunu test edin
         */
          specJsonPlace.pathParam("pp1",50);
          Response response = given().spec(specJsonPlace).
                  contentType(ContentType.JSON).when().delete("{pp1}");

          response.prettyPrint();
          response.then().assertThat().statusCode(200)
                  .body("body",nullValue());
        }
}
