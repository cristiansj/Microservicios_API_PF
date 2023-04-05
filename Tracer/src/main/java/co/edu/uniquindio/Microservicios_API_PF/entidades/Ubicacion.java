package co.edu.uniquindio.Microservicios_API_PF.entidades;

import jakarta.json.bind.annotation.JsonbProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Ubicacion implements Serializable {

    @JsonbProperty("latitud")
    private double latitud;
    @JsonbProperty("longitud")
    private double longitud;

}
