package starter.auth;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class PosLogUser {
    protected static String url = "https://capstone-project.duckdns.org:8080/";

    @Step("I set POST api endpoint")
    public String setPostApiEndpoint(){
        return url + "user/login";
    }
    @Step("I send POST HTTP Request")
    public void sendPostHttpRequest(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "audyva.alifia26@gmail.com");
        requestBody.put("password", "audyva");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(setPostApiEndpoint());
    }


    @Step("I receive valid HTTP response code is 200")
    public void validateHttpResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("I receive valid data for product category")
    public void validateDataExistingAccount(){
        restAssuredThat(response -> response.body("'message'", equalTo("success login")));
    }


}
