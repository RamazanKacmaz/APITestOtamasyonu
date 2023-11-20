package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrldummyexampel {

    protected RequestSpecification specDummyExampel;

    @Before
    public void setup(){

        specDummyExampel = new RequestSpecBuilder().setBaseUri("http://dummy.restapiexample.com/api/v1").build();
    }
}
