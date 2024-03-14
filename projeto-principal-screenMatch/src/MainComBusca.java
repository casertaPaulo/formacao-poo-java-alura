import alura.paulo.screenmatch.excecao.ErroDeConversaoDeAnoException;
import alura.paulo.screenmatch.modelo.Titulo;
import alura.paulo.screenmatch.modelo.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class MainComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        String filme = "";

        List<Titulo> lista = new ArrayList<>();

        // Utilizando o GsonBuilder, nós conseguimos definir algumas confirações do json, como por exemplo,
        // o nome do campo no json. EXEMPLO: Title -> title
        // https://github.com/google/gson/blob/main/UserGuide.md
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();


        while (!filme.equalsIgnoreCase("sair")) {

            System.out.println("Digite o nome do filme: ");
            filme = scanner.nextLine();

            if (filme.equalsIgnoreCase("sair")){
                break;
            }

            String endereco = "https://www.omdbapi.com/?t=" + filme.replace(" ", "+") + "&apikey=269dedd8";


            // Ctrl + Alt + i -> Identação
            try{
                HttpClient client = HttpClient.newHttpClient();

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                // Corpo da resposta da requisição
                String json = response.body();

                System.out.println(json);

                // Criando um objeto TituloOmdb, que apenas recebe esses dados do JSON para a tradução.
                TituloOmdb tituloOmdb = gson.fromJson(json, TituloOmdb.class);


                // O bloco try/catch permite que nós tentemos alguma instrução e caso ocorra alguma excessão,
                // nós a tratamos, fazendo com que o programa não para a execução

                // Criando um objeto Titulo passando um TituloOmdb como parâmetro. (Transfêrencia de dados)
                Titulo meuTitulo = new Titulo(tituloOmdb);

                System.out.println(meuTitulo);

                // Adicinando o tile criado na lista de titulos
                lista.add(meuTitulo);

            } catch (NumberFormatException e) {
                // Capturando caso ocorra o erro e imprime na tela, evitando o encerramento do programa
                System.out.println("Erro: " + e.getMessage());
            } catch (IllegalArgumentException e ) {
                System.out.println("Erro na busca, caractere inválido. ");
            } catch (ErroDeConversaoDeAnoException e ) {
                System.out.println(e.getMessage());
            }

        }


        System.out.println("O programa não foi encerrado!");
        System.out.println(lista);

        // Escrevendo o arquivo JSON com os objetos criados
        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(lista));
        escrita.close();


    }
}
