package co.edu.uniquindio.Microservicios_API_PF.entidades;

import jakarta.json.bind.annotation.JsonbProperty;
import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

@Data
public class Pedido implements Serializable {

    @JsonbProperty("id_pedido")
    private String id_pedido;

    @JsonbProperty("estado")
    private String estado;

    @JsonbProperty("fecha_envio")
    //private LocalDateTime fecha_envio;
    private String fecha_envio;

    @JsonbProperty("fecha_entrega")
    //private LocalDateTime fecha_entrega;
    private String fecha_entrega;

    @JsonbProperty("ubicaciones")
    private HashMap<String, Ubicacion> ubicaciones;

    public Pedido(){}


}
