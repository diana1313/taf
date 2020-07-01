package steps;

import api.context.ScenarioContext;
import api.responses.RandomUserResponse;
import api.specs.RandomUserInitSpec;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static api.context.ScenarioContext.Context.USER_NAME;
import static io.restassured.RestAssured.given;

public class StepsDef {
    @Given("^I execute API precondition to get random user and save name to Context$")
    public void iExecuteAPIPreconditionToGetRandomUserAndSaveNameToContext() {

        RandomUserResponse userResponse = given()
                .spec(RandomUserInitSpec.getRandomUser)
                .get()
                .then()
                .extract()
                .as(RandomUserResponse.class);

        String userName = String.format("%s %s",
                userResponse.getName().getFirst(),
                userResponse.getName().getLast());

        ScenarioContext.setContext(USER_NAME, userName);
    }

    @When("^I search for saved to Context user's name and surname in Google$")
    public void iSearchForSavedToContextUserSNameAndSurnameInGoogle() {
        String searchedName = ScenarioContext.getContext(USER_NAME).toString();

    }

    @Then("^I validate the Facebook has a profile for this person$")
    public void iValidateTheFacebookHasAProfileForThisPerson() {

    }
}
