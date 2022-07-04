package stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageMethods.PutMethods;

public class PutPetDefinitions {
    @Given("Se realiza un PUT a PetStore")
    public void seRealizaUnPUTAPetStore() {
        PutMethods.putMethod();
    }

    @When("Obtiene la respuesta esperada del PUT")
    public void obtieneLaRespuestaEsperadaDelPUT() {
        PutMethods.checkResponsePutMethod();
    }

    @Then("El status code del PUT se muestra correctamente")
    public void elStatusCodeDelPUTSeMuestraCorrectamente() {
        PutMethods.checkStatusCodePutMethod();
    }
}
