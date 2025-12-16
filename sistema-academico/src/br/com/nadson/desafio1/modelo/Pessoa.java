package br.com.nadson.desafio1.modelo;

public abstract class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        if (idade <= 0) {
            throw new IllegalArgumentException("Idade inválida");
        }
        this.nome = nome;
        this.idade = idade;
    }


    public String getNome() {
        return nome;
    }
    public int getIdade(){
        return idade;
    }

    public String apresentar(){
        return String.format("Nome: %s, Idade: %d", nome, idade);
    }

}
