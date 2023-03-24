package practiceRestAssured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.plaf.nimbus.State;
import java.util.*;

public class SetuTest {

    @Test
    public void setuTest() throws JsonProcessingException {
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.get("https://cdndemo-api.co-vin.in/api/v2/admin/location/states");
        Assert.assertEquals(response.getStatusCode(), 200);
        SetupGetResponse responseBody = response.body().as(SetupGetResponse.class);
        //System.out.println(responseBody.getStates());

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(responseBody.getStates());
        List<States> statesCheck = Arrays.asList(mapper.readValue(jsonString, States[].class));
        for (States states : statesCheck) {
            System.out.println("States: " + states.getState_id() + ", Statename: " + states.getState_name());
            Response responseDistrict = requestSpecification.get("https://cdndemo-api.co-vin.in/api//v2/admin/location/districts/" + states.getState_id());
            System.out.println(responseDistrict.getBody().asString());
        }
    }
}
