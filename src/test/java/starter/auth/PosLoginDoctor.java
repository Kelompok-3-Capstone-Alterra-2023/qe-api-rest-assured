package starter.auth;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class PosLoginDoctor {
    protected static String url = "https://capstone-project.duckdns.org:8080/";
// ===============positif
    @Step("I set Post api endpoint")
    public String setPostApiEndpoint(){
        return url + "doctor/login";
    }
    @Step("I send Post HTTP Request")
    public void sendPostHttpRequest(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "hidayatiiftitah@gmail.com");
        requestBody.put("password", "rL^Ngy@^AZ");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(setPostApiEndpoint());
    }


    @Step("I receive valid HTTP response code is 200")
    public void validateHttpResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("I receive valid data for existing user account")
    public void validateDataRatingProduct(){
        restAssuredThat(response -> response.body("'message'", equalTo("success login")));
    }
    // --------------------------negatif
}
