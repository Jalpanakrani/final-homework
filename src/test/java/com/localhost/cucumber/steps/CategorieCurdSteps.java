package com.localhost.cucumber.steps;

import com.localhost.swaggerinfo.CategoriesSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.Matchers.equalTo;
public class CategorieCurdSteps {

    static String categoriesId;
    static ValidatableResponse response;

    @Steps
    CategoriesSteps categoriesSteps;

    @When("^I sends the Post Request for create the Categories Data$")
    public void iSendsThePostRequestForCreateTheCategoriesData() {

    }

    @And("^I insert the name \"([^\"]*)\",id \"([^\"]*)\"$")
    public void iInsertTheNameId(String name, String id) {
        response = categoriesSteps.creatCategory(name,id);
    }

    @Then("^I verify the status code (\\d+) for categories data$")
    public void iVerifyTheStatusCodeForCategoriesData(int statusCode) {
        response.log().all().
                statusCode(201);
    }

    @And("^I get the id of new created Categories data$")
    public void iGetTheIdOfNewCreatedCategoriesData() {
        categoriesId= response.extract().path("id");
    }

    @When("^I sends a GET request for fatching Categories data by given ID$")
    public void iSendsAGETRequestForFatchingCategoriesDataByGivenID() {
      //  response = categoriesSteps.(categoriesId);
    }

    @Then("^I verify the name is for created record \"([^\"]*)\"$")
    public void iVerifyTheNameIsForCreatedRecord(String name) {
        response.body("name",equalTo(name));
    }

    @When("^I send the Put Request for updating the Categories data$")
    public void iSendThePutRequestForUpdatingTheCategoriesData() {
    }

    @And("^I update the name \"([^\"]*)\"$")
    public void iUpdateTheName(String name) {
        response = categoriesSteps.updateCategory(categoriesId,name);
    }

    @Then("^I verify the status code (\\d+) for update categories data$")
    public void iVerifyTheStatusCodeForUpdateCategoriesData(int statuCode) {
        response.log().all()
                .statusCode(statuCode);
    }

    @And("^I verify the name is \"([^\"]*)\" for updating the categories data$")
    public void iVerifyTheNameIsForUpdatingTheCategoriesData(String name) {
        response = categoriesSteps.getSingleCategory(categoriesId);
        response.body("name",equalTo(name));
    }

    @When("^I sends the Delete Request for deleting the Categories  given ID$")
    public void iSendsTheDeleteRequestForDeletingTheCategoriesGivenID() {
        response = categoriesSteps.deletSingleCategory(categoriesId);
    }

    @Then("^I verify the status code (\\d+) for delete categories data$")
    public void iVerifyTheStatusCodeForDeleteCategoriesData(int statusCode) {
        response.log().all()
                .statusCode(200);
    }

    @And("^I get the data for deleted record ID for categories data$")
    public void iGetTheDataForDeletedRecordIDForCategoriesData() {
        response = categoriesSteps.getSingleCategory(categoriesId);
    }

    @And("^I verify the status code (\\d+) for verifing the delete record$")
    public void iVerifyTheStatusCodeForVerifingTheDeleteRecord(int statusCode) {
        response.log().all()
                .statusCode(404);
    }

}
