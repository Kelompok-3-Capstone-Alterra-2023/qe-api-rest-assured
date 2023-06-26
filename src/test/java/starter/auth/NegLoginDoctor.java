package starter.auth;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class NegLoginDoctor {
    protected static String url = "https://capstone-project.duckdns.org:8080/";
    // ===============positif
    @Step("I set POST api endpoint")
    public String setPostApiEndpointNeg(){
        return url + "doctor/login";
    }
    @Step("I send POST HTTP Request")
    public void sendPostHttpRequestneg(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "");
        requestBody.put("password", "rL^Ngy@^AZ");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(setPostApiEndpointNeg());
    }


    @Step("User receive response code 500")
    public void validateHttpResponseCode500neg(){
        restAssuredThat(response -> response.statusCode(500));
    }
    @Step("User receive response body error email is required")
    public void responseBodyErrorEmailIsRequired(){
        restAssuredThat(response -> response.body("'message'", equalTo("failed to login")));
    }
    // --------------------------negatif
}
