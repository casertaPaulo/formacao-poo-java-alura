package alura.paulo.consultacep;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.util.List;

/*
* Classe responsável por gerar arquivos.
* */

public class GeradorDeArquivo {
    // Método que grava uma lista de CEPs em formato JSON em um arquivo JSON.
    public void gerarArquivo(List<Localidade> localidade) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            FileWriter fileWriter = new FileWriter("ceps.json");
            fileWriter.write(gson.toJson(localidade));
            fileWriter.close();

            System.out.println("Arquivo gravado com sucesso.");
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível de gravar o arquivo.");
        }

    }
}
