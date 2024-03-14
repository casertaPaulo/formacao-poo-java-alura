import alura.paulo.screenmatch.modelo.Filme;
import alura.paulo.screenmatch.modelo.Serie;
import alura.paulo.screenmatch.modelo.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Teste {
    public static void main(String[] args) {
        List<Titulo> lista = new ArrayList<>();

        Filme filme = new Filme("Dogville", 2012);
        filme.avalia(10);
        Filme filme2 = new Filme("Matrix", 2002);
        filme2.avalia(9);
        Serie serie = new Serie("Supernatural", 2005);
        serie.avalia(10);
        Serie serie2 = new Serie("Stranger Things", 2016);
        serie.avalia(10);

        lista.add(filme);
        lista.add(filme2);
        lista.add(serie);
        lista.add(serie2);

        System.out.println(lista);

        for (Titulo item: lista) {
            System.out.println(item);
            if (item instanceof Filme f){
                System.out.println("Estrelas: " + f.getClassificacao());
            }
        }

        // Outro jeito de imprimir
        //lista.forEach(System.out::println);

        ArrayList<String> nomes = new ArrayList<>();

        nomes.add("Paulo");
        nomes.add("Lucas");
        nomes.add("Caleb");
        nomes.add("Pedro");

        Collections.sort(nomes);

        System.out.println(nomes);

        // Com a implementação, podemos utilizar a lista de objetos para ordernar
        Collections.sort(lista);

        System.out.println(lista);

        // Ordenando a lista utilizando o comparator
        // Critério de ordenação: ano de lançamento
        lista.sort(Comparator.comparing(Titulo::getAnoLancamento));
        System.out.println(lista);

    }
}
