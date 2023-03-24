package practiceRestAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterResponseTest {

    @Test
    public void testRegistration(){
        RegisterResponse register = new RegisterResponse();
        RequestSpecification requestSpec = RestAssured.given();
        register.setEmail("bhuvan@reqres.in");
        register.setPassword("1234568785");
        requestSpec.body(register);
        Response registerResponse = requestSpec.post("https://reqres.in/api/register");
        System.out.println(registerResponse.getBody().asString());
        Assert.assertEquals(registerResponse.getStatusCode(), 200);

        Response loginResponse = requestSpec.post("https://reqres.in/api/login");
        System.out.println(loginResponse.getBody().asString());
        Assert.assertEquals(loginResponse.getStatusCode(), 200);
    }
}
