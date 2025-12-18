package com.br.nadson.sistema_de_biblioteca.servico;

import com.br.nadson.sistema_de_biblioteca.enums.EstadoLivro;
import com.br.nadson.sistema_de_biblioteca.modelo.Livro;
import com.br.nadson.sistema_de_biblioteca.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Usuario> usuarios;
    private List<Livro> livros;

    public Biblioteca() {
        this.usuarios = new ArrayList<>();
        this.livros = new ArrayList<>();
    }

    public Usuario adicionarUsuario(String nome, int idade) {
        if (idade <= 0) {
            throw new IllegalArgumentException("Idade invalida");
        }if(nome==null){
            throw new IllegalArgumentException("Nome invalido");

        }
        Usuario usuario = new Usuario(nome, idade);
        if (usuarios.contains(usuario)) {
            throw new IllegalStateException("Usuario ja cadastrado");
        }
        usuarios.add(usuario);
        return usuario;
    }

    public void removerUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario invalido");
        }
        if (!usuarios.contains(usuario)) {
            throw new IllegalArgumentException("Usuario nao cadastrado");
        }
        if (usuario.temLivrosEmprestados()) {
            throw new IllegalStateException("Usuario possui livros emprestados e nao pode ser removido");
        }
        usuarios.remove(usuario);
    }

    public Livro adicionarLivro(String titulo, String autor, String isbn){

        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Titulo invalido");
        }
        if (autor == null || autor.isBlank()) {
            throw new IllegalArgumentException("Autor invalido");
        }
        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("ISBN invalido");
        }
        Livro livro = new Livro(titulo, autor, isbn);

        if (livros.contains(livro)) {
            throw new IllegalStateException("Livro ja cadastrado");
        }
        livros.add(livro);
        return livro;
    }

    public void removerLivro(Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException("Livro invalido");
        }
        if (!livros.contains(livro)) {
            throw new IllegalStateException("Livro nao cadastrado");
        }
        if (livro.getEstadoLivro().equals(EstadoLivro.EMPRESTADO)) {
            throw new IllegalStateException("Livro esta emprestado e nao pode ser removido");
        }
        livros.remove(livro);
    }

    public void emprestarLivros(Usuario usuario, Livro livro) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario invalido");
        }
        if (livro == null) {
            throw new IllegalArgumentException("Livro invalido");
        }
        usuario.emprestarLivro(livro);
    }

    public void devolverLivros(Usuario usuario, Livro livro) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario invalido");
        }
        if (livro == null) {
            throw new IllegalArgumentException("Livro invalido");
        }
        usuario.devolverLivro(livro);
    }
}