package com.br.nadson.sistema_de_biblioteca.modelo;

public class Usuario extends Pessoa{
    private static int GERADOR_MATRICULA = 1;
    private final int matricula;


    public Usuario(String nome, int idade) {
        super(nome, idade);
        this.matricula = GERADOR_MATRICULA++;

    }

    public int getMatricula() {
        return matricula;
;
    }

    @Override
    public String apresentar(){
        return String.format("Nome: %s, Idade: %d, Matricula: %d", getNome(), getIdade(), getMatricula());
    }
}
