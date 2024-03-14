package alura.paulo.screenmatch.calculos;

import alura.paulo.screenmatch.modelo.Filme;
import alura.paulo.screenmatch.modelo.Serie;
import alura.paulo.screenmatch.modelo.Titulo;

import java.util.concurrent.ConcurrentSkipListSet;

/*
* Classe responsável por realizar cálculos de tempo em relação aos títulos
* */

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
