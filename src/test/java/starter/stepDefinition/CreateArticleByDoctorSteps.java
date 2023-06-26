package starter.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.articles.PosCreateArticle;

public class CreateArticleByDoctorSteps {
    @Steps
    PosCreateArticle posArticle;

    @Given("I set post API Endpoint")
    public void setPostApiEndpoint() {
        posArticle.setPostApiEndpoint();
    }

    @When("I send post HTTP Request")
    public void sendPostHTTPRequest() {
        posArticle.sendPostHttpRequest();
    }

    @Then("I receive valid HTTP Response code 200")
    public void receiveValidHTTP200() {
        posArticle.validateHttpResponseCode200();
    }

    @And("I receive valid data for create article")
    public void receiveValidDataRatingProduct() {
        posArticle.validateDataRatingProduct();
    }

}
