package br.com.nadson.desafio1.modelo;

public class Avaliacao {
    private double nota;
    private Disciplina disciplina;
private int peso;
public Avaliacao(double nota, Disciplina disciplina, int peso){
    if (nota < 0 || nota > 10) {
        throw new IllegalArgumentException("Nota inválida");
    }
    if (disciplina == null) {
        throw new IllegalArgumentException("Disciplina inválida");
    }
    if (peso <= 0) {
        throw new IllegalArgumentException("Peso inválido");
    }
    this.nota = nota;
    this.disciplina = disciplina;
    this.peso = peso;

}

    public double getNota() {
        return nota;
    }

    public int getPeso() {
        return peso;
    }

    public Disciplina getDisciplina() {
    return disciplina;
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "nota=" + nota +
                ", disciplina=" + disciplina +
                ", peso=" + peso +
                '}';
    }
}
