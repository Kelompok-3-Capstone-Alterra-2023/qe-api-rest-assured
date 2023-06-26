package starter.auth;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class NegLogUser {
    protected static String url = "https://capstone-project.duckdns.org:8080/";

    @Step("I set POST api endpoint")
    public String setPostApiEndpointNeg(){
        return url + "user/login";
    }
    @Step("I send POST HTTP Request")
    public void sendPostHttpRequestNeg(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "audyva.alifia26@gmail.com");
        requestBody.put("password", "ihhwibuu");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(setPostApiEndpointNeg());
    }


    @Step("I receive valid HTTP response code is 400")
    public void validateHttpResponseCode400Neg(){
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step("I prevented to login with error message")
    public void validateErrMessagePreventedLogin(){
        restAssuredThat(response -> response.body("'message'", equalTo("email or password wrong")));
    }


}
