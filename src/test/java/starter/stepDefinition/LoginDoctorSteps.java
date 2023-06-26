package starter.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.auth.NegLoginDoctor;
import starter.auth.PosLoginDoctor;


public class LoginDoctorSteps {
    @Steps
    PosLoginDoctor postlog;

    @Steps
    NegLoginDoctor neglog;

    @Given("I set Post API endpoint")
    public void setPostApiEndpoint() {
        postlog.setPostApiEndpoint();
    }

    @When("I send Post HTTP request")
    public void sendPostHTTPRequest() {
        postlog.sendPostHttpRequest();
    }

    @Then("I receive valid HTTP Response code is 200")
    public void receiveValidHTTP200() {
        postlog.validateHttpResponseCode200();
    }

    @And("I receive valid data for existing user account")
    public void receiveValidDataRatingProduct() {
        postlog.validateDataRatingProduct();
    }


    //================neg
    @Given("I set POST API endpoint")
    public void setPostApiEndpointNeg() {
        neglog.setPostApiEndpointNeg();
    }

    @When("User send request body login failed email empty")
    public void sendPostHTTPRequestNeg() {
        neglog.sendPostHttpRequestneg();
    }

    @Then("User receive response code 500")
    public void receiveValidHTTP500Neg() {
        neglog.validateHttpResponseCode500neg();
    }

    @And("User receive response body error email is required")
    public void receiveValidDataRatingProductNeg() {
        neglog.responseBodyErrorEmailIsRequired();
    }

}
