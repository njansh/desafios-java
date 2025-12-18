package com.br.nadson.sistema_de_biblioteca.servico;

import com.br.nadson.sistema_de_biblioteca.modelo.Livro;
import com.br.nadson.sistema_de_biblioteca.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Usuario>usuarios;
    private List<Livro>livros;

    public Biblioteca() {
        this.usuarios =new ArrayList<>();
        this.livros =new ArrayList<>();
    }

    public void adicionarUsuario(Usuario usuario){
        if(usuario==null){
            throw new IllegalArgumentException("Usuario invalido");
        }
        if(usuarios.contains(usuario)){
            throw new IllegalArgumentException("Usuario ja cadastrado");
        }
        usuarios.add(usuario);
    }
    public void removerUsuario(Usuario usuario){
        if(usuario==null){
            throw new IllegalArgumentException("Usuario invalido");
        }
        if(!usuarios.contains(usuario)){
            throw new IllegalArgumentException("Usuario nao cadastrado");
        }
        usuarios.remove(usuario);
    }
    public void adicionarLivro(Livro livro){
        if(livro==null){
            throw new IllegalArgumentException("Livro invalido");
        }
        if(livros.contains(livro)){
            throw new IllegalArgumentException("Livro ja cadastrado");
        }
        livros.add(livro);
    }
    public void removerLivro(Livro livro){
        if(livro==null){
            throw new IllegalArgumentException("Livro invalido");
        }
        if(!livros.contains(livro)){
            throw new IllegalArgumentException("Livro nao cadastrado");
        }
        livros.remove(livro);

    }
}
