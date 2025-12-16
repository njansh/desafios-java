package br.com.nadson.desafio1.modelo;

import java.util.ArrayList;
import java.util.List;

public class Disciplina{
    private String nome;
    private Professor professor;
    private int cargaHoraria;
    private List<Aluno> alunos;
    private int limiteDeAlunos;

    public Disciplina(String nome, Professor professor, int cargaHoraria, int limiteDeAlunos) {

       if(nome == null || nome.isBlank()){
           throw new IllegalArgumentException("Nome inválido");
       }
       if(professor == null){
           throw new IllegalArgumentException("Professor inválido");
       }
       if (cargaHoraria<=0){
           throw new IllegalArgumentException("Carga horária inválida");
       }
       if(limiteDeAlunos<=0){
           throw new IllegalArgumentException("Limite de alunos inválido");
       }


        this.nome = nome;
        this.professor = professor;
        this.cargaHoraria = cargaHoraria;
        this.limiteDeAlunos = limiteDeAlunos;
this.alunos=new ArrayList<>();

    }

    public void registrarAluno(Aluno aluno){
        if(aluno==null){
            throw new IllegalArgumentException("Aluno inválido");
        }
        if (alunos.contains(aluno)){
            throw new IllegalArgumentException("Aluno já matriculado");
        }
        if(alunos.size()>=limiteDeAlunos){
            throw new IllegalStateException("Limite de alunos atingido");
        }

        alunos.add(aluno);

    }

    public String getNome() {
        return nome;
    }

    public Professor getProfessor() {
        return professor;
    }



}
