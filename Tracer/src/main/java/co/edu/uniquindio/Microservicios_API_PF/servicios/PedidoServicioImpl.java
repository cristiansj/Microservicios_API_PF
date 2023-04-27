package co.edu.uniquindio.Microservicios_API_PF.servicios;

import co.edu.uniquindio.Microservicios_API_PF.entidades.Pedido;
import co.edu.uniquindio.Microservicios_API_PF.repository.PedidoRepo;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PedidoServicioImpl implements PedidoServicio{
    private List<Pedido> pedidos;

    @Inject
    public PedidoServicioImpl(PedidoRepo pedidoRepo) {
        //this.pedidoRepo = pedidoRepo;
        this.pedidos = new ArrayList<>();
    }

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
