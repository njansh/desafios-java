package br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.principal;

import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.modelo.Jogador;
import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.modelo.Partida;
import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.modelo.Time;
import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.service.ClassificacaoService;
import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.service.JogadorService;
import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.service.TimeService;
import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.service.TorneioService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        JogadorService jogadorService = new JogadorService();
        TimeService timeService = new TimeService();
        TorneioService torneioService = new TorneioService();
        ClassificacaoService classificacaoService = new ClassificacaoService();

        // Adicionar jogadores
        Jogador j1 = jogadorService.adicionarJogador("Neymar", "ATACANTE");
        Jogador j2 = jogadorService.adicionarJogador("Messi", "ATACANTE");
        Jogador j3 = jogadorService.adicionarJogador("Sergio Ramos", "ZAGUEIRO");
        Jogador j4 = jogadorService.adicionarJogador("Mbappe", "ATACANTE");
        Jogador j5 = jogadorService.adicionarJogador("Vini Jr", "ATACANTE");
        Jogador j6 = jogadorService.adicionarJogador("Casemiro", "MEIO_CAMPO");
        Jogador j7 = jogadorService.adicionarJogador("Alisson", "GOLEIRO");
        Jogador j8 = jogadorService.adicionarJogador("Marquinhos", "ZAGUEIRO");
        Jogador j9 = jogadorService.adicionarJogador("Richarlison", "ATACANTE");
        Jogador j10 = jogadorService.adicionarJogador("Paqueta", "MEIO_CAMPO");
        Jogador j11 = jogadorService.adicionarJogador("Thiago Silva", "ZAGUEIRO");

        Jogador j12 = jogadorService.adicionarJogador("Cristiano Ronaldo", "ATACANTE");
        Jogador j13 = jogadorService.adicionarJogador("Bruno Fernandes", "MEIO_CAMPO");
        Jogador j14 = jogadorService.adicionarJogador("Ruben Dias", "ZAGUEIRO");
        Jogador j15 = jogadorService.adicionarJogador("Joao Cancelo", "LATERAL");
        Jogador j16 = jogadorService.adicionarJogador("Bernardo Silva", "MEIO_CAMPO");
        Jogador j17 = jogadorService.adicionarJogador("Pepe", "ZAGUEIRO");
        Jogador j18 = jogadorService.adicionarJogador("Diogo Costa", "GOLEIRO");
        Jogador j19 = jogadorService.adicionarJogador("Rafael Leao", "ATACANTE");
        Jogador j20 = jogadorService.adicionarJogador("Joao Felix", "ATACANTE");
        Jogador j21 = jogadorService.adicionarJogador("William Carvalho", "MEIO_CAMPO");
        Jogador j22 = jogadorService.adicionarJogador("Nuno Mendes", "LATERAL");


        // Adicionar times
        Time timeBrasil = timeService.adicionarTime("Brasil");
        Time timePortugal = timeService.adicionarTime("Portugal");

        // Adicionar jogadores aos times
        timeBrasil.adicionarJogador(j1);
        timeBrasil.adicionarJogador(j3);
        timeBrasil.adicionarJogador(j4);
        timeBrasil.adicionarJogador(j5);
        timeBrasil.adicionarJogador(j6);
        timeBrasil.adicionarJogador(j7);
        timeBrasil.adicionarJogador(j8);
        timeBrasil.adicionarJogador(j9);
        timeBrasil.adicionarJogador(j10);
        timeBrasil.adicionarJogador(j11);
        timeBrasil.adicionarJogador(j2); // Adicionando Messi ao Brasil para ter 11 jogadores

        timePortugal.adicionarJogador(j12);
        timePortugal.adicionarJogador(j13);
        timePortugal.adicionarJogador(j14);
        timePortugal.adicionarJogador(j15);
        timePortugal.adicionarJogador(j16);
        timePortugal.adicionarJogador(j17);
        timePortugal.adicionarJogador(j18);
        timePortugal.adicionarJogador(j19);
        timePortugal.adicionarJogador(j20);
        timePortugal.adicionarJogador(j21);
        timePortugal.adicionarJogador(j22);

        // Adicionar partidas
        Partida partida1 = torneioService.adicionarPartida(timeBrasil, timePortugal, "IDA");
        Partida partida2 = torneioService.adicionarPartida(timePortugal, timeBrasil, "VOLTA");

        // Simular partidas
        System.out.println("--- Simulação da Partida de IDA ---");
        partida1.iniciarPartida();
        partida1.marcarGolTimeA(); // Brasil 1
        partida1.marcarGolTimeA(); // Brasil 2
        partida1.marcarGolTimeB(); // Portugal 1
        partida1.finalizar();
        System.out.println("Placar final: " + partida1.getTimeA().getNome() + " " + partida1.getGolsTimeA() + " x " + partida1.getGolsTimeB() + " " + partida1.getTimeB().getNome());
        System.out.println("Resultado: " + partida1.getResultado());

        System.out.println("\n--- Simulação da Partida de VOLTA ---");
        partida2.iniciarPartida();
        partida2.marcarGolTimeB(); // Brasil 1
        partida2.marcarGolTimeB(); // Brasil 2
        partida2.marcarGolTimeB(); // Brasil 3
        partida2.marcarGolTimeA(); // Portugal 1
        partida2.finalizar();
        System.out.println("Placar final: " + partida2.getTimeA().getNome() + " " + partida2.getGolsTimeA() + " x " + partida2.getGolsTimeB() + " " + partida2.getTimeB().getNome());
        System.out.println("Resultado: " + partida2.getResultado());

        // Finalizar partidas e atualizar pontuações
        torneioService.finalizarPartida();

        // Atualizar e exibir classificação
        List<Time> todosOsTimes = List.of(timeBrasil, timePortugal);
        classificacaoService.atualizarClassificacao(todosOsTimes);

        System.out.println("\n--- Classificação Final ---");
        for (Time time : classificacaoService.getClassificacao()) {
            System.out.println(time.getNome() + ": " + time.getPontos() + " pontos");
        }
    }
}
