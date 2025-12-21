package br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.modelo;


import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.enums.Posicao;
import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.interfaces.Competidor;

public class Jogador implements Competidor {
    private static int PROXIMO_ID = 1;
    private String nome;
    private Posicao posicao;
    private final int id;

    public Jogador(String nome,String posicao){

        if(nome == null || nome.isBlank()){
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");

        }
        try {
            this.posicao = Posicao.valueOf(posicao.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Posição inválida: " + posicao + ". Posições válidas são: GOLEIRO, ZAGUEIRO, LATERAL, MEIO_CAMPO, ATACANTE.");
        }

        this.nome = nome;
        this.id = PROXIMO_ID++;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public int getId() {
        return id;
    }
}

