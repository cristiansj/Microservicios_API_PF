package co.edu.uniquindio.Microservicios_API_PF;

import co.edu.uniquindio.Microservicios_API_PF.entidades.Descripcion;
import co.edu.uniquindio.Microservicios_API_PF.entidades.Estado;
import co.edu.uniquindio.Microservicios_API_PF.entidades.Pedido;
import co.edu.uniquindio.Microservicios_API_PF.servicios.PedidoServicio;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

/**
 *
 */
@Path("/pedidos")
@Produces(MediaType.APPLICATION_JSON+"; charset=UTF-8")
@Singleton
public class AsignarEstadoController {
    private static final Logger LOGGER = Logger.getLogger(AsignarEstadoController.class.getName());
    @Inject
    private PedidoServicio pedidoServicio;

    @PATCH
    @Path("{id_pedido}")
    public Response agregarEstado(@QueryParam("estado_envio") String estado_envio, @PathParam("id_pedido") String id_pedido, @HeaderParam("Authorization") String authToken) {

        Objects.requireNonNull(id_pedido,"El id del pedido no puede ser nulo");

        if (authToken == null)
        {
            LOGGER.warning("Usuario no autorizado para realizar la operación.");
            throw new WebApplicationException("Debe iniciar sesión para realizar la acción.", Response.status(Response.Status.UNAUTHORIZED)
                    .header("WWW-Authenticate", "Basic realm=\"Restricted Area\"")
                    .entity("Usuario no autorizado para realizar la operación.")
                    .build());
        }
        try {
            Pedido pedido = getRoute(id_pedido);
            pedido.getEstados().add(new Estado(estado_envio, Descripcion.EN_RUTA));
        }catch (Exception e) {
            throw new WebApplicationException("Error durante el proceso.", Response.status(Response.Status.EXPECTATION_FAILED)
                    .entity("Ha surgido un error durante el proceso de agregar estado.")
                    .build());
        }
        return Response.status(200).build();
    }

    @POST
    public void create(@RequestBody Pedido pedido) {
        pedidoServicio.save(pedido);
    }

    private Pedido getAndVerify(String id_pedido){
        Optional<Pedido> pedido = pedidoServicio.findById_pedido(id_pedido);
        LOGGER.info("Operacion buscando");
        LOGGER.warning("Pedido no encontrado.");
        return pedido.orElseThrow(()->new WebApplicationException("Pedido no encontrado.", Response.Status.NOT_FOUND));
    }

    private Pedido getRoute (String id_pedido) {
        Optional<Pedido> pedido = pedidoServicio.findById_pedido(id_pedido);
        return pedido.orElseThrow(()->new WebApplicationException("Pedido no encontrado.", Response.Status.NOT_FOUND));
    }
}
