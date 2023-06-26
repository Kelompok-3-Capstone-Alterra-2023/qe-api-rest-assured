package starter.receipt;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class PosCreateReceiptDoc {
    protected static String url = "https://capstone-project.duckdns.org:8080/";
    private String authToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJkb2N0b3JfaWQiOjE1LCJleHAiOjE2ODc4NTIyMTYsInJvbGUiOiJkb2N0b3IifQ.JG_-DJhlxIXnMCN2LPAiaNVNrDwbleWiWafYtfq-8u4";
    private Response response;
    // ===============positif
    @Step("I set to post API Endpoint")
    public String setPostApiEndpointDok(){
        return url + "doctor/recipt/4";
    }
    @Step("I send to post HTTP Request")
    public void sendPostHttpRequest(){
        JSONObject requestBody = new JSONObject();
        JSONArray drugsArray = new JSONArray();

        JSONObject drug1 = new JSONObject();
        drug1.put("ID", 2);
        drugsArray.add(drug1);

        JSONObject drug2 = new JSONObject();
        drug2.put("ID", 3);
        drugsArray.add(drug2);

        JSONObject drug3 = new JSONObject();
        drug3.put("ID", 5);
        drugsArray.add(drug3);

        requestBody.put("drugs", drugsArray);

        System.out.println(requestBody.toJSONString());

        SerenityRest.given().header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + authToken)
                .body(requestBody.toJSONString())
                .post(setPostApiEndpointDok());
    }


    @Step("I receive valid HTTP Response 200")
    public void validateHttpResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("I receive valid data for create receipt")
    public void validateDataRatingProduct(){
        restAssuredThat(response -> response.body("'message'", equalTo("success create recipt")));
    }
    // --------------------------negatif
}
