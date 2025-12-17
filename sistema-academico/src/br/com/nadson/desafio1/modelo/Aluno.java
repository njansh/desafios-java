package br.com.nadson.desafio1.modelo;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Aluno extends Pessoa {
    private StatusAluno status = StatusAluno.ATIVO;
    private static int GERADOR_MATRICULA = 1;
    private final int matricula;
    private List<Disciplina> disciplinas;
    private List<Avaliacao> avaliacoes;

    public Aluno(String nome, int idade) {
        super(nome, idade);
        this.matricula = GERADOR_MATRICULA++;
        disciplinas = new ArrayList<>();
        avaliacoes = new ArrayList<>();
    }

    public void registrarDisciplina(Disciplina disciplina) {
        if (disciplina == null) {
            throw new IllegalArgumentException("Disciplina inválida");
        }

        if (status != StatusAluno.ATIVO) {
            throw new IllegalStateException("Aluno não está ativo");
        }

        if (disciplinas.contains(disciplina)) {
            throw new IllegalArgumentException("Disciplina já registrada");
        }

        disciplinas.add(disciplina);
    }

    public void registrarAvaliacao(Avaliacao avaliacao) {
        if (avaliacao == null) {
            throw new IllegalArgumentException("Avaliação inválida");
        }

        if (status != StatusAluno.ATIVO) {
            throw new IllegalStateException("Aluno não está ativo");
        }
        if (!disciplinas.contains(avaliacao.getDisciplina())) {
            throw new IllegalArgumentException("O aluno nao esta matriculado nessa disciplina");
        }
        if (avaliacoes.contains(avaliacao)) {
            throw new IllegalArgumentException("Avaliação já registrada");
        }
        avaliacoes.add(avaliacao);
    }

    public double mediaPonderada(Disciplina disciplina) {
        if (disciplina == null) {
            throw new IllegalArgumentException("Disciplina inválida");

        }
        if (!disciplinas.contains(disciplina)) {
            throw new IllegalArgumentException("O aluno nao esta matriculado nessa disciplina");

        }
        List<Avaliacao> avaliacoesDisciplina = avaliacoes.stream().
                filter(avaliacao -> avaliacao.getDisciplina().equals(disciplina))
                .collect(Collectors.toUnmodifiableList());
        if (avaliacoesDisciplina.isEmpty()) {
            throw new IllegalArgumentException("Nenhuma avaliação registrada para essa disciplina");
        }
        double totalPonderado = 0;
        int totalPeso = 0;
//        double somaNotas = avaliacoesDisciplina.stream().forEach(avaliacao ->{
//          totalPonderado+=(avaliacao.getNota()*avaliacao.getPeso());
//          totalPeso+=avaliacao.getPeso();
//                });

        for (Avaliacao ava : avaliacoesDisciplina) {
            totalPonderado += (ava.getNota() * ava.getPeso());
            totalPeso += ava.getPeso();
        }

        return totalPonderado / totalPeso;


    }

    public ResultadoAvaliacao resultado(Disciplina disciplina) {
        double media = mediaPonderada(disciplina);

        if (media >= 7) {
            return ResultadoAvaliacao.APROVADO;

        } else if (media >= 5) {
            return ResultadoAvaliacao.RECUPERACAO;
        } else {
            return ResultadoAvaliacao.REPROVADO;
        }
    }

    public int getMatricula() {
        return matricula;
    }

    public StatusAluno getStatus() {
        return status;
    }

    public void trancar() {
        this.status = StatusAluno.TRANCADO;
    }

    public void formar() {
        this.status = StatusAluno.FORMADO;
    }

    public void destrancar() {
        this.status = StatusAluno.ATIVO;
    }

    public String relatorioAcademico() {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Relatório Acadêmico\n");
        relatorio.append("Nome: ").append(getNome()).append("\n");
        relatorio.append("Matrícula: ").append(matricula).append("\n");
        relatorio.append("Disciplinas matriculadas:\n");
        for (Disciplina disciplina : disciplinas) {
            relatorio.append("- ").append(disciplina.getNome()).append("\n");

            relatorio.append("Avaliações realizadas:\n");
            List<Avaliacao> avaliacoesDisciplina = avaliacoes.stream().
                    filter(avaliacao -> avaliacao.getDisciplina().equals(disciplina))
                    .collect(Collectors.toUnmodifiableList());
            if (avaliacoesDisciplina.isEmpty()) {
                relatorio.append("Nenhuma avaliação registrada para essa disciplina");
                continue;
            }
            for (Avaliacao avaliacao : avaliacoesDisciplina) {

                    relatorio.append("- ").append(avaliacao.getNota()).append("\n");



            }
            relatorio.append("Média ponderada: ").append(mediaPonderada(disciplina)).append("\n");
            relatorio.append("Resultado: ").append(resultado(disciplina)).append("\n");

        }
        return relatorio.toString();

    }

    @Override
    public String apresentar() {
        return String.format("Nome: %s, Idade: %d, Matricula: %d, Status: %s", getNome(), getIdade(), matricula, status);
    }
}
