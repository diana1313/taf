package steps;

import api.context.ScenarioContext;
import api.responses.RandomUserResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.PropertiesReader;
import org.testng.Assert;
import pages.GoogleSearchPage;
import pages.GoogleSearchResultsPage;

import static api.context.ScenarioContext.Context.USER_NAME;
import static io.restassured.RestAssured.given;
import static pages.GoogleSearchPage.BASE_URL;

public class StepsDef {
    @Given("^I execute API precondition to get random user and save name to Context$")
    public void iExecuteAPIPreconditionToGetRandomUserAndSaveNameToContext() {

        RandomUserResponse userResponse = given()
                .baseUri(PropertiesReader.getPropertyValue("random.user.endpoint"))
                .basePath(PropertiesReader.getPropertyValue("random.user.name.path"))
                .get()
                .then()
                .extract()
                .as(RandomUserResponse.class);

        String userName = String.format("%s %s",
                (userResponse.getResults().get(0).getName().getFirst()),
                (userResponse.getResults().get(0).getName().getLast()));

        ScenarioContext.setContext(USER_NAME, userName);
    }

    @When("^I search for saved to Context user's name and surname in Google$")
    public void iSearchForSavedToContextUserSNameAndSurnameInGoogle() {
        String searchedName = ScenarioContext.getContext(USER_NAME).toString();
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        googleSearchPage.open(BASE_URL);
        googleSearchPage.enterQueryToSearchBar(searchedName);
    }

    @Then("^I validate the result with Facebook profile for this person$")
    public void iValidateTheFacebookHasAProfileForThisPerson() {
        String searchedName = ScenarioContext.getContext(USER_NAME).toString();
        GoogleSearchResultsPage googleSearchResultsPage = new GoogleSearchResultsPage();
        boolean result = googleSearchResultsPage.isFacebookResultWithUserNameDisplayed(searchedName);
        Assert.assertTrue(result, String.format("Facebook result with name %s is not displayed", searchedName));
    }
}
