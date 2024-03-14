package alura.paulo.screenmatch.modelo;

import alura.paulo.screenmatch.calculos.Classificavel;
import alura.paulo.screenmatch.calculos.ConsomeTempo;

public class Episodio implements Classificavel, ConsomeTempo {
    private int numero;
    private String nomeEp;
    private Serie serie;
    private int qtdVisualizacoes;
    private int tempoDoEp;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNomeEp() {
        return nomeEp;
    }

    public void setNomeEp(String nomeEp) {
        this.nomeEp = nomeEp;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public int getQtdVisualizacoes() {
        return qtdVisualizacoes;
    }

    public void setQtdVisualizacoes(int qtdVisualizacoes) {
        this.qtdVisualizacoes = qtdVisualizacoes;
    }

    public int getTempoDoEp() {
        return tempoDoEp;
    }

    public void setTempoDoEp(int tempoDoEp) {
        this.tempoDoEp = tempoDoEp;
    }

    @Override
    public int getClassificacao() {
        if (getQtdVisualizacoes() > 1000) return 5;
        return 3;
    }

    @Override
    public int getTempo() {
        return this.getTempoDoEp();
    }
}
