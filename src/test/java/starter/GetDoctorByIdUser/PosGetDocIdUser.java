package starter.GetDoctorByIdUser;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class PosGetDocIdUser {
    protected static String url = "https://capstone-project.duckdns.org:8080/";

    @Step("I set GET api endpoints")
    public String setApiEndpoint(){
        return url + "doctor/3";
    }
    @Step("I send GET http request")
    public void sendGetHttpRequest(){
        SerenityRest.given().get(setApiEndpoint());
    }
    @Step("I receive valid http response code 200")
    public void validateHttpResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("I receive valid data for doctor i choose")
    public void validateDataDoctorIChoose(){
        restAssuredThat(response -> response.body("'doctor'.'ID'", equalTo(3)));
        restAssuredThat(response -> response.body("'doctor'.'full_name'", equalTo("audyvaalifia")));
    }


}
