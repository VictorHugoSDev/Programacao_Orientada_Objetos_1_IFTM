import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        int confirm;
        do {
            double a = 0;

            while(true){
                a = le(1);

                if(a != 0){
                    break;
                }
                JOptionPane.showMessageDialog(null, "O valor de A não pode ser zero.");
            }

            double b = le(2);
            double c = le(3);

            EGrau2 equacao = new EGrau2(a, b, c);
            double delta = equacao.delta();

            if (delta < 0) {
                JOptionPane.showMessageDialog(null, "Erro, não é possível calcular as raízes reais");
            } else {
                double x1 = equacao.calculaX1(delta);
                double x2 = equacao.calculaX2(delta);
                String mensagem = exibe(x1, x2);
                JOptionPane.showMessageDialog(null, mensagem);
            }
            confirm = JOptionPane.showConfirmDialog(null, "Deseja resolver uma nova equação do segundo grau?", "Calcular Novamente", JOptionPane.YES_NO_OPTION);
        }
        while(confirm == JOptionPane.YES_OPTION);
        JOptionPane.showMessageDialog(null,"FIM DO PROGRAMA");
    }

    public static double le(int coeficiente) {
        String input = "";

        if(coeficiente == 1) {
           input = JOptionPane.showInputDialog(null, "Digite o valor A, o valor deve ser diferente de zero");
        }
        else if(coeficiente == 2) {
            input = JOptionPane.showInputDialog(null, "Digite o valor B");
        }
        else if(coeficiente == 3) {
            input = JOptionPane.showInputDialog(null, "Digite o valor C");
        }
        return Double.parseDouble(input);
    }

    public static String exibe(double x1, double x2){
        return "As raízes são X1 = " +  x1 + ", X2 = " + x2;
    }
}
