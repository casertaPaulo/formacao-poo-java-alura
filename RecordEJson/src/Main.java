import alura.paulo.modelo.Pessoa;
import alura.paulo.modelo.PessoaRecord;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String json = "{\"nome\":\"Paulo Henrique\",\"idade\":20,\"cidade\":\"Brasília\"}";
        String jsonLivro = "{\"titulo\":\"Aventuras do Java\",\"autor\":\"Akemi\",\"editora\":{\"nome\":\"TechBooks\",\"cidade\":\"São Paulo\"}}";

        System.out.println(json);

        Gson gson = new Gson();

        PessoaRecord pessoaRecord = gson.fromJson(json, PessoaRecord.class);

        Pessoa pessoa = new Pessoa(pessoaRecord);

        System.out.println(pessoa);

        System.out.println(jsonLivro);


    }
}