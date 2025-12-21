package br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.modelo;


import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.enums.Posicao;
import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.interfaces.Competidor;
import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.interfaces.Validavel;

import java.util.Objects;

public class Jogador implements Competidor, Validavel {
    private static int PROXIMO_ID = 1;
    private String nome;
    private Posicao posicao;
    private final int id;

    public Jogador(String nome,String posicao){
        this.posicao = null;
        this.nome = nome;

        try {
            this.posicao = Posicao.valueOf(posicao.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Posição inválida...");
        }

        validar();


        this.id = PROXIMO_ID++;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public int getId() {
        return id;
    }

    @Override
    public void validar() {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do jogador não pode ser nulo ou vazio.");
        }
        if (posicao == null) {
            throw new IllegalArgumentException("Posição do jogador não pode ser nula.");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Jogador jogador = (Jogador) o;
        return id == jogador.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
