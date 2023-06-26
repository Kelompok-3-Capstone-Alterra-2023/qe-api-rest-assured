package starter.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.auth.PosLogUser;
import starter.auth.NegLogUser;

public class AuthUserSteps {
    @Steps
    PosLogUser PosLogUser;

    @Steps
    NegLogUser NegLogUser;


    @Given("I set Post API endpoint")
    public void setPostApiEndpoint() {
        PosLogUser.setPostApiEndpoint();
    }

    @When("I send Post HTTP request")
    public void sendPostHTTPRequest() {
        PosLogUser.sendPostHttpRequest();
    }

    @Then("I receive valid HTTP Response code is 200")
    public void receiveValidHTTP200() {
        PosLogUser.validateHttpResponseCode200();
    }

    @And("I receive valid data for existing user account")
    public void receiveValidDataExistingAccount() {
        PosLogUser.validateDataExistingAccount();
    }
//BATAS
    @Given("I set POST API endpoint")
    public void setPostApiEndpointNeg() {
        NegLogUser.setPostApiEndpointNeg();
    }

    @When("I send POST HTTP request")
    public void sendPostHTTPRequestNeg() {
        NegLogUser.sendPostHttpRequestNeg();
    }

    @Then("I receive valid HTTP Response code is 400")
    public void receiveValidHTTP400Neg() {
        NegLogUser.validateHttpResponseCode400Neg();
    }

    @And("I prevented to login with error message")
    public void receiveErrMessagePreventedLogin() {
        NegLogUser.validateErrMessagePreventedLogin();
    }



}