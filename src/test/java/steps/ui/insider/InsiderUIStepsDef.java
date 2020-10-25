package steps.ui.insider;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InsiderUIStepsDef {
    private String jobId;

    public InsiderUIStepsDef(String jobId) {
        this.jobId = jobId;
    }

    @Given("^I open Insider Home Page$")
    public void iOpenInsiderHomePage() {

    }

    @Then("I check Insider Home page is opened")
    public void iCheckInsiderHomePageIsOpened() {
    }

    @When("I select {string} button in navigation bar on Insider Home page")
    public void iSelectButtonInNavigationBarOnInsiderHomePage(String arg0) {
    }

    @Then("I check following blocks are displayed on Insider Career page")
    public void iCheckFollowingBlocksAreDisplayedOnInsiderCareerPage() {
    }

    @When("I scroll to Career Opportunities by selecting {string} block on Insider Career page")
    public void iScrollToCareerOpportunitiesBySelectingBlockOnInsiderCareerPage(String arg0) {
    }

    @Then("I check Job List items are displayed")
    public void iCheckJobListItemsAreDisplayed() {
    }

    @When("I filter jobs {string} - {string} in Career Opportunities on Insider Career page")
    public void iFilterJobsInCareerOpportunitiesOnInsiderCareerPage(String arg0, String arg1) {
    }

    @Then("I check all the Job List items {string} contains {string} in Career Opportunities on Insider Career page")
    public void iCheckAllTheJobListItemsContainsInCareerOpportunitiesOnInsiderCareerPage(String arg0, String arg1) {
    }

    @When("I click on {string} Job List item in Career Opportunities on Insider Career page")
    public void iClickOnJobListItemInCareerOpportunitiesOnInsiderCareerPage(String arg0) {
    }

    @Then("I check that correct Job Position page is opened and contains required data")
    public void iCheckThatCorrectJobPositionPageIsOpenedAndContainsRequiredData() {
    }

    @When("I click on {string} button on Job Position page")
    public void iClickOnApplyForThisJobButtonOnJobPositionPage() {
    }

    @Then("I check Application Form page is opened")
    public void iCheckApplicationFormPageIsOpened() {
    }
}
