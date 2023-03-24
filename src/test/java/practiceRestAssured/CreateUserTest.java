package practiceRestAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateUserTest {

    @Test
    public void testUserCreation(){
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setId("3231");
        createUserRequest.setJob("test");
        createUserRequest.setName("John");
        RequestSpecification request = RestAssured.given();
        request.body(createUserRequest);
        Response response = request.post("https://reqres.in/api/users");
        System.out.println(response.getBody().asString());
        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(createUserRequest.getId(),response.jsonPath().get("id"));

    }
}
