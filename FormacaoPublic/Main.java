import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = lePessoa();
        Formacao formacao = leFormacao();

        JOptionPane.showMessageDialog(null, pessoa.exibe());
        JOptionPane.showMessageDialog(null, formacao.exibe());
    }

    public static Pessoa lePessoa(){
        String nome = JOptionPane.showInputDialog(null, "Digite o nome");

        String sexoInput = JOptionPane.showInputDialog(null, "Digite o sexo (Masculino/Feminino)");
        char sexo = sexoInput.charAt(0);

        int idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a idade"));

        return new Pessoa(nome, sexo, idade);
    }

    public static Formacao leFormacao(){
        String nivel = JOptionPane.showInputDialog(null, "Digite o nivel de formação");

        String concluidoInput = JOptionPane.showInputDialog(null, "Está concluído (sim/não)");
        Boolean concluido = concluidoInput.equals("sim");

        String instituicao = JOptionPane.showInputDialog(null, "Digite a instituição");

        int ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a ano de conclusão"));

        return new Formacao(nivel, concluido, instituicao, ano);
    }
}
