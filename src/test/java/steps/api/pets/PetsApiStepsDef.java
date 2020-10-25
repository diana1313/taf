package steps.api.pets;

import api.dto.PetBody;
import api.dto.PetResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import specifiactions.InitSpecification;

import static io.restassured.RestAssured.given;


public class PetsApiStepsDef {
    private int id;
    private String name;
    private String newName;

    public PetsApiStepsDef(int id, String name, String newName) {
        this.id = id;
        this.name = name;
        this.newName = newName;
    }

    @When("^I create pet with name parameter \"?([^\"]*)\"?$")
    public void iCreatePatWithNameParameter(String parameter) {
        PetResponse postPetResponse = given()
                .spec(InitSpecification.basePetSpecification)
                .body(PetBody.builder().name(parameter))
                .post()
                .then()
                .statusCode(201)
                .extract()
                .as(PetResponse.class);
        id = postPetResponse.getId();
        this.name = parameter;
    }

    @When("^I update current pet with new name parameter \"?([^\"]*)\"?$")
    public void iUpdateCurrentPetWithNewNameParameter(String parameter) {
        given()
                .spec(InitSpecification.basePetSpecification)
                .body(PetBody.builder().id(id).name(parameter))
                .post()
                .then()
                .statusCode(200);
        this.newName = parameter;
    }

    @When("^I delete current pet$")
    public void iDeleteCurrentPet(String parameter) {
        given()
                .spec(InitSpecification.basePetSpecification)
                .body(PetBody.builder().id(id))
                .delete()
                .then()
                .statusCode(200);
    }

    @Then("^I check current pet doesn't exist$")
    public void iCheckCurrentPetDoesNotExist() {
        given()
                .spec(InitSpecification.basePetSpecification)
                .basePath(String.format("/%s", id))
                .get()
                .then()
                .assertThat()
                .statusCode(404);
    }

    @Then("^I check created pet exists and has \"?(expected|updated)\"? name$")
    public void iSearchForSavedToContextUserSNameAndSurnameInGoogle(String state) {
        PetResponse petResponse = given()
                .spec(InitSpecification.basePetSpecification)
                .basePath(String.format("/%s", id))
                .get()
                .then()
                .extract()
                .as(PetResponse.class);
        String expectedName;
        String actualName = petResponse.getName();
        if ("updated".equalsIgnoreCase(state)) {
            expectedName = newName;
        } else {
            expectedName = name;
        }
        Assert.assertEquals(expectedName, actualName,
                String.format("Actual name '%s' doesn't match expected '%s'", actualName, name));
    }

}
