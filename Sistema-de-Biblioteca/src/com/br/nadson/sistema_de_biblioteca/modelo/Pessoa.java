package com.br.nadson.sistema_de_biblioteca.modelo;

public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido");
        }

        if (idade <= 0) {
            throw new IllegalArgumentException("Idade invalida");
        }

        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String apresentar(){
        return "Nome: "+nome+" Idade: "+idade;
    }
}
