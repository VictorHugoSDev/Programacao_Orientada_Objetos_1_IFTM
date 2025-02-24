package prog2tratamento;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Prog2Tratamento {

  public static int calculaQuociente(int numerador, int denominador) 
  {
      if(denominador==0)
          throw new ArithmeticException("denominador igual a zero");  
      int r = numerador / denominador;
      return r;
  }
 
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean continua = true;
    do{
          try{
            System.out.print("Numerador: ");
            int numerador = sc.nextInt();
            System.out.print("Denominador: ");
            int denominador = sc.nextInt();
            int resultado = calculaQuociente(numerador, denominador);
            System.out.println("Resultado: "+resultado);
            continua = false;
          } catch (ArithmeticException erro1){
           //   System.err.println("Impossível divisão por zero");
              System.out.println(erro1.getMessage());
          } catch (InputMismatchException erro2) {
              System.err.println("Não é permitido inserir letras, informe apenas números inteiros!  -  "+erro2.getMessage());
           //   System.out.println(erro2.getMessage());
              sc.nextLine(); //descarta a entrada errada do usuário            
          }         
          finally{
              System.out.println("O programa não foi finalizado com a exceção");
          }
    }while(continua);
  }
}

