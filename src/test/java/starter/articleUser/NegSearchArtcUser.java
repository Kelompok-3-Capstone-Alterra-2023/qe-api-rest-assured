package starter.articleUser;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.Collections;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class NegSearchArtcUser {
    protected static String url = "https://capstone-project.duckdns.org:8080/";

    @Step("I set GET API endpoint")
    public String setApiEndpointNeg(){
        return url + "articles/search?keyword=afjnskjfnklsnfl";
    }
    @Step("I send GET HTTP request")
    public void sendGetHttpRequestNeg(){
        SerenityRest.given().get(setApiEndpointNeg());
    }
    @Step("I Receive valid HTTP response code is 200")
    public void validateHttpResponseCode200Neg(){
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("I receive blank data for article based on my false keyword")
    public void validateDataArticleKeywordNeg(){
        restAssuredThat(response -> response.body("data", equalTo(Collections.emptyList()))
                .body("message", equalTo("success get articles")));
    }


}
