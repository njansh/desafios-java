package com.br.nadson.sistema_de_biblioteca.modelo;

import com.br.nadson.sistema_de_biblioteca.enums.EstadoLivro;

public class Livro {
    private EstadoLivro estadoLivro;
    private String titulo;
    private String autor;
    private int isbn;

    public Livro(String titulo, String autor, int isbn) {
        if(titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Titulo inválido");

        }
        if(autor == null || autor.isBlank()) {
            throw new IllegalArgumentException("Autor inválido");

        }
        if(isbn <= 0) {
            throw new IllegalArgumentException("ISBN inválido");

        }

        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.estadoLivro = EstadoLivro.DISPONIVEL;
    }

    public EstadoLivro getEstadoLivro() {
        return estadoLivro;
    }
    public EstadoLivro emprestar(){
        if (estadoLivro==EstadoLivro.DISPONIVEL){
            return estadoLivro=EstadoLivro.EMPRESTADO;
        } else {
        throw  new IllegalStateException("O livro ja esta emprestado");

        }
    }

    public EstadoLivro devolver(){
        if (estadoLivro==EstadoLivro.EMPRESTADO){
            return estadoLivro=EstadoLivro.DISPONIVEL;
        }else {
            throw new IllegalStateException("O livro não foi emprestado ainda");
        }
    }


}
