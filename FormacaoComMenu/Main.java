import javax.swing.*;

public class Main {
    public static Pessoa pessoa;
    public static Formacao formacao;
    public static void main(String[] args) {
        while(true){
            String menu = "Escolha uma opção \n" +
                          "1. Cadastrar Pessoa\n" +
                          "2. Cadastrar Formação\n" +
                          "3. Exibir \n" +
                          "4. Alterar a idade\n" +
                          "5. Sair";
            String escolha = JOptionPane.showInputDialog(null, menu);

            if (escolha.equals("5")) {
                JOptionPane.showMessageDialog(null, "Fim do programa");
                break;
            }

            switch (escolha){
                case "1":
                    pessoa = lePessoa();
                    JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso!");
                    break;
                case "2":
                    formacao = leFormacao();
                    JOptionPane.showMessageDialog(null, "Formação cadastrada com sucesso!");
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, pessoa != null ? pessoa.exibe() : "Nenhuma pessoa cadastrada");
                    JOptionPane.showMessageDialog(null, formacao != null ? formacao.exibe() : "Nenhuma formação cadastrada");
                    break;
                case "4":
                    if(pessoa == null){
                        JOptionPane.showMessageDialog(null, "Nenhuma pessoa cadastrada");
                        break;
                    }
                    pessoa.idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a nova idade"));
                    JOptionPane.showMessageDialog(null, "Idade alterada com sucesso");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
                    break;
            }
        }

    }

    public static Pessoa lePessoa(){
        String nome = JOptionPane.showInputDialog(null, "Digite o nome");

        String sexoInput = JOptionPane.showInputDialog(null, "Digite o sexo (Masculino/Feminino)");
        char sexo = sexoInput.charAt(0);

        int idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a idade"));

        return new Pessoa(nome, sexo, idade);
    }

    public static Formacao leFormacao() {
        String nivel = JOptionPane.showInputDialog(null, "Digite o nivel de formação");

        String concluidoInput = JOptionPane.showInputDialog(null, "Está concluído (sim/não)");
        Boolean concluido = concluidoInput.equals("sim");

        String instituicao = JOptionPane.showInputDialog(null, "Digite a instituição");

        int ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a ano de conclusão"));

        return new Formacao(nivel, concluido, instituicao, ano);
    }
}
