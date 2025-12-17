package br.com.nadson.desafio1.principal;

import br.com.nadson.desafio1.modelo.Aluno;
import br.com.nadson.desafio1.modelo.Disciplina;
import br.com.nadson.desafio1.modelo.Professor;

public class Main {
    public static void main(String[] args){
        SistemaAcademico sistemaAcademico = new SistemaAcademico();

        Professor professor=sistemaAcademico.criarProfessor("Ricardo",45);
        Professor professor1=sistemaAcademico.criarProfessor("Henrique", 56);

        Disciplina portugues=sistemaAcademico.criarDisciplina("Português",professor,60,20);
        Disciplina matematica=sistemaAcademico.criarDisciplina("Matematica", professor1, 70, 10);

        Aluno aluno=sistemaAcademico.criarAluno("Nadson",20 );
        Aluno aluno1=sistemaAcademico.criarAluno("João",21);
        Aluno aluno2=sistemaAcademico.criarAluno("Pedro",22);

        sistemaAcademico.matricularAluno(aluno,portugues);
        sistemaAcademico.matricularAluno(aluno1,portugues);
        sistemaAcademico.matricularAluno(aluno1,matematica);
        sistemaAcademico.matricularAluno(aluno2,matematica);

        sistemaAcademico.lancarAvaliacao(aluno,portugues,10,2);
        sistemaAcademico.lancarAvaliacao(aluno,portugues,9,1);
        sistemaAcademico.lancarAvaliacao(aluno1,portugues,8,1);
        sistemaAcademico.lancarAvaliacao(aluno1,portugues,9,1);
        sistemaAcademico.lancarAvaliacao(aluno1,portugues,7,1);
        sistemaAcademico.lancarAvaliacao(aluno1,matematica,7,1);
        sistemaAcademico.lancarAvaliacao(aluno1,matematica,9,1);
        sistemaAcademico.lancarAvaliacao(aluno2,matematica,7,1);
        sistemaAcademico.lancarAvaliacao(aluno2,matematica,8,1);
        sistemaAcademico.lancarAvaliacao(aluno2,matematica,9,1);


        System.out.println(aluno.relatorioAcademico());
        System.out.println("_____________");
        System.out.println(aluno1.relatorioAcademico());
        System.out.println("_____________");
        System.out.println(aluno2.relatorioAcademico());






    }
}
