package br.com.nadson.sistema_de_pedidos.modelo;

public class ItemPedido {
    private int quantidade;
    private Produto produto;

    public ItemPedido(int quantidade, Produto produto) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }
if (produto==null){
    throw new IllegalStateException("Produto não pode ser nulo");
}
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public Produto getProduto() {
        return produto;
    }

    public double getValorTotal(){
        return quantidade*produto.getPreco();
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "quantidade=" + quantidade +
                ", produto=" + produto.getNome() +
                '}';
    }
}
