package br.com.nadson.sistema_de_reserva_de_salas.service;

import br.com.nadson.sistema_de_reserva_de_salas.enums.StatusReserva;
import br.com.nadson.sistema_de_reserva_de_salas.modelo.Reserva;
import br.com.nadson.sistema_de_reserva_de_salas.modelo.Sala;
import br.com.nadson.sistema_de_reserva_de_salas.modelo.Usuario;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ReservaService {
    private Set<Usuario> usuarios;
    private Set<Sala> salas;
    private Set<Reserva> reservas;
    private static ReservaService instance;

    private ReservaService() {
        this.reservas = new HashSet<>();
        this.salas = new HashSet<>();
        this.usuarios = new HashSet<>();
    }

    public static synchronized ReservaService getInstance() {
        if (instance == null) {
            instance = new ReservaService();
        }
        return instance;
    }

    public Usuario adicionarUsuario(String nome, String email) {
        // Check for existing user by email before creating a new one
        if (this.usuarios.stream().anyMatch(u -> u.getEmail().equals(email))) {
            throw new IllegalArgumentException("Já existe um usuário com este email.");
        }
        Usuario usuario = new Usuario(nome, email);
        this.usuarios.add(usuario);
        return usuario;
    }

    public Sala adicionarSala(String nome, int capacidade) {
        // Check for existing sala by name before creating a new one
        if (this.salas.stream().anyMatch(s -> s.getNome().equals(nome))) {
            throw new IllegalArgumentException("Já existe uma sala com este nome.");
        }
        Sala sala = new Sala(nome, capacidade);
        this.salas.add(sala);
        return sala;
    }

    public Reserva reservarSala(Sala sala, Usuario usuario, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim) {
        if (sala == null || usuario == null || dataHoraInicio == null || dataHoraFim == null) {
            throw new IllegalArgumentException("Todos os campos de reserva são obrigatórios.");
        }
        if (!salas.contains(sala)) {
            throw new IllegalArgumentException("Sala não encontrada.");
        }
        if (!usuarios.contains(usuario)) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }
        if (dataHoraInicio.isAfter(dataHoraFim) || dataHoraInicio.isEqual(dataHoraFim)) {
            throw new IllegalArgumentException("A data e hora de início deve ser anterior à data e hora de fim.");
        }
        if (dataHoraInicio.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Não é possível reservar uma sala para o passado.");
        }

        // Verificar sobreposição de reservas
        boolean sobreposicao = reservas.stream()
                .filter(r -> r.getSala().equals(sala) && r.getStatus() == StatusReserva.RESERVADA)
                .anyMatch(r ->
                        (dataHoraInicio.isBefore(r.getDataHoraFim()) && dataHoraFim.isAfter(r.getDataHoraInicio()))
                );

        if (sobreposicao) {
            throw new IllegalStateException("A sala já está reservada para o período selecionado.");
        }

        Reserva novaReserva = new Reserva(sala, usuario, dataHoraInicio, dataHoraFim);
        this.reservas.add(novaReserva);
        return novaReserva;
    }

    public void cancelarReserva(int idReserva) {
        Optional<Reserva> reservaOptional = reservas.stream().filter(r -> r.getId() == idReserva).findFirst();
        if (reservaOptional.isEmpty()) {
            throw new IllegalArgumentException("Reserva não encontrada.");
        }
        Reserva reserva = reservaOptional.get();
        reserva.cancelarReserva();
    }

    public void finalizarReserva(int idReserva) {
        Optional<Reserva> reservaOptional = reservas.stream().filter(r -> r.getId() == idReserva).findFirst();
        if (reservaOptional.isEmpty()) {
            throw new IllegalArgumentException("Reserva não encontrada.");
        }
        Reserva reserva = reservaOptional.get();
        reserva.finalizarReserva();
    }

    public Set<Reserva> listarReservas() {
        return Collections.unmodifiableSet(reservas);
    }

    public Set<Reserva> listarReservasPorUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo.");
        }
        Set<Reserva> reservasDoUsuario = new HashSet<>();
        for (Reserva reserva : reservas) {
            if (reserva.getUsuario().equals(usuario)) {
                reservasDoUsuario.add(reserva);
            }
        }
        return Collections.unmodifiableSet(reservasDoUsuario);
    }

    public Set<Reserva> listarReservasPorSala(Sala sala) {
        if (sala == null) {
            throw new IllegalArgumentException("Sala não pode ser nula.");
        }
        Set<Reserva> reservasDaSala = new HashSet<>();
        for (Reserva reserva : reservas) {
            if (reserva.getSala().equals(sala)) {
                reservasDaSala.add(reserva);
            }
        }
        return Collections.unmodifiableSet(reservasDaSala);
    }

    public Set<Sala> listarSalasDisponiveis(LocalDateTime inicio, LocalDateTime fim) {
        if (inicio == null || fim == null) {
            throw new IllegalArgumentException("As datas de início e fim não podem ser nulas.");
        }
        if (inicio.isAfter(fim) || inicio.isEqual(fim)) {
            throw new IllegalArgumentException("A data de início deve ser anterior à data de fim.");
        }

        Set<Sala> salasDisponiveis = new HashSet<>(this.salas);

        for (Reserva reserva : reservas) {
            if (reserva.getStatus() == StatusReserva.RESERVADA &&
                    (inicio.isBefore(reserva.getDataHoraFim()) && fim.isAfter(reserva.getDataHoraInicio()))) {
                salasDisponiveis.remove(reserva.getSala());
            }
        }
        return Collections.unmodifiableSet(salasDisponiveis);
    }

    public Set<Usuario> getUsuarios() {
        return Collections.unmodifiableSet(usuarios);
    }

    public Set<Sala> getSalas() {
        return Collections.unmodifiableSet(salas);
    }
}
