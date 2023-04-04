package co.edu.uniquindio.Microservicios_API_PF.steps;

import co.edu.uniquindio.Microservicios_API_PF.dto.EnvioDTO;
import co.edu.uniquindio.Microservicios_API_PF.dto.UsuarioDTO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class BuscarPedido {

    private UsuarioDTO usuario;

    private EnvioDTO envio;

    private Response response;

    @Given("Soy un usuario que estoy autenticado en el sistema")
    public void soyUnUsuarioQueEstoyAutenticadoEnElSistema() {
        usuario = UsuarioDTO
                .builder()
                .usuario("pedro")
                .clave("pedro")
                .build();
    }

    @And("existe un pedido con el identificador {string}")
    public void existeUnPedidoConElIdentificador(String id_pedido) {
        envio = EnvioDTO
                .builder()
                .id_pedido(id_pedido)
                .estado("En Reparto")
                //.fecha_envio(LocalDateTime.of(2023, 1, 16, 12, 30, 0))
                //.fecha_entrega(LocalDateTime.of(2023, 5, 12, 9, 30, 0))
                .fecha_envio("2023-03-05T10:30:00")
                .fecha_entrega("2023-04-14T09:00:00")
                .build();

    }

    @When("invoco el servicio de busqueda de envios engresando el id {string}")
    public void invocoElServicioDeBusquedaDeEnviosEngresandoElId(String id_pedido) {

        //Guardo el envio

        given()
                .contentType(ContentType.JSON)
                .body(envio)
                .post("http://localhost:8080/api/pedidos");

        response = given()
                .contentType(ContentType.JSON)
                .get("http://localhost:8080/api/pedidos/" + id_pedido);
    }

    @Then("obtengo un status code {int}")
    public void obtengoUnStatusCode(int status) {
        response.then().statusCode(status);
    }

    @And("la información del envio")
    public void laInformacionDelEnvioConElIdentificador() {
        response.then()
                .body("id_pedido",response->notNullValue())
                .body("estado",response->notNullValue())
                .body("fecha_envio",response->notNullValue())
                .body("fecha_entrega",response->notNullValue());
    }


}
