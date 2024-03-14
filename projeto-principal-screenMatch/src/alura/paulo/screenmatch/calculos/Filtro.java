package alura.paulo.screenmatch.calculos;

/*
 * Classe responsável por filtrar um item classíficavel.
 * */

public class Filtro {
    // Utilizando da abstração para tornar o código mais coeso e elegante
    public void filtrar(Classificavel classificavel) {
        if (classificavel.getClassificacao() > 4) {
            System.out.println("Recomendado");
        } else {
            System.out.println("Não recomendado");
        }
    }
}
