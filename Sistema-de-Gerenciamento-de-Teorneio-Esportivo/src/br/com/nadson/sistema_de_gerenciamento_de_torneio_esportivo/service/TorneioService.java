package br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.service;

import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.enums.ResultadoPartida;
import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.enums.StatusPartida;
import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.interfaces.Validavel;
import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.modelo.Partida;
import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.modelo.Time;

import java.util.HashSet;
import java.util.Set;

public class TorneioService implements Validavel {
    private Set<Partida> partidas;

    public TorneioService() {
        this.partidas = new HashSet<>();
        validar();
    }

    public Partida adicionarPartida(Time timeA, Time timeB, String turno) {
        if (timeA == null || timeB == null) {
            throw new IllegalArgumentException("Ambos os times devem ser fornecidos para a partida.");
        }
        Partida partida = new Partida(timeA, timeB, turno);

        validar();
        this.partidas.add(partida);
        return partida;
    }

    public Set<Partida> getPartidas() {
        return new HashSet<>(partidas);
    }

    public void finalizarpartda() {
        validar();
        for (Partida partida : partidas) {
            if (partida.getStatus() == StatusPartida.EM_ANDAMENTO) {
                partida.finalizar();
                if (partida.getResultado().equals(ResultadoPartida.VITORIA_TIME_A)
                ) {
                    partida.getTimeA().adicionarPontos(3);
                    partida.getTimeB().adicionarPontos(0);
                }
                if (partida.getResultado().equals(ResultadoPartida.EMPATE)) {
                    partida.getTimeA().adicionarPontos(1);
                    partida.getTimeB().adicionarPontos(1);
                }
                if (partida.getResultado().equals(ResultadoPartida.VITORIA_TIME_B)) {
                    partida.getTimeA().adicionarPontos(0);
                    partida.getTimeB().adicionarPontos(3);
                }


            }
        }
    }

    @Override
    public void validar() {
        if (partidas == null) {
            throw new IllegalStateException("A lista de partidas não pode ser nula.");
        }
    }
}
