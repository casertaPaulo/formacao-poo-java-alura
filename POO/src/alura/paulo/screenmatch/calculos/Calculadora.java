package alura.paulo.screenmatch.calculos;

import alura.paulo.screenmatch.modelo.Filme;
import alura.paulo.screenmatch.modelo.Serie;
import alura.paulo.screenmatch.modelo.Titulo;

import java.util.concurrent.ConcurrentSkipListSet;

public class Calculadora {
    private int tempoTotal;

    public int getTempoTotal() {
        return tempoTotal;
    }

    // Aplicando polimorfismo
    public void incluir(ConsomeTempo consomeTempo) {
        tempoTotal += consomeTempo.getTempo();
    }
}
