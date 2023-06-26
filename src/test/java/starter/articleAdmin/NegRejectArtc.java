package starter.articleAdmin;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class NegRejectArtc {
    protected static String url = "https://capstone-project.duckdns.org:8080/";
    private String authToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhZG1pbl9pZCI6MSwiYXV0aG9yaXplZCI6dHJ1ZSwiZXhwIjoxNjg3ODQzOTg1fQ.LasIIXHip-iUUTecrsXhszZfnycHm30wwWneOG_MDWc";
    private Response response;

    @Step("I Set PUT API Endpoint")
    public String setPostAPIEndpointsNeg(){
        return url + "admin/articles/abc";
    }

    @Step("I Send PUT Http request")
    public void sendPostHTTPRequestNeg(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("status", "ditolak");

        response = SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + authToken)
                .body(requestBody.toJSONString())
                .put(setPostAPIEndpointsNeg())
                .then().extract().response();
    }

    @Step("I Receive valid Http response code is 500")
    public void receiveValidHTTP500Neg(){
        restAssuredThat(response -> response.statusCode(500));
    }

    @Step("I receive error message and prevented to reject an article")
    public void receiveErrorAndPreventedToReject(){
        restAssuredThat(response -> response.body("'message'", equalTo("Error 1292 (22007): Truncated incorrect INTEGER value: 'abc'")));
    }
}
