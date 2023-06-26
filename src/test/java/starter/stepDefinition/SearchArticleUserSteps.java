package starter.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.articleUser.PosSearchArtcUser;
import starter.articleUser.NegSearchArtcUser;

public class SearchArticleUserSteps {
    @Steps
    PosSearchArtcUser PosSearchArtcUser;
    @Steps
    NegSearchArtcUser NegSearchArtcUser;

    @Given("I set GET api endpoint")
    public void setGetApiEndpoints() {
        PosSearchArtcUser.setApiEndpoint();
    }

    @When("I send GET HTTP Request")
    public void sendGetHttpRequest() {
        PosSearchArtcUser.sendGetHttpRequest();
    }

    @Then("I receive valid HTTP response code is 200")
    public void receiveValidHttpResponse() {
        PosSearchArtcUser.validateHttpResponseCode200();
    }

    @And("I receive valid data for article based on my keyword")
    public void validateDataArticleKeyword() {
        PosSearchArtcUser.validateDataArticleKeyword();
    }
//BATAS/////////////////
    @Given("I set GET API endpoint")
    public void setGetApiEndpointsNeg() {
        NegSearchArtcUser.setApiEndpointNeg();
    }

    @When("I send GET HTTP request")
    public void sendGetHttpRequestNeg() {
        NegSearchArtcUser.sendGetHttpRequestNeg();
    }

    @Then("I Receive valid HTTP response code is 200")
    public void receiveValidHttpResponseNeg() {
        NegSearchArtcUser.validateHttpResponseCode200Neg();
    }

    @And("I receive blank data for article based on my false keyword")
    public void validateDataArticleKeywordNeg() {
        NegSearchArtcUser.validateDataArticleKeywordNeg();
    }

}