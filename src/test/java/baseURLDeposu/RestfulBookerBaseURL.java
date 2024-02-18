package baseURLDeposu;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class RestfulBookerBaseURL {

    protected RequestSpecification specRestful;

    @Before
    public void setUp(){

        specRestful = new RequestSpecBuilder().
                setBaseUri("https://restful-booker.herokuapp.com/booking/").
                build();



    }
}
