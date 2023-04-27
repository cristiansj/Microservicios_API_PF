package co.edu.uniquindio.Microservicios_API_PF.repository;

import java.util.Optional;

public interface PedidoRepo<Pedido> {
    Optional<Pedido> findById_pedido(String id_pedido) ;

    void save (Pedido pedido);
}
