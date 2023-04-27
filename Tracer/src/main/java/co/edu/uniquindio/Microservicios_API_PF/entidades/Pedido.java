package co.edu.uniquindio.Microservicios_API_PF.entidades;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private String id_pedido;
    private List<Estado> estados;
    private String fecha_envio;
    private String fecha_entrega;

    public Pedido (String id_pedido, Estado estado, String fecha_envio, String fecha_entrega){
        this.id_pedido = id_pedido;
        this.estados = new ArrayList<>();
        this.estados.add(estado);
        this.fecha_envio = fecha_envio;
        this.fecha_entrega = fecha_entrega;
    }

    public Pedido (){

    }

    public String getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(String id_pedido) {
        this.id_pedido = id_pedido;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public String getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(String fecha_envio) {
        this.fecha_envio = fecha_envio;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }
}
