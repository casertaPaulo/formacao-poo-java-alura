
/*
* Defina uma classe chamada Titulo com os atributos necessários. Em seguida, crie um
* programa que instancia um objeto Titulo, serializa esse objeto para JSON usando a biblioteca
* Gson e imprime o resultado.
*
* */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

class Titulo {
    private String nome;
    private int year;
    private int duration;

    public Titulo(String nome, int year, int duration) {
        this.nome = nome;
        this.year = year;
        this.duration = duration;
    }

    public String getNome() {
        return nome;
    }

    public int getYear() {
        return year;
    }

    public int getDuration() {
        return duration;
    }
}


public class E2 {
    public static void main(String[] args) {
        Titulo novoTitulo = new Titulo("Matrix", 2000, 120);

        // setPrettyPrinting(): Imprime o json de forma mais elegante
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(novoTitulo);

        System.out.println(json);

        try {
            FileWriter fileWriter = new FileWriter("title_json.json");
            fileWriter.write(json);
            fileWriter.close();

            System.out.println("Arquivo escrito.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
