package co.edu.uniquindio.Microservicios_API_PF.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Validar_Formato {
    @Given("Envia formato")
    public void enviaFormato() {
        System.out.println("given");
    }

    @When("Esta listo")
    public void estaListo() {
        System.out.println("when");
    }

    @Then("el formtato")
    public void elFormtato() {
        System.out.println("then");
    }
}
