package br.com.nadson.desafio1.modelo;

public class Professor extends Pessoa {

    public Professor(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public String apresentar() {
        return String.format("Nome: %s, Idade: %d", getNome(), getIdade());
    }


}




