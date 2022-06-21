package com.localhost.cucumber.steps;

import com.localhost.swaggerinfo.ProductSteps;
import com.localhost.utils.TestUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.Matchers.equalTo;

public class ProductCurdSteps {
    static String name = "kiya" + TestUtils.getRandomValue();
    static String type = "string";
    static int price = 0;
    static int shipping = 0;
    static String upc = "String";
    static String description = "string";
    static String manufacturer = "string";
    static String model = "String ";
    static String url = "String";
    static String image = "string";
    static int productId;
   ValidatableResponse response;

    @Steps
   ProductSteps productSteps;

    @When("^I sends the Post Request for create the Product Data$")
    public void iSendsThePostRequestForCreateTheProductData() {
    }


    @Then("^I verify the status code (\\d+)$")
    public void iVerifyTheStatusCode(int statusCode) {
        response.log().all().
                statusCode(statusCode);
    }

    @And("^I get the id of new created product data$")
    public void iGetTheIdOfNewCreatedProductData() {
        productId = response.extract().path("id");
    }

    @When("^I sends a GET request for fatching product data by given ID$")
    public void iSendsAGETRequestForFatchingProductDataByGivenID() {
        response = productSteps.getProductListById(productId);
       response.body("name", equalTo(name));

    }

    @When("^I send the Put Request for updating the Product data$")
    public void iSendThePutRequestForUpdatingTheProductData() {
    }



    @Then("^I verify the status code for update (\\d+)$")
    public void iVerifyTheStatusCodeForUpdate(int statusCode) {
        response.log().all()
                .statusCode(statusCode);
    }

    @And("^I verify the name is \"([^\"]*)\" for updating the record$")
    public void iVerifyTheNameIsForUpdatingTheRecord(String name) {
        response.body("name",equalTo(name));
    }

    @When("^I sends the Delete Request for deleting the product  given ID$")
    public void iSendsTheDeleteRequestForDeletingTheProductGivenID() {
        response = productSteps.deleteProductById(productId);
    }

    @Then("^I verify the status code for delete (\\d+)$")
    public void iVerifyTheStatusCodeForDelete(int statusCode) {
        response.log().all()
                .statusCode(statusCode);
    }

    @And("^I get the data for deleted record ID$")
    public void iGetTheDataForDeletedRecordID() {
        response = productSteps.getProductListById(productId);
    }

    @And("^I verify the status code for delete verify (\\d+)$")
    public void iVerifyTheStatusCodeForDeleteVerify(int statusCode) {
        response.log().all()
                .statusCode(statusCode);
    }

    @And("^I enter name,type,price,shipping,upc,description,manufacturer,model,url,image$")
    public void iEnterNameTypePriceShippingUpcDescriptionManufacturerModelUrlImage() {
        response = productSteps.createProduct(name, type, price, shipping, upc,
                description, manufacturer, model, url, image);
    }

    @Then("^I verify the name$")
    public void iVerifyTheName() {
        {
            response.body("name", equalTo(name));
        }
    }

    @And("^I update the name,type ,price ,shipping$")
    public void iUpdateTheNameTypePriceShipping() {
        response = productSteps.updateProduct(productId, name, type, price, shipping, upc,
                description, manufacturer, model, url, image);
    } }