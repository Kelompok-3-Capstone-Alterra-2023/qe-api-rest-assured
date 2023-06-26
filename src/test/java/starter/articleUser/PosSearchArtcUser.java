package starter.articleUser;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class PosSearchArtcUser {
    protected static String url = "https://capstone-project.duckdns.org:8080/";

    @Step("I set GET API endpoint")
    public String setApiEndpoint(){
        return url + "articles/search?keyword=mental";
    }
    @Step("I send GET HTTP Request")
    public void sendGetHttpRequest(){
        SerenityRest.given().get(setApiEndpoint());
    }
    @Step("I receive valid HTTP response code is 200")
    public void validateHttpResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("I receive valid data for article based on my keyword")
    public void validateDataArticleKeyword(){
        restAssuredThat(response -> response.body("message", equalTo("success get articles")));
    }


}
