package co.edu.uniquindio.Microservicios_API_PF.entidades;

public class Estado {
    private String detalle;
    private Descripcion descripcion;

    public Estado(String detalle, Descripcion descripcion) {
        this.detalle = detalle;
        this.descripcion = descripcion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(Descripcion descripcion) {
        this.descripcion = descripcion;
    }
}
