package co.edu.uniquindio.Microservicios_API_PF.dto;

import io.cucumber.java.hu.Ha;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.beans.ConstructorProperties;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

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

    private final HashMap<String, UbicacionDTO> ubicaciones;
}
