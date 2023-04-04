package co.edu.uniquindio.Microservicios_API_PF;

import co.edu.uniquindio.Microservicios_API_PF.entidades.Credential;
import co.edu.uniquindio.Microservicios_API_PF.entidades.Pedido;
import co.edu.uniquindio.Microservicios_API_PF.repository.PedidoRepo;
import co.edu.uniquindio.Microservicios_API_PF.servicios.PedidoServicio;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.net.URI;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

@Path("/pedidos")
@Produces(MediaType.APPLICATION_JSON+"; charset=UTF-8")
@Singleton
public class PedidoController {

    private static final Logger LOGGER = Logger.getLogger(PedidoController.class.getName());
    @Inject
    private PedidoServicio pedidoServicio;

    @POST
    public void create(@RequestBody Pedido pedido) {
        pedidoServicio.save(pedido);
    }

    @GET
    @Path("{id_pedido}")
    public Response check(@PathParam("id_pedido") String id_pedido,  @HeaderParam("Authorization") String authToken){

        Objects.requireNonNull(id_pedido,"El id del pedido no puede ser nulo");

        if (authToken == null)
        {
            LOGGER.warning("Usuario no autorizado para realizar la operación.");
            throw new WebApplicationException("Debe iniciar sesión para realizar la acción.", Response.status(Response.Status.UNAUTHORIZED)
                    .header("WWW-Authenticate", "Basic realm=\"Restricted Area\"")
                    .entity("Usuario no autorizado para realizar la operación.")
                    .build());
        }
        //Como verifico que el pedido corresponda a el usuario?
        /*if(!authorization.substring(7).equals(token)){
            LOGGER.warning("Usuario no posee permisos para realizar la operación.");
            throw new WebApplicationException("Usuario no posee permisos para realizar la operación.", Response.Status.FORBIDDEN);
        }*/
        return Response.ok(getAndVerify(id_pedido)).build();
    }

    private Pedido getAndVerify(String id_pedido){
        Optional<Pedido> pedido = pedidoServicio.findById_pedido(id_pedido);
        LOGGER.info("Operacion buscando");
        LOGGER.warning("Token no encontrado.");
        return pedido.orElseThrow(()->new WebApplicationException("Pedido no encontrado.", Response.Status.NOT_FOUND));
    }

}
