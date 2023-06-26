package starter.GetDoctorByIdUser;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class NegGetDocIdUser {
    protected static String url = "https://capstone-project.duckdns.org:8080/";

    @Step("I set GET API endpoints")
    public String setApiEndpointNeg(){
        return url + "doctor/4587485834";
    }
    @Step("I Send GET HTTP Request")
    public void sendGetHttpRequestNeg(){
        SerenityRest.given().get(setApiEndpointNeg());
    }
    @Step("I receive valid http response code is 200")
    public void validateHttpResponseCode200Neg(){
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("I receive blank data doctor")
    public void validateDataDoctorIChooseNeg(){
        restAssuredThat(response -> response.body("'doctor'.'ID'", equalTo(0)));
        restAssuredThat(response -> response.body("'doctor'.'full_name'", equalTo("")));
    }


}
