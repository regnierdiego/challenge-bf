package stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageMethods.PostMethods;

public class PostPetDefintions {
    @Given("Se realiza un POST a PetStore")
    public void seRealizaUnPOSTAPetStore() {
        PostMethods.postMethod();
    }

    @When("Obtiene la respuesta esperada del POST")
    public void obtieneLaRespuestaEsperadaDelPOST() {
        PostMethods.checkResponsePostMethod();
    }

    @Then("El status code del POST se muestra correctamente")
    public void elStatusCodeDelPOSTSeMuestraCorrectamente() {
        PostMethods.checkStatusCodePostMethod();
    }
}
