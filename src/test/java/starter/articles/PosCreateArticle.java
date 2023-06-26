package starter.articles;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import java.io.File;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;


public class PosCreateArticle {
    protected static String url = "https://capstone-project.duckdns.org:8080/";
    private String authToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJkb2N0b3JfaWQiOjE1LCJleHAiOjE2ODc4NTIyMTYsInJvbGUiOiJkb2N0b3IifQ.JG_-DJhlxIXnMCN2LPAiaNVNrDwbleWiWafYtfq-8u4";
    private Response response;

    @Step("I set post API Endpoint")
    public String setPostApiEndpoint() {
        return url + "doctor/articles";
    }

    @Step("I send post HTTP Request")
    public void sendPostHttpRequest() {
        File photoFile = new File("C:\\Users\\WINDOWS 11\\Downloads\\small.jpg"); // Replace with the actual file path

        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "Pengaruh Inner Child pada mental");
        requestBody.put("content", "Permasalahan Gen Z tentang inner child");
        requestBody.put("category", "Kesehatan Mental");

        Response response = SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + authToken)
                .contentType("multipart/form-data")
                .multiPart("thumbnail", photoFile, "image/jpeg")
                .formParam("title", "Pengaruh Inner Child pada mental")
                .formParam("content", "Permasalahan Gen Z tentang inner child")
                .formParam("category", "Kesehatan Mental")
                .post(setPostApiEndpoint());


        // Process the response as needed
    }

    @Step("I receive valid HTTP Response code 200")
    public void validateHttpResponseCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I receive valid data for create article")
    public void validateDataRatingProduct() {
        restAssuredThat(response -> response.body("'message'", equalTo("success add article")));
    }
}
