package co.edu.uniquindio.Microservicios_API_PF;

import co.edu.uniquindio.Microservicios_API_PF.model.ReferenceFormatException;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.text.NumberFormat;

/**
 *
 */
@Path("/formato")
@Singleton
public class HelloController {

    @GET
    @Path("id_pedido/{id_pedido}")
    public Response validarFormato(@PathParam("id_pedido") String id_pedido) throws ReferenceFormatException {
        String mensaje = "formato valido";
        try {
            int inicio_id_pedido = Integer.parseInt(id_pedido.substring(id_pedido.length()/2));
            String final_id_pedido = id_pedido.substring(id_pedido.length()/2);
            if (final_id_pedido.matches("[0-9]")) {
                mensaje = "formato de referncia no valido";
                return Response.status(500).entity(mensaje).build();
            }else
                return Response.status(200).entity(mensaje).build();
        }catch (NumberFormatException e) {
            return Response.status(500).entity(mensaje).build();
        }
    }
}
