package com.br.nadson.sistema_de_biblioteca.modelo;

import com.br.nadson.sistema_de_biblioteca.enums.EstadoLivro;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends Pessoa{
    private static int GERADOR_MATRICULA = 1;
    private final int matricula;
    private List<Livro> livros;


    public Usuario(String nome, int idade) {
        super(nome, idade);
        this.matricula = GERADOR_MATRICULA++;
        livros=new ArrayList<>();

    }

    public int getMatricula() {
        return matricula;

    }
public void emprestarLivro(Livro livro){
        if (livro==null){
            throw new IllegalArgumentException("Livro invalido");
        }
        if(livros.contains(livro)){
            throw new IllegalStateException("Livro ja esta emprestado");
    }
        livro.emprestar();
        livros.add(livro);
}
public void devolverLivro(Livro livro){
        if(livro==null){
            throw new IllegalArgumentException("Livro invalido");

        }if(!livros.contains(livro)){
            throw new IllegalStateException("Livro nao esta emprestado");
    }

        livro.devolver();
        livros.remove(livro);
}

    @Override
    public String apresentar(){
        return String.format("Nome: %s, Idade: %d, Matricula: %d", getNome(), getIdade(), getMatricula());
    }
}
