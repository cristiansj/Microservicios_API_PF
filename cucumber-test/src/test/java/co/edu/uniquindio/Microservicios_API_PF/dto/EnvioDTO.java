package co.edu.uniquindio.Microservicios_API_PF.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.beans.ConstructorProperties;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor(onConstructor_={@ConstructorProperties({"id_pedido", "estado", "fecha_envio", "fecha_entrega"})} )
@Builder
public class EnvioDTO implements Serializable {

    private final String id_pedido;

    private final String estado;

 //   private final LocalDateTime fecha_envio;
    private final String fecha_envio;

   // private final LocalDateTime fecha_entrega;

    private final String fecha_entrega;
}
