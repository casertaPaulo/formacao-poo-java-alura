package alura.paulo.exception;

public class ErroConsultaGitHub extends RuntimeException {

    // Criando uma exceção personalizada para ser lançada
    public ErroConsultaGitHub(String mensagem) {
        super(mensagem);
    }



}
