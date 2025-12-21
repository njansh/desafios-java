package br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.modelo;

import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.interfaces.Competidor;
import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.interfaces.Pontuavel;
import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.interfaces.Validavel;

import java.util.ArrayList;
import java.util.List;

public class Time implements Competidor, Pontuavel, Validavel {
    private static int PROXIMO_ID = 1;
    private String nome;
    private final int id;
    private int pontos;
    List<Jogador> jogadors;

    public Time(String nome) {
        this.nome = nome;
        this.id = PROXIMO_ID++;
        this.pontos = 0;
        this.jogadors = new ArrayList<>();
        validar();


    }

    @Override
    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    @Override
    public int getPontos() {
        return pontos;
    }

    @Override
    public void adicionarPontos(int pontos) {
        if (pontos < 0) {
            throw new IllegalArgumentException("Pontos a adicionar não podem ser negativos.");
        }
        this.pontos += pontos;
    }

    public List<Jogador> getJogadors() {
        return jogadors;
    }

    public void adicionarJogador(Jogador jogador) {
        if (jogador == null) {
            throw new IllegalStateException("Jogador não pode ser nulo.");
        }
        if(jogadors.size() >= 11){
            throw new IllegalArgumentException("Um time não pode ter mais de 11 jogadores.");
        }
        this.jogadors.add(jogador);
    }

    @Override
    public void validar() {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do time não pode ser nulo ou vazio.");
        }
    }
}
