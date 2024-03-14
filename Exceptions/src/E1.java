import java.util.Scanner;

/*
* Crie um programa simples que solicita dois números ao usuário e realiza a divisão do primeiro pelo segundo.
* Utilize o bloco try/catch para tratar a exceção que pode ocorrer caso o usuário informe 0 como divisor.
* */

public class E1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o dividendo: ");
        int dividendo = scanner.nextInt();

        System.out.print("Digite o divisor: ");
        int divisor = scanner.nextInt();

        // Tentando fazer a divisão.
        try {
            System.out.println("Resultado: " + (dividendo / divisor));
        } catch (ArithmeticException e) { // Capturando a exceção.
            System.out.println("Erro: Divisão por 0 não permitido");
        }


    }
}