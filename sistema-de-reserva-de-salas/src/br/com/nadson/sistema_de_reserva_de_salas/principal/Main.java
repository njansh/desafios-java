package br.com.nadson.sistema_de_reserva_de_salas.principal;

import br.com.nadson.sistema_de_reserva_de_salas.modelo.Reserva;
import br.com.nadson.sistema_de_reserva_de_salas.modelo.Sala;
import br.com.nadson.sistema_de_reserva_de_salas.modelo.Usuario;
import br.com.nadson.sistema_de_reserva_de_salas.service.ReservaService;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        ReservaService reservaService = ReservaService.getInstance();

        // Adicionar Usuários
        Usuario u1 = null;
        Usuario u2 = null;
        try {
            u1 = reservaService.adicionarUsuario("Alice", "alice@example.com");
            u2 = reservaService.adicionarUsuario("Bob", "bob@example.com");
            System.out.println("Usuários adicionados: " + u1.getNome() + ", " + u2.getNome());
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao adicionar usuário: " + e.getMessage());
        }

        // Adicionar Salas
        Sala s1 = null;
        Sala s2 = null;
        try {
            s1 = reservaService.adicionarSala("Sala Alpha", 10);
            s2 = reservaService.adicionarSala("Sala Beta", 5);
            System.out.println("Salas adicionadas: " + s1.getNome() + ", " + s2.getNome());
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao adicionar sala: " + e.getMessage());
        }

        // Realizar Reservas
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime inicio1 = now.plusHours(1);
        LocalDateTime fim1 = now.plusHours(2);

        LocalDateTime inicio2 = now.plusHours(3);
        LocalDateTime fim2 = now.plusHours(4);

        LocalDateTime inicio3 = now.plusHours(1).plusDays(1);
        LocalDateTime fim3 = now.plusHours(2).plusDays(1);

        Reserva r1 = null;
        Reserva r2 = null;
        Reserva r3 = null;

        if (s1 != null && u1 != null && s2 != null && u2 != null) {
            try {
                r1 = reservaService.reservarSala(s1, u1, inicio1, fim1);
                System.out.println("Reserva 1 realizada: " + r1);
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.err.println("Erro ao reservar sala: " + e.getMessage());
            }

            try {
                r2 = reservaService.reservarSala(s2, u2, inicio2, fim2);
                System.out.println("Reserva 2 realizada: " + r2);
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.err.println("Erro ao reservar sala: " + e.getMessage());
            }

            // Tentativa de reserva sobreposta
            try {
                reservaService.reservarSala(s1, u2, inicio1.plusMinutes(30), fim1.plusMinutes(30));
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.err.println("Erro esperado ao tentar reservar sala sobreposta: " + e.getMessage());
            }

            try {
                r3 = reservaService.reservarSala(s1, u1, inicio3, fim3);
                System.out.println("Reserva 3 realizada: " + r3);
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.err.println("Erro ao reservar sala: " + e.getMessage());
            }
        }

        // Listar todas as reservas
        System.out.println("\n--- Todas as Reservas ---");
        reservaService.listarReservas().forEach(System.out::println);

        // Listar reservas por usuário
        if (u1 != null) {
            System.out.println("\n--- Reservas de " + u1.getNome() + " ---");
            reservaService.listarReservasPorUsuario(u1).forEach(System.out::println);
        }

        // Listar reservas por sala
        if (s1 != null) {
            System.out.println("\n--- Reservas da " + s1.getNome() + " ---");
            reservaService.listarReservasPorSala(s1).forEach(System.out::println);
        }

        // Cancelar uma reserva
        if (r1 != null) {
            try {
                reservaService.cancelarReserva(r1.getId());
                System.out.println("\nReserva " + r1.getId() + " cancelada.");
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.err.println("Erro ao cancelar reserva: " + e.getMessage());
            }
        }

        // Finalizar uma reserva
        if (r2 != null) {
            try {
                reservaService.finalizarReserva(r2.getId());
                System.out.println("Reserva " + r2.getId() + " finalizada.");
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.err.println("Erro ao finalizar reserva: " + e.getMessage());
            }
        }

        System.out.println("\n--- Todas as Reservas (Após Cancelar/Finalizar) ---");
        reservaService.listarReservas().forEach(System.out::println);

        // Listar salas disponíveis
        System.out.println("\n--- Salas Disponíveis para " + now.plusHours(1) + " a " + now.plusHours(2) + " ---");
        reservaService.listarSalasDisponiveis(now.plusHours(1), now.plusHours(2)).forEach(System.out::println);

        System.out.println("\n--- Salas Disponíveis para " + now.plusHours(5) + " a " + now.plusHours(6) + " ---");
        reservaService.listarSalasDisponiveis(now.plusHours(5), now.plusHours(6)).forEach(System.out::println);
    }
}
