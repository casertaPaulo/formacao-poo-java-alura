
/*
* Defina uma classe chamada Veiculo com os atributos necessários. Em seguida, crie um programa que
* instancia um objeto Veiculo, serializa esse objeto para JSON usando a biblioteca Gson e
* imprime o resultado.
* */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class Veiculo {
    String nome;
    String marca;
    String cor;

    public Veiculo(String nome, String marca, String cor) {
        this.nome = nome;
        this.marca = marca;
        this.cor = cor;
    }
}

public class E3 {
    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo("Celta", "Chevrolet", "Rosa");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String json = gson.toJson(veiculo);

        System.out.println(json);

        try {
            FileWriter fileWriter = new FileWriter("veiculo.json");
            fileWriter.write(json);
            fileWriter.close();

            System.out.println("Arquivo gravado.");

        } catch (IOException e ) {
            throw new RuntimeException();
        }
    }
}
