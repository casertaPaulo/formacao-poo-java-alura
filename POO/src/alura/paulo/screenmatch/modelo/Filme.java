package alura.paulo.screenmatch.modelo;

import alura.paulo.screenmatch.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {
    private String diretor;


    // Como a classe série é uma subclasse de Titulo, devemos passar o mesmo contrutor e chamar o super
    public Filme(String nome, int anoLancamento) {
        super(nome, anoLancamento);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public void imprimirFicha() {
        System.out.println("Diretor: " + diretor);
        System.out.println("Classificação em estrelas: " + getClassificacao());
        super.imprimirFicha();
    }

    // Cumprindo o contrato definido pela interface.
    @Override
    public int getClassificacao() {
        // Retornar lógica para obter a classificação
        return (int) (getSomaDasNotas() / getTotalAvalicao()) / 2;
    }

    @Override
    public String toString() {
        // Reescrenvendo o método da classe mãe - Object
        return "Filme: " + getNome();
    }
}
