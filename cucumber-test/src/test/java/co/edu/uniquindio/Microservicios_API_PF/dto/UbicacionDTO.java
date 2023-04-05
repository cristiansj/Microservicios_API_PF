package co.edu.uniquindio.Microservicios_API_PF.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.beans.ConstructorProperties;
import java.io.Serializable;
@Getter
@RequiredArgsConstructor(onConstructor_={@ConstructorProperties({"id_pedido", "estado", "fecha_envio", "fecha_entrega"})} )
@Builder
public class UbicacionDTO implements Serializable {

    private final double latitud;

    private final double longitud;

}
