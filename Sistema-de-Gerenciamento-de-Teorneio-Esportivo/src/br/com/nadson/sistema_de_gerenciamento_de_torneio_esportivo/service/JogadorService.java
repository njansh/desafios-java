package br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.service;

import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.modelo.Jogador;

import java.util.HashSet;
import java.util.Set;

public class JogadorService {
    Set<Jogador> jogadors;

    public JogadorService() {
        this.jogadors = new HashSet<>();
    }

    public Jogador adicionarJogador(String nome, String posicao) {
        Jogador jogador = new Jogador(nome, posicao);
        if (jogadors.contains(jogador)) {
            throw new IllegalStateException("Já existe um jogador com o mesmo ID.");
        }
        this.jogadors.add(jogador);
        return jogador;
    }

    public Set<Jogador> getJogadors() {
        return new HashSet<>(jogadors);
    }
}
