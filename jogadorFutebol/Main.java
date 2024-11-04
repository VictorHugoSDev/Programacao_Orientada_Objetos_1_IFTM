import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JogadorDeFutebol jogadordeFutebol = leDados();

        JOptionPane.showMessageDialog(null, jogadordeFutebol.exibe());

        String aposentadoria = tempoAposentadoria(jogadordeFutebol);
        JOptionPane.showMessageDialog(null, aposentadoria);
    }

    public static JogadorDeFutebol leDados(){
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do jogador");

        String posicao = JOptionPane.showInputDialog(null, "Digite a posição do jogador (atacante/defesa/meio de campo)");

        int anoNascimento = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ano de nascimento"));

        String nacionalidade = JOptionPane.showInputDialog(null, "Digite o nacionalidade do jogador");

        float altura = Float.parseFloat(JOptionPane.showInputDialog(null, "Digite a altura do jogador"));

        float peso = Float.parseFloat(JOptionPane.showInputDialog(null, "Digite o peso do jogador"));

        return new JogadorDeFutebol(nome, posicao, anoNascimento, nacionalidade, altura, peso);
    }

    public static String tempoAposentadoria(JogadorDeFutebol jogadorDeFutebol){
        int idadeFaltante = 0;
        int idadeAtual = jogadorDeFutebol.calculaIdade();

        if(jogadorDeFutebol.posicao.equals("atacante")){
            idadeFaltante = 35 - idadeAtual;
        } else if(jogadorDeFutebol.posicao.equals("defesa")){
            idadeFaltante = 40 - idadeAtual;
        } else if(jogadorDeFutebol.posicao.equals("meio de campo")){
            idadeFaltante = 38 - idadeAtual;
        }
        return "Faltam " + idadeFaltante + " anos para o jogador " + jogadorDeFutebol.getNome() + " se aposentar";
    }
}
