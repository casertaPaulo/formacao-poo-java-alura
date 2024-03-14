
/*
*
* Crie um programa em Java que escreva a seguinte mensagem em um arquivo chamado
* "arquivo.txt": "Conteúdo a ser gravado no arquivo." Utilize as classes do pacote java.io.
* */


import java.io.FileWriter;
import java.io.IOException;

public class E1 {
    public static void main(String[] args) {

        try {
            FileWriter fileWriter = new FileWriter("exercicio.txt");
            fileWriter.write("Contéudo a ser gravado no arquivo.");
            fileWriter.close();

            System.out.println("Arquivo escrito.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}