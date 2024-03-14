import alura.paulo.exception.SenhaInvalidaException;

/*
* Crie um programa que lê uma senha do usuário. Utilize o bloco try/catch para capturar a exceção
* SenhaInvalidaException, uma classe de exceção personalizada que deve ser lançada caso a senha não
* atenda a critérios específicos (por exemplo, ter pelo menos 8 caracteres).
* */

import java.util.Scanner;

public class E2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a senha: ");
        var senha = scanner.nextLine();

        // Tentando validar senha.
        try {
            validarSenha(senha);
        } catch (SenhaInvalidaException e) { // Capturando a exceção lançada e a tratando.
            System.out.println("Erro");
            System.out.println(e.getMessage());
        }
    }

    // Método que valida senha.
    // Caso tamanho menor que 8, é lançado uma exceção
    private static void validarSenha(String senha) {
        if (senha.length() < 8) {
            // Lançando a exceção passando uma mensagem.
            throw new SenhaInvalidaException("A senha deve ter mais de 8 caracteres.");
        } else {
            System.out.println("Senha valida!");
        }
    }
}
