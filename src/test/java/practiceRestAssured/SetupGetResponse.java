package practiceRestAssured;

import org.json.JSONString;

import java.util.List;

public class SetupGetResponse {
    private List<JSONString> states;

    private String ttl;

    public List<JSONString> getStates() {
        return states;
    }


    public void setStates(List states) {
        this.states = states;
    }
    public String getTtl() {
        return ttl;
    }
    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

}

