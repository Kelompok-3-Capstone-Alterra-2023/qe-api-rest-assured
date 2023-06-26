package starter.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.receipt.NegCreateReceiptDoc;
import starter.receipt.PosCreateReceiptDoc;

public class CreateReceiptByDoctorSteps {
    @Steps
    PosCreateReceiptDoc posReceipt;

    @Given("I set to post API Endpoint")
    public void setPostApiEndpointDok() {
        posReceipt.setPostApiEndpointDok();
    }

    @When("I send to post HTTP Request")
    public void sendPostHTTPRequest() {
        posReceipt.sendPostHttpRequest();
    }

    @Then("I receive valid HTTP Response 200")
    public void receiveValidHTTP200() {
        posReceipt.validateHttpResponseCode200();
    }

    @And("I receive valid data for create receipt")
    public void receiveValidDataRatingProduct() {
        posReceipt.validateDataRatingProduct();
    }

//    ====================== NEGATIVE ==================================
    @Steps
    NegCreateReceiptDoc negReceipt;
    @Given("I set API Endpoint")
    public void setApiEndpointDok() {
        negReceipt.setApiEndpointDok();
    }

    @When("I send HTTP Request")
    public void sendPostHttpRequest() {
        negReceipt.sendPostHttpRequest();
    }

    @Then("I receive invalid HTTP with Response code 404")
    public void validateHttpResponseCode404() {
        negReceipt.validateHttpResponseCode404();
    }

    @And("I receive response body error email is required")
    public void validateResponseError() {
        negReceipt.validateResponseError();
    }

}
