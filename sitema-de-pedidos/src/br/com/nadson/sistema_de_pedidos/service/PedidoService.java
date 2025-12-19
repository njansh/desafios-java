package br.com.nadson.sistema_de_pedidos.service;

import br.com.nadson.sistema_de_pedidos.enums.StatusPedido;
import br.com.nadson.sistema_de_pedidos.modelo.Cliente;
import br.com.nadson.sistema_de_pedidos.modelo.ItemPedido;
import br.com.nadson.sistema_de_pedidos.modelo.Pedido;
import br.com.nadson.sistema_de_pedidos.modelo.Produto;

import java.util.ArrayList;
import java.util.List;

public class PedidoService {
    private List<Cliente> clientes;
    private List<ItemPedido>itemPedido;
    private List<Pedido>pedido;
    private List<Produto>produtos;
    public PedidoService() {
    this.clientes =new ArrayList<>();
    this.itemPedido=new ArrayList<>();
    this.pedido=new ArrayList<>();
    this.produtos=new ArrayList<>();
    }
    public Produto criarProduto(String nome,double preco){
        if (nome==null || nome.isBlank()){
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        if (preco<=0){
            throw new IllegalArgumentException("Preço deve ser maior que zero");
        }
        Produto produto=new Produto(nome,preco);
        this.produtos.add(produto);
        return produto;
    }
public Cliente criarCliente(String nome,String email){
        if (nome==null || nome.isBlank()){
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        if (email==null || email.isBlank()){
            throw new IllegalArgumentException("Email não pode ser nulo ou vazio");
           }
Cliente cliente=new Cliente(nome,email);
        this.clientes.add(cliente);
        return cliente;

    }


public ItemPedido criarIntem(int quantidade, Produto produto){
        if (quantidade<=0){
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }
        if (produto==null){
            throw new IllegalStateException("Produto não pode ser nulo");
        }
        if(!produtos.contains(produto)){
            throw new IllegalStateException("Produto não existe");
        }
        ItemPedido itemPedido=new ItemPedido(quantidade,produto);
        this.itemPedido.add(itemPedido);
        return itemPedido;

}
public Pedido criarPedido(Cliente cliente){
        if (cliente==null){
            throw new IllegalStateException("Cliente não pode ser nulo");
        }
        if(!clientes.contains(cliente)){
            throw new IllegalStateException("Cliente não existe");
        }
        Pedido pedido=new Pedido(cliente);
        this.pedido.add(pedido);
        return pedido;

}

public void adicionarItem(Pedido pedido, ItemPedido item){
        if (pedido==null){
            throw new IllegalStateException("Pedido não pode ser nulo");
        }
        if (item==null){
            throw new IllegalStateException("Item não pode ser nulo");
        }
        if(!this.pedido.contains(pedido)){
            throw new IllegalStateException("Pedido não existe");
        }
        if(!this.itemPedido.contains(item)){
            throw new IllegalStateException("Item não existe");
        }
        pedido.adicionarItem(item);

}
public void removerItem(Pedido pedido, ItemPedido item){
        if (pedido==null){
            throw new IllegalStateException("Pedido não pode ser nulo");
        }
        if (item==null){
            throw new IllegalStateException("Item não pode ser nulo");
        }
        if(!this.pedido.contains(pedido)){
            throw new IllegalStateException("Pedido não existe");
        }
        if(!this.itemPedido.contains(item)){
            throw new IllegalStateException("Item não existe");
        }
        pedido.removerItem(item);


}

public double calcularValorTotal(Pedido pedido){
        if (pedido==null){
            throw new IllegalStateException("Pedido não pode ser nulo");
        }
        if(!this.pedido.contains(pedido)){
            throw new IllegalStateException("Pedido não existe");
        }
        return pedido.getValorTotal();
}

public void pagar(Pedido pedido){
        if (pedido==null){
            throw new IllegalStateException("Pedido não pode ser nulo");
        }
        if(!this.pedido.contains(pedido)){
            throw new IllegalStateException("Pedido não existe");
        }
        pedido.setStatus(StatusPedido.PAGO);

}
public void entregar(Pedido pedido){
        if (pedido==null){
            throw new IllegalStateException("Pedido não pode ser nulo");
        }
        if(!this.pedido.contains(pedido)){
            throw new IllegalStateException("Pedido não existe");
        }
        pedido.setStatus(StatusPedido.ENTREGUE);

}
public void cancelar(Pedido pedido){
        if (pedido==null){
            throw new IllegalStateException("Pedido não pode ser nulo");
        }
        if(!this.pedido.contains(pedido)) {
            throw new IllegalStateException("Pedido não existe");
        }
        pedido.setStatus(StatusPedido.CANCELADO);

}
}
