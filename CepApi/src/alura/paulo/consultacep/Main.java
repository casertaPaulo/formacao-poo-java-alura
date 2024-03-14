package alura.paulo.consultacep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Instânciando a entrada de dados
        Scanner scanner = new Scanner(System.in);

        // Criando a lista de CEPs
        List<Localidade> lista = new ArrayList<>();

        // Instânciando as classes especialistas.
        ConsultaCep consultaCep = new ConsultaCep();
        GeradorDeArquivo gerador = new GeradorDeArquivo();

        System.out.println("Quantos CEPs deseja salvar: ");
        int qtdCep = scanner.nextInt();

        scanner.nextLine();

        // Capturando os CEPs
        for (int i = 0; i < qtdCep; i++) {
                System.out.println("Digite o CEP: ");
                String cep = scanner.nextLine();
            try {
                Localidade localidade = consultaCep.consultar(cep);
                lista.add(localidade);

                System.out.println(localidade);

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Saindo...");
            }
        }

        // Gerando o arquivo JSON com os CEPs
        gerador.gerarArquivo(lista);
    }
}