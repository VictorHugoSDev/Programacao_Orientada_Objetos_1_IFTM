public class Pessoa {
    public String nome;
    public char sexo;
    public int idade;

    public Pessoa(String nome, char sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    }

    public String exibe(){
        return nome + " do sexo " + sexo + " que tem " + idade + " anos";
    }
}
