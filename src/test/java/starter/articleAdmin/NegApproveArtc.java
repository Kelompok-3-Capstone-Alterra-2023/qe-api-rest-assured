package starter.articleAdmin;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class NegApproveArtc {
    protected static String url = "https://capstone-project.duckdns.org:8080/";
    private String authToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhZG1pbl9pZCI6MSwiYXV0aG9yaXplZCI6dHJ1ZSwiZXhwIjoxNjg3ODQzOTg1fQ.LasIIXHip-iUUTecrsXhszZfnycHm30wwWneOG_MDWc";
    private Response response;

    @Step("I set PUT API Endpoint")
    public String setPostApiEndpointNeg(){
        return url + "admin/articles/abc";
    }

    @Step("I send PUT Http request")
    public void sendPostHttpRequestNeg(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("status", "disetujui");

        response = SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + authToken)
                .body(requestBody.toJSONString())
                .put(setPostApiEndpointNeg())
                .then().extract().response();
    }

    @Step("I receive valid Http response code is 500")
    public void validateHttpResponseCode500Neg(){
        restAssuredThat(response -> response.statusCode(500));
    }

    @Step("I receive error message and prevented to approve an article")
    public void validateErrMessageApproveArticle(){
        restAssuredThat(response -> response.body("'message'", equalTo("Error 1292 (22007): Truncated incorrect INTEGER value: 'abc'")));
    }
}
