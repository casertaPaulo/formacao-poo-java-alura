package alura.paulo.consultacep;

/*
 * Classe imutável feita para representar um dado transcrito de um JSON.
 * */

public record Localidade(String localidade, String cep, String uf) {
}
