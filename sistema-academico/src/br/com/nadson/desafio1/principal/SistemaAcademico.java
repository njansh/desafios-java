package br.com.nadson.desafio1.principal;

import br.com.nadson.desafio1.modelo.*;

import java.util.ArrayList;
import java.util.List;

public class SistemaAcademico {
    private List<Aluno> alunos;
    private List<Professor> professores;
    private List<Disciplina> disciplinas;
    private List<Matricula> matriculas;
    private List<Avaliacao> avaliacoes;

    public SistemaAcademico() {
        alunos = new ArrayList<>();
        professores = new ArrayList<>();
        disciplinas = new ArrayList<>();
        matriculas = new ArrayList<>();
        avaliacoes = new ArrayList<>();

    }

    public Aluno criarAluno(String nome, int idade) {
        Aluno aluno = new Aluno(nome, idade);
        alunos.add(aluno);
        return aluno;

    }

    public Disciplina criarDisciplina(String nome, Professor professor, int cargaHoraria, int limiteDeAlunos) {
        Disciplina disciplina = new Disciplina(nome, professor, cargaHoraria, limiteDeAlunos);
        disciplinas.add(disciplina);
        return disciplina;
    }

    public Professor criarProfessor(String nome, int idade) {
        Professor professor = new Professor(nome, idade);
        professores.add(professor);
        return professor;

    }

    public Matricula matricularAluno(Aluno aluno, Disciplina disciplina) {
        if (aluno == null || disciplina == null) {
            throw new IllegalArgumentException("Aluno ou disciplina inválidos");
        }

        Matricula matricula = new Matricula(aluno, disciplina);
        matriculas.add(matricula);
        return matricula;
    }

    public Avaliacao lancarAvaliacao(Aluno aluno, Disciplina disciplina, double nota, int peso) {
        if (aluno == null || disciplina == null) {
            throw new IllegalArgumentException("Aluno ou disciplina inválidos");
        }
        Avaliacao avaliacao = new Avaliacao(nota, disciplina, peso);
        aluno.registrarAvaliacao(avaliacao);
        avaliacoes.add(avaliacao);

        return avaliacao;
    }
}

