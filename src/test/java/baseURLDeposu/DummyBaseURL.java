package baseURLDeposu;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyBaseURL {

protected RequestSpecification specDummyURL;

@Before
    public void setUp(){

    specDummyURL =new  RequestSpecBuilder()
            .setBaseUri("http://dummy.restapiexample.com/api/v1").build();







}


}
