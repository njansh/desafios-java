package br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.service;

import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.modelo.Time;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ClassificacaoService {
    private List<Time> classificacao;

    public ClassificacaoService() {
        this.classificacao = new ArrayList<>();
    }

    public List<Time> getClassificacao() {
        return classificacao;
    }

    public void atualizarClassificacao(List<Time> times) {
        this.classificacao = times.stream()
                .sorted(Comparator.comparingInt(Time::getPontos).reversed())
                .collect(Collectors.toList());
    }
}
