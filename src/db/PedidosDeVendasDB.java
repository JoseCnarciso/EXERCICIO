package db;

import Models.PedidoVenda;

import java.util.ArrayList;
import java.util.List;

public class PedidosDeVendasDB {
    // cria se a lista de a lista de pedidos.
    private List<PedidoVenda> pedidosDeVendas = new ArrayList<>();

    public List<PedidoVenda> getPedidosDeVendas() {
        return pedidosDeVendas;
    }

    // cria se um método para adicionar novos pedidos de venda na lista criada á cima
    public void addNovoPedido( PedidoVenda novoPedido ){
        // toda vez que inicio um novo pedido de vendas o id aumenta automaticamente pelo método feito abaixo
        int id = pedidosDeVendas.size() +1;
        novoPedido.setId(id);
        pedidosDeVendas.add(novoPedido);
    }

    public PedidoVenda pedidoPorId(int id) {
        for(PedidoVenda pedido : pedidosDeVendas) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }
}
