package com.br.nadson.sistema_de_biblioteca.principal;

import com.br.nadson.sistema_de_biblioteca.modelo.Livro;
import com.br.nadson.sistema_de_biblioteca.modelo.Usuario;
import com.br.nadson.sistema_de_biblioteca.servico.Biblioteca;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca=new Biblioteca();
        Usuario u1=biblioteca.adicionarUsuario("João",33);
        Usuario u2=biblioteca.adicionarUsuario("Maria",25);
            
        Livro l1=biblioteca.adicionarLivro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "978-85-9508-160-7");
        Livro l2=biblioteca.adicionarLivro("O Senhor dos Anéis", "J.R.R. Tolkien","978-85-333-0227-3");
        Livro l3=biblioteca.adicionarLivro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", "978-85-325-1101-5");
        Livro l4=biblioteca.adicionarLivro("1984", "George Orwell", "978-85-221-0616-1");
        Livro l5=biblioteca.adicionarLivro("Dom Quixote", "Miguel de Cervantes", "978-85-7232-731-8");
        Livro l6=biblioteca.adicionarLivro("Orgulho e Preconceito", "Jane Austen", "978-85-378-0212-7");

        System.out.println("--- Estado inicial da biblioteca ---");
        System.out.println("Usuários: " + u1.apresentar() + ", " + u2.apresentar());
        System.out.println("Livros: " + l1.toString() + ", " + l2.toString() + ", " + l3.toString() + ", " + l4.toString() + ", " + l5.toString() + ", " + l6.toString());
        System.out.println();

        System.out.println("--- Empréstimos ---");
        try {
            biblioteca.emprestarLivros(u1, l1);
            System.out.println(u1.getNome() + " emprestou " + l1.getTitulo());
            biblioteca.emprestarLivros(u1, l2);
            System.out.println(u1.getNome() + " emprestou " + l2.getTitulo());
            biblioteca.emprestarLivros(u2, l3);
            System.out.println(u2.getNome() + " emprestou " + l3.getTitulo());
            biblioteca.emprestarLivros(u2, l4);
            System.out.println(u2.getNome() + " emprestou " + l4.getTitulo());
            biblioteca.emprestarLivros(u1, l5);
            System.out.println(u1.getNome() + " emprestou " + l5.getTitulo());
            // Tentativa de emprestar mais de 5 livros para u1
            biblioteca.emprestarLivros(u1, l6);
            System.out.println(u1.getNome() + " emprestou " + l6.getTitulo());
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println("Erro ao emprestar livro: " + e.getMessage());
        }
        System.out.println();

        System.out.println("--- Estado após empréstimos ---");
        System.out.println(u1.getNome() + " livros emprestados: " + u1.getQuantidadeLivrosEmprestados());
        System.out.println(u2.getNome() + " livros emprestados: " + u2.getQuantidadeLivrosEmprestados());
        System.out.println("Estado do livro " + l1.getTitulo() + ": " + l1.getEstadoLivro());
        System.out.println("Estado do livro " + l6.getTitulo() + ": " + l6.getEstadoLivro());
        System.out.println();

        System.out.println("--- Devoluções ---");
        try {
            biblioteca.devolverLivros(u1, l1);
            System.out.println(u1.getNome() + " devolveu " + l1.getTitulo());
            // Tentativa de devolver livro não emprestado por u2
            biblioteca.devolverLivros(u2, l1);
            System.out.println(u2.getNome() + " devolveu " + l1.getTitulo());
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println("Erro ao devolver livro: " + e.getMessage());
        }
        System.out.println();

        System.out.println("--- Estado após devoluções ---");
        System.out.println(u1.getNome() + " livros emprestados: " + u1.getQuantidadeLivrosEmprestados());
        System.out.println("Estado do livro " + l1.getTitulo() + ": " + l1.getEstadoLivro());
        System.out.println();

        System.out.println("--- Remoção de Usuário ---");
        try {
            // Tentativa de remover usuário com livros emprestados
            biblioteca.removerUsuario(u1);
            System.out.println("Usuário " + u1.getNome() + " removido.");
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println("Erro ao remover usuário: " + e.getMessage());
        }
        System.out.println();

        System.out.println("--- Remoção de Livro ---");
        try {
            // Tentativa de remover livro emprestado
            biblioteca.removerLivro(l3);
            System.out.println("Livro " + l3.getTitulo() + " removido.");
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println("Erro ao remover livro: " + e.getMessage());
        }
        System.out.println();

        // Devolver todos os livros de u1 para que ele possa ser removido
        try {
            biblioteca.devolverLivros(u1, l2);
            biblioteca.devolverLivros(u1, l5);
            System.out.println(u1.getNome() + " devolveu todos os livros.");
            biblioteca.removerUsuario(u1);
            System.out.println("Usuário " + u1.getNome() + " removido.");
            System.out.println();
        }catch (IllegalStateException | IllegalArgumentException e) {
        System.out.println("Erro ao devolver livro: " + e.getMessage()  );
        }

            // Devolver todos os livros de u2 para que ele possa ser removido
        biblioteca.devolverLivros(u2, l3);
        biblioteca.devolverLivros(u2, l4);
        System.out.println(u2.getNome() + " devolveu todos os livros.");
        biblioteca.removerUsuario(u2);
        System.out.println("Usuário " + u2.getNome() + " removido.");
        System.out.println();

        // Remover livros restantes
        System.out.println("Livro " + l6.getTitulo() + " removido.");
        biblioteca.removerLivro(l1);
        System.out.println("Livro " + l1.getTitulo() + " removido.");
        System.out.println();

        System.out.println("--- Fim da demonstração ---");
    }
}
