package starter.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.articleAdmin.NegApproveArtc;
import starter.articleAdmin.PosApproveArtc;
import starter.articleAdmin.NegRejectArtc;
import starter.articleAdmin.PosRejectArtc;

public class ArticleAdminSteps {
    @Steps
    PosApproveArtc PosApproveArtc;
    @Steps
    NegApproveArtc NegApproveArtc;

    @Steps
    PosRejectArtc PosRejectArtc;
    @Steps
    NegRejectArtc NegRejectArtc;


    //BATAS
    @Given("I set PUT API endpoint")
    public void setPostApiEndpoints() {
        PosApproveArtc.setPostApiEndpoint();
    }

    @When("I send PUT Http Request")
    public void sendPostHttpRequest() {
        PosApproveArtc.sendPostHttpRequest();
    }

    @Then("I receive valid Http response code is 200")
    public void receiveValidHttp200() {
        PosApproveArtc.validateHttpResponseCode200();
    }

    @And("I receive valid data for approved article")
    public void receiveValidDataForApprovedArticle() {
        PosApproveArtc.validateDataApprovedArticle();
    }
//BATASSSS
    @Given("I set PUT API Endpoint")
    public void setPostApiEndpointsNeg() {
        NegApproveArtc.setPostApiEndpointNeg();
    }

    @When("I send PUT Http request")
    public void sendPostHttpRequestNeg() {
        NegApproveArtc.sendPostHttpRequestNeg();
    }

    @Then("I receive valid Http response code is 500")
    public void receiveValidHttp500Neg() {
        NegApproveArtc.validateHttpResponseCode500Neg();
    }

    @And("I receive error message and prevented to approve an article")
    public void receiveErrMessageApproveArticle() {
        NegApproveArtc.validateErrMessageApproveArticle();
    }

//BATAS REJECTTTTT SAYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY

    @Given("I Set PUT API endpoint")
    public void setPostAPIEndpoints() {
        PosRejectArtc.setPostAPIEndpoints();
    }

    @When("I Send PUT Http Request")
    public void sendPostHTTPRequest() {
        PosRejectArtc.sendPostHTTPRequest();
    }

    @Then("I Receive valid Http response code is 200")
    public void receiveValidHTTP200() {
        PosRejectArtc.receiveValidHTTP200();
    }

    @And("I receive valid data for rejected article")
    public void receiveValidDataForRejectedArticle() {
        PosRejectArtc.receiveValidDataForRejectedArticle();
    }

    //BATAS
    @Given("I Set PUT API Endpoint")
    public void setPostAPIEndpointsNeg() {
        NegRejectArtc.setPostAPIEndpointsNeg();
    }

    @When("I Send PUT Http request")
    public void sendPostHTTPRequestNeg() {
        NegRejectArtc.sendPostHTTPRequestNeg();
    }

    @Then("I Receive valid Http response code is 500")
    public void receiveValidHTTP500Neg() {
        NegRejectArtc.receiveValidHTTP500Neg();
    }

    @And("I receive error message and prevented to reject an article")
    public void receiveErrorAndPreventedToReject() {
        NegRejectArtc.receiveErrorAndPreventedToReject();
    }
}