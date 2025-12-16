package br.com.nadson.desafio1.modelo;

import java.time.LocalDate;

public class Matricula {
    private Aluno aluno;
    private Disciplina disciplina;
    private LocalDate dataMatricula;

    public Matricula(Aluno aluno, Disciplina disciplina) {
        if (aluno == null) {
            throw new IllegalArgumentException("Aluno inválido");
        }
        if (disciplina == null) {
            throw new IllegalArgumentException("Disciplina inválida");
        }
        if (aluno.getStatus() != StatusAluno.ATIVO) {
            throw new IllegalStateException("Aluno não está ativo");
        }
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.dataMatricula = LocalDate.now();
        aluno.registrarDisciplina(disciplina);
        disciplina.registrarAluno(aluno);
    }
}


