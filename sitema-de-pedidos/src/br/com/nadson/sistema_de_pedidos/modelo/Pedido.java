package br.com.nadson.sistema_de_pedidos.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<ItemPedido>itens;
    private StatusPedido status;

    public Pedido(Cliente cliente) {
        if (cliente==null){
            throw new IllegalStateException("Cliente não pode ser nulo");
        }
        this.cliente = cliente;
        this.itens=new ArrayList<>();
        this.status=StatusPedido.CRIADO;
    }
    public void adicionarItem(ItemPedido item){
        if (item==null){
            throw new IllegalStateException("Item não pode ser nulo");
        }
        this.itens.add(item);

    }



    public Cliente getCliente() {
        return cliente;
    }
}
