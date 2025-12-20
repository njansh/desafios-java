package br.com.nadson.sistema_de_reserva_de_salas.modelo;

import java.util.Objects;

public class Sala {
    private static int PROXIMO_ID =1;
    private int id;
    private String nome;
    private int capacidade;

    public Sala(String nome, int capacidade) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da sala não pode ser nulo ou vazio.");
        }
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade da sala deve ser maior que zero.");
        }

        this.id = PROXIMO_ID++;
        this.nome = nome;
        this.capacidade = capacidade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    @Override
    public String toString() {
        return "Sala{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               ", capacidade=" + capacidade +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Sala sala = (Sala) o;
        return id == sala.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
