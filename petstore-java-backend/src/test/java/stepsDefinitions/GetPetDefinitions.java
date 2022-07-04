package stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageMethods.GetMethods;

public class GetPetDefinitions {
    @Given("Se realiza un GET a PetStore")
    public void seRealizaUnGETAPetStore() {
        GetMethods.getMethod();
    }

    @When("Obtiene la respuesta esperada del GET")
    public void obtieneLaRespuestaEsperadaDelGET() {
        GetMethods.checkResponseGetMethod();
    }

    @Then("El status code del GET se muestra correctamente")
    public void elStatusCodeDelGETSeMuestraCorrectamente() {
        GetMethods.checkStatusCodeGetMethod();
    }
}
