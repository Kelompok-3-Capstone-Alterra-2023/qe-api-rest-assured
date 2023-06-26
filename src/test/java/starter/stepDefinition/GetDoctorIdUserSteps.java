package starter.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.GetDoctorByIdUser.PosGetDocIdUser;
import starter.GetDoctorByIdUser.NegGetDocIdUser;

public class GetDoctorIdUserSteps {
    @Steps
    PosGetDocIdUser PosGetDocIdUser;
    @Steps
    NegGetDocIdUser NegGetDocIdUser;

    @Given("I set GET api endpoints")
    public void setGetApiEndpoints() {
        PosGetDocIdUser.setApiEndpoint();
    }

    @When("I send GET http request")
    public void sendGetHttpRequest() {
        PosGetDocIdUser.sendGetHttpRequest();
    }

    @Then("I receive valid http response code 200")
    public void receiveValidHttpResponse() {
        PosGetDocIdUser.validateHttpResponseCode200();
    }

    @And("I receive valid data for doctor i choose")
    public void receivevalidateDataDoctorIChoose() {
        PosGetDocIdUser.validateDataDoctorIChoose();
    }


    //BATAS/////////////////NEGATIFF


    @Given("I set GET API endpoints")
    public void setGetApiEndpointsNeg() {
        NegGetDocIdUser.setApiEndpointNeg();
    }

    @When("I Send GET HTTP Request")
    public void sendGetHttpRequestNeg() {
        NegGetDocIdUser.sendGetHttpRequestNeg();
    }

    @Then("I receive valid http response code is 200")
    public void receiveValidHttpResponseNeg() {
        NegGetDocIdUser.validateHttpResponseCode200Neg();
    }

    @And("I receive blank data doctor")
    public void receivevalidateDataDoctorIChooseNeg() {
        NegGetDocIdUser.validateDataDoctorIChooseNeg();
    }
}