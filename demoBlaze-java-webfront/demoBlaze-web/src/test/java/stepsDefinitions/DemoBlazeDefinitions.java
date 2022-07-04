package stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageMethods.DemoBlazeMethods;
import pageMethods.GeneralMethods;

public class DemoBlazeDefinitions {
    @Given("Open Form")
    public void OpenForm() {
        DemoBlazeMethods.openForm();
    }

    @When("Register and Login with user created")
    public void registerAndLogin() {
        DemoBlazeMethods.registerAndLogin();
    }

    @Then("Logout and check")
    public void logoutAndCheck() {
        DemoBlazeMethods.logoutAndCheck();
    }

    @Given("User select a product")
    public void selectRandomProduct() throws InterruptedException {
        DemoBlazeMethods.selectProduct();
    }

    @When("Add to cart")
    public void addToCart() {
        DemoBlazeMethods.addToCart();
    }

    @Then("Check added to cart")
    public void addedCartCheck() {
        DemoBlazeMethods.addedCartCheck();
    }
}
