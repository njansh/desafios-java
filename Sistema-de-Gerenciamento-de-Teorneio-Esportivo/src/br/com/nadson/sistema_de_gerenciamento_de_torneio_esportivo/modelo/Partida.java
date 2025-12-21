package br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.modelo;

import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.enums.ResultadoPartida;
import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.enums.StatusPartida;
import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.interfaces.Finalizavel;
import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.interfaces.Validavel;

public class Partida implements Finalizavel, Validavel {
    private Time timeA;
    private Time timeB;
    private StatusPartida status;
    private ResultadoPartida resultado;
    private int golsTimeA;
    private int golsTimeB;

    public Partida(Time timeA, Time timeB) {
        this.timeA = timeA;
        this.timeB = timeB;
        this.status = StatusPartida.AGENDADA;
        this.golsTimeA = 0;
        this.golsTimeB = 0;
        validar();
    }

    public Time getTimeA() {
        return timeA;
    }

    public Time getTimeB() {
        return timeB;
    }

    public StatusPartida getStatus() {
        return status;
    }

    public ResultadoPartida getResultado() {
        return resultado;
    }

    public int getGolsTimeA() {
        return golsTimeA;
    }

    public int getGolsTimeB() {
        return golsTimeB;
    }

        public void marcarGolTimeA() {
        if (status != StatusPartida.EM_ANDAMENTO) {
            throw new IllegalStateException("Não é possível marcar gol em uma partida que não está em andamento.");
        }
        this.golsTimeA++;
    }

    public void marcarGolTimeB() {
        if (status != StatusPartida.EM_ANDAMENTO) {
            throw new IllegalStateException("Não é possível marcar gol em uma partida que não está em andamento.");
        }
        this.golsTimeB++;
    }

    public void iniciarPartida() {
        if (status != StatusPartida.AGENDADA) {
            throw new IllegalStateException("A partida já foi iniciada ou finalizada.");
        }
        this.status = StatusPartida.EM_ANDAMENTO;
    }

    @Override
    public void finalizar() {
        if (status != StatusPartida.EM_ANDAMENTO) {
            throw new IllegalStateException("Não é possível finalizar uma partida que não está em andamento.");
        }
        if (golsTimeA > golsTimeB) {
            resultado = ResultadoPartida.VITORIA_TIME_A;
            timeA.adicionarPontos(3);
        } else if (golsTimeB > golsTimeA) {
            resultado = ResultadoPartida.VITORIA_TIME_B;
            timeB.adicionarPontos(3);
        } else {
            resultado = ResultadoPartida.EMPATE;
            timeA.adicionarPontos(1);
            timeB.adicionarPontos(1);
        }
        this.status = StatusPartida.FINALIZADA;
    }

    @Override
    public void validar() {
        if (timeA == null || timeB == null) {
            throw new IllegalArgumentException("Ambos os times devem ser fornecidos para a partida.");
        }
        if (timeA.equals(timeB)) {
            throw new IllegalArgumentException("Os times não podem ser os mesmos.");
        }
        if (!timeA.estaAptoParaPartida() || !timeB.estaAptoParaPartida()) {
            throw new IllegalStateException("Ambos os times devem estar aptos para a partida (mínimo de 7 jogadores).");
        }
    }
}
