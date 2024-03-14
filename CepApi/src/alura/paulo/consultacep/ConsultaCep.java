package alura.paulo.consultacep;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/*
 * Classe responsável por fazer consultas à API.
 * */

public class ConsultaCep {

    // Método que realiza requisições à API, buscando um CEP específico
    public Localidade consultar(String cep) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/" + cep + "/json/"))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Retornando um objeto Record caso não haja nenhuma exceção.
            return new Gson().fromJson(response.body(), Localidade.class);
        } catch (Exception e) {
            throw new RuntimeException("Ops. Não foi possível consultar a partir desse CEP.");
        }
    }
}
