package br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.service;

import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.interfaces.Validavel;
import br.com.nadson.sistema_de_gerenciamento_de_torneio_esportivo.modelo.Time;

import java.util.HashSet;
import java.util.Set;

public class TimeService{
    Set<Time> times;

    public TimeService() {
        this.times = new HashSet<>();
        
    }

    public Time adicionarTime(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do time não pode ser nulo ou vazio.");
        }
        Time time = new Time(nome);
        if(times.contains(time)){
            throw new IllegalStateException("Já existe um time com o mesmo nome.");
        }
        
        this.times.add(time);
        return time;
    }

    public Set<Time> getTimes() {
        return new HashSet<>(times);
    }
}
