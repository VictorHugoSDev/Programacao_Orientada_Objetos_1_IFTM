// Quando colocamos o atributo como private,  ele passa a ser exclusivo da classe JogadorDeFutebol, não podendo
// ser utilizado na class Main passando a dar erro. Para solucionar o problema devemos utilizar o metodo de get/set
// para poder estar utilizando o atributo em outra classe.
// Nesse caso que o nome esta como private, no metodo aposentarJogador no main em vez usarmos jogadorFutebol.nome,
// deve ser utilizar o getNome(), metodo criado para isso.

// Getter: Um metodo que permite acessar o valor de um atributo privado.
// Setter: Um metodo que permite modificar o valor de um atributo privado.

import java.time.LocalDate;

public class JogadorDeFutebol {
    private String nome;
    public String posicao;
    public int anoNascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String nacionalidade;
    public float altura;
    public float peso;

    public JogadorDeFutebol(String nome, String posicao, int anoNascimento, String nacionalidade,
                            float altura, float peso) {
        this.nome = nome;
        this.posicao = posicao;
        this.anoNascimento = anoNascimento;
        this.nacionalidade = nacionalidade;
        this.altura = altura;
        this.peso = peso;
    }

    public int calculaIdade(){
        LocalDate hoje = LocalDate.now();

        return hoje.getYear() - anoNascimento;
    }

    public String exibe(){
        return "Nome: " + nome + "\n" +
        "Ano de Nascimento: " + anoNascimento + "\n" +
        String.format("Altura: %.2f m\n", altura) +
        String.format("Peso: %.2f kg\n",peso) +
        "Nacionalidade: " + nacionalidade + "\n" +
        "Posição: " + posicao;
    }
}
