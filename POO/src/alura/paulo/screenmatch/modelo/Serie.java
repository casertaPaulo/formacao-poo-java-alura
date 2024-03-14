package alura.paulo.screenmatch.modelo;

import alura.paulo.screenmatch.calculos.Classificavel;

public class Serie extends Titulo implements Classificavel {
    private int temps;
    private int epsPorTemp;
    private int minPorEp;
    private boolean ativa;

    // Como a classe série é uma subclasse de Titulo, devemos passar o mesmo contrutor e chamar o super
    public Serie(String nome, int anoLancamento) {
        super(nome, anoLancamento);
    }

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    public int getEpsPorTemp() {
        return epsPorTemp;
    }

    public void setEpsPorTemp(int epsPorTemp) {
        this.epsPorTemp = epsPorTemp;
    }

    public int getMinPorEp() {
        return minPorEp;
    }

    public void setMinPorEp(int minPorEp) {
        this.minPorEp = minPorEp;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    @Override
    public void imprimirFicha() {

        super.imprimirFicha();
        System.out.println("Número de temporadas: " + temps);
    }

    @Override
    public int getDuracaoEmMinutos() {
        return this.getEpsPorTemp() * this.getTemps() * this.getMinPorEp();
    }

    @Override
    public String toString() {
        return "Série: " + this.getNome();
    }

    @Override
    public int getClassificacao() {
        return (this.getSomaDasNotas() / this.getTotalAvalicao()) / 2 ;
    }
}
