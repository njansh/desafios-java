package br.com.nadson.sistema_de_reserva_de_salas.modelo;

public class Usuario {
    private static int PROXIMO_ID = 1;
    private int id;
    private String nome;
    private String email;

    public Usuario(String nome, String email) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do usuário não pode ser nulo ou vazio.");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("O email do usuário não pode ser nulo ou vazio.");
        }
        if (!email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Formato de email inválido.");
        }

        this.id = PROXIMO_ID++;
        this.nome = nome;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               ", email='" + email + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id);
    }

}
