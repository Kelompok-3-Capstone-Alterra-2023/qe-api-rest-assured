package starter.articleAdmin;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class PosApproveArtc {
    protected static String url = "https://capstone-project.duckdns.org:8080/";
    private String authToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhZG1pbl9pZCI6MSwiYXV0aG9yaXplZCI6dHJ1ZSwiZXhwIjoxNjg3ODQzOTg1fQ.LasIIXHip-iUUTecrsXhszZfnycHm30wwWneOG_MDWc";
    private Response response;

    @Step("I set PUT API endpoint")
    public String setPostApiEndpoint(){
        return url + "admin/articles/21";
    }

    @Step("I send PUT Http Request")
    public void sendPostHttpRequest(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("status", "disetujui");

        response = SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + authToken)
                .body(requestBody.toJSONString())
                .put(setPostApiEndpoint())
                .then().extract().response();
    }

    @Step("I receive valid Http response code is 200")
    public void validateHttpResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I receive valid data for approved article")
    public void validateDataApprovedArticle(){
        restAssuredThat(response -> response.body("'message'", equalTo("success manage article")));
    }
}
