import static io.restassured.RestAssured.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class GenerateOtpTest {
    public static void main(String[] args) throws Exception {
        MobilePojo mobilePojo = new MobilePojo();
        mobilePojo.setMobile("9876543220");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(mobilePojo);
        RequestSpecification request = RestAssured.given();
        request.body(json);
        Response response = request.post("https://cdndemo-api.co-vin.in/api/v2/auth/public/generateOTP");
        System.out.println(response.getBody().asString());
        Assert.assertEquals(response.statusCode(), 200);
    }

}
