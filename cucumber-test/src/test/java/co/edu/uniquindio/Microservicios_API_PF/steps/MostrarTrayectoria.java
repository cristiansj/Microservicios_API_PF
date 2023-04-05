package co.edu.uniquindio.Microservicios_API_PF.steps;

import co.edu.uniquindio.Microservicios_API_PF.dto.EnvioDTO;
import co.edu.uniquindio.Microservicios_API_PF.dto.UbicacionDTO;
import co.edu.uniquindio.Microservicios_API_PF.dto.UsuarioDTO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class MostrarTrayectoria {

    private UsuarioDTO usuario;

    private EnvioDTO envio;

    private UbicacionDTO ubicacion;

    private Response response;

    @Given("Soy un usuario que estoy con sesion activa en el sistema")
    public void soyUnUsuarioQueEstoyConSesionActivaEnElSistema() {
        usuario = UsuarioDTO
                .builder()
                .usuario("pedro")
                .clave("pedro")
                .build();
    }

    @And("hay un pedido con el identificador {string}")
    public void hayUnPedidoConElIdentificador(String id_pedido) {
        HashMap<String, UbicacionDTO> ubicaciones = new HashMap<>();

        ubicacion = new UbicacionDTO(-23.098738, 12.462098);
        ubicaciones.put("1", ubicacion);

        ubicacion = new UbicacionDTO(-70.109284, -15.633680);
        ubicaciones.put("2", ubicacion);

        envio = EnvioDTO
                .builder()
                .id_pedido(id_pedido)
                .estado("En Reparto")
                //.fecha_envio(LocalDateTime.of(2023, 1, 16, 12, 30, 0))
                //.fecha_entrega(LocalDateTime.of(2023, 5, 12, 9, 30, 0))
                .fecha_envio("2023-03-05T10:30:00")
                .fecha_entrega("2023-04-14T09:00:00")
                .ubicaciones(ubicaciones)
                .build();
    }

    @When("invoco el servicio que permite ver la trayectoria de un pedido ingresando el id {string}")
    public void invocoElServicioQuePermiteVerLaTrayectoriaDeUnPedidoIngresandoElId(String id_pedido) {
        //Guardo el envio
        given()
                .contentType(ContentType.JSON)
                .body(envio)
                .post("http://localhost:8080/api/pedidos");

        response = given()
                .contentType(ContentType.JSON)
                .get("http://localhost:8080/api/pedidos/" + id_pedido + "/tracer");

    }

    @Then("obtengo un codigo de estado {int}")
    public void obtengoUnCodigoDeEstado(int status) {
        response.then().statusCode(status);
    }

    @And("un arreglo con las ubicaciones del pedido")
    public void unArregloConLasUbicacionesDelPedido() {
        response.then()
                .body("id_pedido",response->notNullValue())
                .body("ubicaciones",response->notNullValue());
    }
}
