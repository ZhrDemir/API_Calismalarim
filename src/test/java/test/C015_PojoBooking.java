package test;

import baseURLDeposu.RestfulBookerBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.HerokuappExpectedPojo;

import static io.restassured.RestAssured.given;

public class C015_PojoBooking extends RestfulBookerBaseURL {


    /*
    C26_Post_Pojo
https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST
request gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.
Response Body // expected data
{
"bookingid": 24,
"booking": {
"firstname": "Ahmet",
"lastname": "Bulut",
"totalprice": 500,
"depositpaid": false,
"bookingdates": {
"checkin": "2021-06-01",
"checkout": "2021-06-10"
},
"additionalneeds": "wi-fi"
}
}
Request body
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

@Test
    public void post(){

    specRestful.pathParam("pp1","booking");

    BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2021-06-01","2021-06-10");
    BookingPojo resBody = new BookingPojo("Ali","Bak",500,false,bookingDatesPojo,"wi-fi");
    HerokuappExpectedPojo expectedPojo= new HerokuappExpectedPojo(24,resBody);

    Response response = given().spec(specRestful).contentType(ContentType.JSON).when().body(resBody).post("{pp1}");
    response.prettyPrint();

    HerokuappExpectedPojo resPojo = response.as(HerokuappExpectedPojo.class);
    Assert.assertEquals(expectedPojo.getBooking().getFirstname(),resPojo.getBooking().getFirstname());
    Assert.assertEquals(expectedPojo.getBooking().getLastname(),resPojo.getBooking().getLastname());
    Assert.assertEquals(expectedPojo.getBooking().getBookingdates().getCheckin()
            ,resPojo.getBooking().getBookingdates().getCheckin());
    Assert.assertEquals(expectedPojo.getBooking().isDepositpaid(),resPojo.getBooking().isDepositpaid());






}

}
