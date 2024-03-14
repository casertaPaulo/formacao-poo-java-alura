package alura.paulo.modelo;

public class Pessoa {
    private String nome;
    private int idade;
    private String cidade;

    public Pessoa(PessoaRecord pessoaRecord) {
        this.nome= pessoaRecord.nome();
        this.idade = Integer.parseInt(pessoaRecord.idade());
        this.cidade = pessoaRecord.cidade();
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCidade() {
        return cidade;
    }

    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
