package starter.auth;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class PosLogAdmin {
    protected static String url = "https://capstone-project.duckdns.org:8080/";

    @Step("I set Post API Endpoint")
    public String setPostApiEndpoint(){
        return url + "admin/login";
    }
    @Step("I send Post HTTP Request")
    public void sendPostHttpRequest(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "admin@admin.com");
        requestBody.put("password", "admin");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(setPostApiEndpoint());
    }


    @Step("I receive valid HTTP Response code 200")
    public void validateHttpResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("I receive valid data for my own admin account")
    public void validateDataAdmAccount(){
        restAssuredThat(response -> response.body("'message'", equalTo("success login")));
    }


}
