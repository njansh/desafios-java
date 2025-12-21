package br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.modelo;

import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.enums.ResultadoPartida;
import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.enums.StatusPartida;
import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.enums.Turno;
import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.interfaces.Finalizavel;
import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.interfaces.Validavel;

import java.util.Objects;

public class Partida implements Finalizavel, Validavel {
    private Time timeA;
    private Time timeB;
    private StatusPartida status;
    private ResultadoPartida resultado;
    private Turno turno;
    private int golsTimeA;
    private int golsTimeB;

    public Partida(Time timeA, Time timeB, String turno) {
        this.timeA = timeA;
        this.timeB = timeB;
        try {
            this.turno = Turno.valueOf(turno.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Turno inválido. Use IDA ou VOLTA.");
        }
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

    public Turno getTurno() {
        return turno;
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
        this.status = StatusPartida.FINALIZADA;
        if (golsTimeA > golsTimeB) {
            resultado = ResultadoPartida.VITORIA_TIME_A;
        } else if (golsTimeB > golsTimeA) {
            resultado = ResultadoPartida.VITORIA_TIME_B;
        } else {
            resultado = ResultadoPartida.EMPATE;

        }
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
        if (turno == null) {
            throw new IllegalArgumentException("Turno não pode ser nulo.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Partida partida = (Partida) o;
        return Objects.equals(timeA, partida.timeA) && Objects.equals(timeB, partida.timeB) && turno == partida.turno;
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeA, timeB, turno);
    }
}
