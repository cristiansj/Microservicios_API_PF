package co.edu.uniquindio.Microservicios_API_PF.servicios;

import co.edu.uniquindio.Microservicios_API_PF.entidades.Pedido;
import co.edu.uniquindio.Microservicios_API_PF.repository.PedidoRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@ApplicationScoped
public class PedidoServicioImpl implements PedidoServicio {
    //private final PedidoRepo pedidoRepo;

    private List<Pedido> pedidos;

    @Inject
    public PedidoServicioImpl(PedidoRepo pedidoRepo) {
        //this.pedidoRepo = pedidoRepo;
        this.pedidos = new ArrayList<>();
    }


    /*@Override
    public Optional<Pedido> findById_pedido(String id_pedido){

        Optional<Pedido> pedido = null;
        System.out.println(id_pedido+"este es el codigo del p");
        try {
            pedido = pedidoRepo.findById_pedido(id_pedido);
        } catch (Exception e)
        {
            new Exception(e.getMessage());
        }

        if (pedido == null)
        {
            new Exception("El id no es válido");
        }

        return pedido;
    }*/

    @Override
    public Optional<Pedido> findById_pedido(String id_pedido){
        Pedido p = null;
        for (Pedido pedido: pedidos) {

            if(pedido.getId_pedido().equals(id_pedido))
            {
                p = pedido;
            }
        }

        return Optional.ofNullable(p);
    }
    @Override
    public void save(Pedido pedido) {
        //pedidoRepo.save(pedido);
        pedidos.add(pedido);
    }
}
