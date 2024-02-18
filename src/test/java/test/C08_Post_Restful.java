package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C08_Post_Restful {


    @Test
    public void post(){

        /*
        https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST
request gonderdigimizde
{
"firstname" : "Ahmet",
"lastname" : “Bulut",
"totalprice" : 500,
"depositpaid" : false,
"bookingdates" : {
"checkin" : "2021-06-01",
"checkout" : "2021-06-10"
},
"additionalneeds" : "wi-fi"
}
         */

    String url = " https://restful-booker.herokuapp.com/booking";

        JSONObject date = new JSONObject();
        date.put("checkin","2021-06-01");
        date.put("checkout","2021-06-10");

        JSONObject person = new JSONObject();
        person.put("firstname","Ahmet");
        person.put("lastname","Bulut");
        person.put("totalprice",500);
        person.put("depositpaid",false);
        person.put("bookingdates",date);
        person.put("additionalneeds","wi-fi");


      /*
      status code’unun 200,
ve content type’inin application-json,
ve response body’sindeki
"firstname“in,"Ahmet",
ve "lastname“in, "Bulut",
ve "totalprice“in,500,
ve "depositpaid“in,false,
ve "checkin" tarihinin 2021-06-01
ve "checkout" tarihinin 2021-06-10
ve "additionalneeds“in,"wi-fi"

       */
        Response response = given().contentType(ContentType.JSON).when().body(person.toString()).post(url);

        System.out.println(person);

        response.then().assertThat().statusCode(200)
                .contentType("application/json")
                .body("booking.firstname", equalTo("Ahmet"),"booking.lastname",equalTo("Bulut"),
                       "booking.totalprice",equalTo(500) ,"booking.depositpaid",equalTo(false),
                        "booking.bookingdates.checkin",equalTo("2021-06-01"),
                        "booking.bookingdates.checkout",equalTo("2021-06-10"),
                        "booking.additionalneeds",equalTo("wi-fi"));

        System.out.println(person.getJSONObject("bookingdates").get("checkin"));

    }





}
