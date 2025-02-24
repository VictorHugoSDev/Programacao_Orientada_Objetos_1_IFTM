import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numero1, numero2;

        try{
            System.out.print("Digite o primeiro número:");
            numero1 = scanner.nextInt();
            System.out.print("Digite o segundo número:");
            numero2 = scanner.nextInt();
            System.out.println(numero1/numero2);
        } catch (ArithmeticException e) {
            System.err.println("Por favor, digite um numero diferente de 0");
        } catch (InputMismatchException e) {
            System.err.println("Por favor, digite um '  numero");
        }

    }
}