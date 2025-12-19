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
        if (status!=StatusPedido.CRIADO){
            throw new IllegalStateException("Pedido não pode ser modificado depois de criado");
        }if(itens.contains(item)){
            throw new IllegalStateException("Item já está no pedido");
        }
        this.itens.add(item);

    }
    public void removerItem(ItemPedido item){
        if (item==null){
            throw new IllegalStateException("Item não pode ser nulo");
        }
        if(status!=StatusPedido.CRIADO){
            throw new IllegalStateException("Pedido não pode ser modificado depois de criado");
        }

        if (itens.contains(item)){
            this.itens.remove(item);
        }else{
            throw new IllegalStateException("Item não está no pedido");
        }
    }

    public double getValorTotal(){
        return itens.stream().mapToDouble(ItemPedido::getValorTotal).sum();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
    return new ArrayList<>(itens);
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        if (status == null) {
            throw new IllegalArgumentException("Status não pode ser nulo");
        }
        if (this.status == StatusPedido.ENTREGUE || this.status == StatusPedido.CANCELADO) {
            throw new IllegalStateException("Não é possível alterar o status de um pedido entregue ou cancelado.");
        }
        if (this.status == StatusPedido.CRIADO && status == StatusPedido.ENTREGUE) {
            throw new IllegalStateException("Não é possível ir de CRIADO para ENTREGUE diretamente.");
        }
        if (this.status == StatusPedido.PAGO && status == StatusPedido.CRIADO) {
            throw new IllegalStateException("Não é possível reverter um pedido pago para CRIADO.");
        }
        this.status = status;
    }
}
