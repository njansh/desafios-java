package br.com.nadson.sistema_de_pedidos.modelo;

public class Produto {
    private String nome;
    private double preco;

    // Construtor
    public Produto(String nome, double preco) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que zero");
        }
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

}
