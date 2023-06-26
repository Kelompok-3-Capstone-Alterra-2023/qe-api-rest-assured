package starter.receipt;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class NegCreateReceiptDoc {
    protected static String url = "https://capstone-project.duckdns.org:8080/";
    private String authToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJkb2N0b3JfaWQiOjE1LCJleHAiOjE2ODc4NTIyMTYsInJvbGUiOiJkb2N0b3IifQ.JG_-DJhlxIXnMCN2LPAiaNVNrDwbleWiWafYtfq-8u4";
    private Response response;
    // ===============positif
    @Step("I set API Endpoint")
    public String setApiEndpointDok(){
        return url + "doctor/recipt/";
    }
    @Step("I send to post HTTP Request")
    public void sendPostHttpRequest(){
        JSONObject requestBody = new JSONObject();
        JSONArray drugsArray = new JSONArray();

        JSONObject drug1 = new JSONObject();
        drug1.put("ID", 1);
        drugsArray.add(drug1);

        JSONObject drug2 = new JSONObject();
        drug2.put("ID", 5);
        drugsArray.add(drug2);

        JSONObject drug3 = new JSONObject();
        drug3.put("ID", 2);
        drugsArray.add(drug3);

        requestBody.put("drugs", drugsArray);

        System.out.println(requestBody.toJSONString());

        SerenityRest.given().header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + authToken)
                .body(requestBody.toJSONString())
                .post(setApiEndpointDok());
    }


    @Step("I receive invalid HTTP with Response code 404")
    public void validateHttpResponseCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }
    @Step("I receive response body error email is required")
    public void validateResponseError(){
        restAssuredThat(response -> response.body("'message'", equalTo("Not Found")));
    }
}
