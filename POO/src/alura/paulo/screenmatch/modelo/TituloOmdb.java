package alura.paulo.screenmatch.modelo;


/*
* O objetivo desta classe é simplesmente ser o intermediador entre o JSON e o objeto Titulo de nossa
* aplicação. Essa classe traduz o JSON para um objeto "TituloOmdb", que possui somente três atributos.
*
* Uma classe Record é uma estrutura nova em Java que permite declarar somente o cabeçalho dos atributos,
* tornando a classe imutável.
*
* Após haver um objeto TituloOmdb com os dados do JSON, nós passamos esse objeto como parâmetro para um
* construtor da nossa classe Titulo, fazendo assim, a conversão entre um objeto do tipo TituloOmdb para um
* Titulo.
*
* Podemos dizer que a classe TituloOmdb é temporária e serve somente para fazer a tradução do objeto JSON.
*
* Essa é uma melhor maneira de fazer essa tradução, tendo em vista que utilizar as anotações @SerializationName
* pode ser ruim pela falta de flexibilidade e possibilidadde de ter que trocar o nome caso seja necessário.
*
*
* */
public record TituloOmdb(String title, String year, String runtime) {
}
