package starter.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.auth.PosLogAdmin;
import starter.auth.NegLogAdmin;

public class AuthAdminSteps {
    @Steps
    PosLogAdmin PosLogAdmin;

    @Steps
    NegLogAdmin NegLogAdmin;


    @Given("I set Post API Endpoint")
    public void setPostApiEndpoint() {
        PosLogAdmin.setPostApiEndpoint();
    }

    @When("I send Post HTTP Request")
    public void sendPostHTTPRequest() {
        PosLogAdmin.sendPostHttpRequest();
    }

    @Then("I receive valid HTTP Response code 200")
    public void receiveValidHTTP200() {
        PosLogAdmin.validateHttpResponseCode200();
    }

    @And("I receive valid data for my own admin account")
    public void receiveValidDataAdmAccount() {
        PosLogAdmin.validateDataAdmAccount();
    }

//BATAS

    @Given("I set POST API Endpoint")
    public void setPostApiEndpointNeg() {
        NegLogAdmin.setPostApiEndpointNeg();
    }

    @When("I send POST HTTP Request")
    public void sendPostHTTPRequestNeg() {
        NegLogAdmin.sendPostHttpRequestNeg();
    }

    @Then("I receive valid HTTP Response code 500")
    public void receiveValidHTTP500Neg() {
        NegLogAdmin.validateHttpResponseCode500Neg();
    }

    @And("I prevented to login with Error message")
    public void receiveErrMessageAdmPreventedLogin() {
        NegLogAdmin.validateErrMessageAdmPreventedLogin();
    }



}