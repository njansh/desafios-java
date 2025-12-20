package br.com.nadson.sistema_de_reserva_de_salas.modelo;

import br.com.nadson.sistema_de_reserva_de_salas.enums.StatusReserva;

import java.time.LocalDateTime;
import java.util.Objects;

public class Reserva {
    private static int PROXIMO_ID = 1;
    private int id;
    private Sala sala;
    private Usuario usuario;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private StatusReserva status;

    public Reserva(Sala sala, Usuario usuario, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim) {
        if (sala == null) {
            throw new IllegalArgumentException("A sala não pode ser nula.");
        }
        if (usuario == null) {
            throw new IllegalArgumentException("O usuário não pode ser nulo.");
        }
        if (dataHoraInicio == null) {
            throw new IllegalArgumentException("A data e hora de início não pode ser nula.");
        }
        if (dataHoraFim == null) {
            throw new IllegalArgumentException("A data e hora de fim não pode ser nula.");
        }
        if (dataHoraInicio.isAfter(dataHoraFim) || dataHoraInicio.isEqual(dataHoraFim)) {
            throw new IllegalArgumentException("A data e hora de início deve ser anterior à data e hora de fim.");
        }

        this.id = PROXIMO_ID++;
        this.sala = sala;
        this.usuario = usuario;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.status = StatusReserva.RESERVADA; // Status inicial da reserva
    }

    public int getId() {
        return id;
    }

    public Sala getSala() {
        return sala;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public StatusReserva getStatus() {
        return status;
    }

    public void cancelarReserva() {
        if (this.status == StatusReserva.FINALIZADA) {
            throw new IllegalStateException("Não é possível cancelar uma reserva finalizada.");
        }
        this.status = StatusReserva.CANCELADA;
    }

    public void finalizarReserva() {
        if (this.status == StatusReserva.CANCELADA) {
            throw new IllegalStateException("Não é possível finalizar uma reserva cancelada.");
        }
        this.status = StatusReserva.FINALIZADA;
    }

    @Override
    public String toString() {
        return "Reserva{" +
               "id=" + id +
               ", sala=" + sala.getNome() +
               ", usuario=" + usuario.getNome() +
               ", dataHoraInicio=" + dataHoraInicio +
               ", dataHoraFim=" + dataHoraFim +
               ", status=" + status +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return id == reserva.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
