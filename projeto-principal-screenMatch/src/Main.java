import alura.paulo.screenmatch.calculos.Calculadora;
import alura.paulo.screenmatch.calculos.Filtro;
import alura.paulo.screenmatch.modelo.Episodio;
import alura.paulo.screenmatch.modelo.Filme;
import alura.paulo.screenmatch.modelo.Serie;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Aqui serão rodados os testes!");

        Filme filme = new Filme("Rei Leão", 2019);

        filme.setDiretor("Sei lá");
        filme.setDuracaoEmMinutos(180);
        filme.avalia(10);
        filme.avalia(8);

        Filme filme2 = new Filme("Matrix", 2002);

        filme2.setDiretor("Sei lá");
        filme2.setDuracaoEmMinutos(100);

        filme2.avalia(10);
        filme2.avalia(8);

        Serie serie = new Serie("Supernatural", 2005);
        serie.setTemps(15);
        serie.setEpsPorTemp(20);
        serie.setMinPorEp(60);
        System.out.println(serie.getDuracaoEmMinutos());

        Episodio ep = new Episodio();
        ep.setTempoDoEp(56);

        Calculadora calculadora = new Calculadora();
        calculadora.incluir(filme);
        calculadora.incluir(filme2);
        calculadora.incluir(serie);
        calculadora.incluir(ep);

        System.out.println("Minutos totais: " + calculadora.getTempoTotal());


        ArrayList<Filme> listaDeFilmes = new ArrayList<>();

        listaDeFilmes.add(filme);
        listaDeFilmes.add(filme2);

        System.out.println(listaDeFilmes);

        // Referenciando o objeto "filme" à variável "f1"
        Filme f1 = filme;







    }
}