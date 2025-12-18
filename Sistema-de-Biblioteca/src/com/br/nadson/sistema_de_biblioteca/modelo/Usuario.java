package com.br.nadson.sistema_de_biblioteca.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario extends Pessoa{
    private static final int MAX_LIVROS_EMPRESTADOS = 5;
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
    }  if (livros.size()==MAX_LIVROS_EMPRESTADOS){
        throw new IllegalStateException("Numero maximo de emprestimos atingido");
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
public boolean temLivrosEmprestados(){
        return !livros.isEmpty();
}

    public int getQuantidadeLivrosEmprestados() {
        return livros.size();
    }

    @Override
    public String apresentar(){
        return String.format("Nome: %s, Idade: %d, Matricula: %d", getNome(), getIdade(), getMatricula());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return matricula == usuario.matricula;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(matricula);
    }
}
