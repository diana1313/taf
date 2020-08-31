package steps;

import api.dto.Name;
import api.dto.RandomUserResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.PropertiesReader;
import org.testng.Assert;
import pages.GoogleSearchPage;
import pages.GoogleSearchResultsPage;

import static io.restassured.RestAssured.given;
import static pages.GoogleSearchPage.BASE_URL;

public class StepsDef {
    private Name name;

    public StepsDef(Name name) {
        this.name = name;
    }

    @Given("^I execute API precondition to get random user and save name to Context$")
    public void iExecuteAPIPreconditionToGetRandomUserAndSaveNameToContext() {

        RandomUserResponse userResponse = given()
                .baseUri(PropertiesReader.getPropertyValue("random.user.endpoint"))
                .basePath(PropertiesReader.getPropertyValue("random.user.name.path"))
                .get()
                .then()
                .extract()
                .as(RandomUserResponse.class);
        name.setFirst(userResponse.getResults().get(0).getName().getFirst());
        name.setLast(userResponse.getResults().get(0).getName().getLast());
    }

    @When("^I search for saved to Context user's name and surname in Google$")
    public void iSearchForSavedToContextUserSNameAndSurnameInGoogle() {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        googleSearchPage.open(BASE_URL);
        googleSearchPage.enterQueryToSearchBar(String.format("%s %s", name.getFirst(), name.getLast()));
    }

    @Then("^I validate the result with Facebook profile for this person$")
    public void iValidateTheFacebookHasAProfileForThisPerson() {
        GoogleSearchResultsPage googleSearchResultsPage = new GoogleSearchResultsPage();
        boolean result = googleSearchResultsPage.isFacebookResultWithUserNameDisplayed(
                String.format("%s %s", name.getFirst(), name.getLast()));
        Assert.assertTrue(result, String.format("Facebook result with name %s is not displayed",
                String.format("%s %s", name.getFirst(), name.getLast())));
    }
}
