import alura.paulo.exception.ErroConsultaGitHub;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

/*
* Desenvolva um programa em Java que permite aos usuários consultar informações sobre um usuário do GitHub
* (utilize a API pública do GitHub para obter os dados). Crie uma classe de exceção personalizada, ErroConsultaGitHubException,
* que estende RuntimeException. Lance essa exceção quando o nome de usuário não for encontrado. No bloco catch, trate de
* forma específica essa exceção, exibindo uma mensagem amigável.
* */

public class E3 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do perfil: ");
        String perfil = scanner.nextLine();

        String url = "https://api.github.com/users/" + perfil;

        // Tentando fazer a requisição.
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url)).header("Accept", "application/vnd.github.v3+json")
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Verificado se o usuário foi encontrado. 404 -> not found
            if (response.statusCode() == 404) {
                throw new ErroConsultaGitHub("Usuário não encontrado!");
            }

            String json = response.body();

            System.out.println(json);
        } catch (ErroConsultaGitHub e) { // Capturando a exceção.
            System.out.println("Oooops, aconteceu algo inexperado.");
            System.out.println(e.getMessage());
        }
    }

}

