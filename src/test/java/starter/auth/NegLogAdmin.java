package starter.auth;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class NegLogAdmin {
    protected static String url = "https://capstone-project.duckdns.org:8080/";

    @Step("I set POST API Endpoint")
    public String setPostApiEndpointNeg(){
        return url + "admin/login";
    }
    @Step("I send POST HTTP Request")
    public void sendPostHttpRequestNeg(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "");
        requestBody.put("password", "");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(setPostApiEndpointNeg());
    }


    @Step("I receive valid HTTP Response code 500")
    public void validateHttpResponseCode500Neg(){
        restAssuredThat(response -> response.statusCode(500));
    }
    @Step("I prevented to login with Error message")
    public void validateErrMessageAdmPreventedLogin(){
        restAssuredThat(response -> response.body("'message'", equalTo("failed to login")));
    }


}
