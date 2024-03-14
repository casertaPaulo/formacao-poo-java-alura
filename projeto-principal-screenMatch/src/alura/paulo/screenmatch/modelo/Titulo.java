package alura.paulo.screenmatch.modelo;

import alura.paulo.screenmatch.calculos.ConsomeTempo;
import alura.paulo.screenmatch.excecao.ErroDeConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements ConsomeTempo, Comparable<Titulo> {
    private String nome;
    private int anoLancamento;
    private int duracaoEmMinutos;
    private int somaDasNotas;
    private int totalAvalicao;

    public Titulo(String nome, int anoLancamento) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
    }

    public Titulo(TituloOmdb tituloOmdb) {
        this.nome = tituloOmdb.title();

        // Caso o tamanho seja maior que 4 (2010x), é lançado uma exceção personalizada.
        if (tituloOmdb.year().length() > 4) {
            // Lançando uma exceção personalizada
            throw new ErroDeConversaoDeAnoException("Não foi possível converter o ano. Mais de 4 caracteres");
        }
        this.anoLancamento = Integer.parseInt(tituloOmdb.year());
        this.duracaoEmMinutos = Integer.parseInt(tituloOmdb.runtime().substring(0,2));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public int getSomaDasNotas() {
        return somaDasNotas;
    }

    public int getTotalAvalicao() {
        return totalAvalicao;
    }

    public void avalia(int nota) {
        somaDasNotas += nota;
        totalAvalicao++;
    }

    public void imprimirFicha() {
        System.out.println("Nome: " + nome);
        System.out.println("Ano de Lançamento: " + anoLancamento);
    }


    @Override
    public int getTempo() {
        return this.getDuracaoEmMinutos();
    }


    // Implementando o método da interface Comparable<>
    @Override
    public int compareTo(Titulo outroTitulo) {
        // compareTo é um método que JÁ EXISTE e é capaz de ordenar alfabeticamente,
        // não precisamos reinventar roda
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", anoLancamento=" + anoLancamento +
                ", duracaoEmMinutos=" + duracaoEmMinutos +
                '}';
    }
}
