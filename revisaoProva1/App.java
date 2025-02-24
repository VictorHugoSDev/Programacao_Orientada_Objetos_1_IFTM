package revisaoProva1;

import javax.swing.*;

public class App {

    private static double limiteEspecial = 0.0;

    private static ContaCorrente conta;

    public static void main(String[] args) {
        String nome = JOptionPane.showInputDialog("Digite o nome do titular: ");
        String numeroConta = JOptionPane.showInputDialog("Digite o numero da conta: ");
        String tipoConta = JOptionPane.showInputDialog("Digite o tipo da conta: ");
        double saldo = Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo da conta: "));

        if(tipoConta.equalsIgnoreCase("especial")){
            limiteEspecial = Double.parseDouble(JOptionPane.showInputDialog("Digite o limite especial: "));
            conta = new ContaCorrente(nome,numeroConta, saldo, tipoConta);
        }else{
            conta = new ContaCorrente(nome,numeroConta, saldo);
        }

        while(true){
            menu();
        }

    }

    public static void menu(){
        String menu = "0 - Encerrar\n1 - Sacar\n2 - Depositar\n3 - Exibir";
        int escolha = Integer.parseInt((JOptionPane.showInputDialog(menu)));

        switch(escolha){
            case 0:
                JOptionPane.showMessageDialog(null, "Programa encerrado");
                System.exit(0);
                break;
            case 1:
                double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do saque"));
                if(conta.getTipoConta().equals("especial")){
                    double limiteEspecial = Double.parseDouble(JOptionPane.showInputDialog("Digite o limite especial: "));
                    if(conta.sacar(valorSaque, limiteEspecial)){
                        JOptionPane.showMessageDialog(null, "Saque realizado com sucesso.");
                    }else{
                        JOptionPane.showMessageDialog(null, "Saldo insuficiente para saque com limite especial.");
                    }
                }else{
                    if(conta.sacar(valorSaque)){
                        JOptionPane.showMessageDialog(null, "Saque realizado com sucesso.");
                    }else{
                        JOptionPane.showMessageDialog(null,"Saldo insuficiente para saque.");
                    }
                }
                break;
            case 2:
                double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a depositar:"));
                conta.Depositar(valorDeposito);
                JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso.");
                break;
            case 3:
                exibir();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida");
                break;
        }

    }

    public static void exibir(){
        StringBuilder info = new StringBuilder();
        info.append("Nome: ").append(conta.getNome()).append("\n");
        info.append("Número da Conta: ").append(conta.getNumeroConta()).append("\n");
        info.append("Tipo de Conta: ").append(conta.getTipoConta().equalsIgnoreCase("especial") ? "especial" : "comum").append("\n");
        if (conta.getTipoConta().equalsIgnoreCase("especial")){
            info.append("Limite: R$").append(String.format("%.2f", limiteEspecial)).append("\n");
        }
        info.append("Saldo: R$").append(String.format("%.2f", conta.getSaldo()));
        JOptionPane.showMessageDialog(null, info.toString());
    }
}
