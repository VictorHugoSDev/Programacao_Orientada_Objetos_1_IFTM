import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int[][] tabuleiro = new int[3][3];

    public static void main(String[] args) {
        preencherMatriz();
        int jogador =  1;
        int jogadas = 0;

        while(!empate() && !vitoria()){
            int jogada = jogoDaVelha(jogador);
            int linha = (jogada - 1) / 3;
            int coluna = (jogada - 1) % 3;
            tabuleiro[linha][coluna] = jogador;
            jogadas++;

            if(vitoria()){
                exibirTabuleiro();
                exibeFim(jogadas);
                break;
            }
            if(empate()){
                exibirTabuleiro();
                System.out.println("Velha!");
                break;
            }

            jogador = (jogador == 1) ? 2 : 1;
        }

    }

    static int jogoDaVelha(int jogador){
        System.out.println("Tabuleiro Atual: ");
        exibirTabuleiro();
        System.out.printf("Jogador \"%d\" é sua vez de jogar!\n", jogador);
        System.out.println();

        int jogada = 0;
        boolean entradaValida = false;

        while(!entradaValida){
            System.out.print("Escolha uma posição (1-9): ");
            if(scanner.hasNextInt()){
                jogada = scanner.nextInt();
                entradaValida = validacao(jogada);
            }
            else{
                System.out.println("Entrada inválida! Por favor, digitar um número entre 1 e 9.");
                scanner.next();
            }
        }

        return jogada;
    }

    static void preencherMatriz(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = 0;
            }
        }
    }

    static void exibirTabuleiro(){
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                char alterarChar = tabuleiro[i][j] == 1 ? 'X' : (tabuleiro[i][j] == 2 ? 'O' : ' ');
                System.out.print(" " + alterarChar + " |");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    static boolean validacao(int jogada){
        if(jogada < 1 || jogada > 9){
            System.out.println("Jogada inválida! Escolha uma posição válida, entre 1 e 9.");
            return false;
        }

        int linha = (jogada - 1) / 3;
        int coluna = (jogada - 1) % 3;

        if(tabuleiro[linha][coluna] == 0){
            return true;
        } else{
            restricao();
            return false;
        }
    }

    static void restricao(){

        System.out.println("Posição já preenchida! Escolha outra.");
    }

    static boolean empate(){
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(tabuleiro[i][j] == 0){
                    return false;
                }
            }
        }
        return !vitoria();
    }

    static boolean vitoria(){
        for(int i = 0; i < 3; i++) {
            if(tabuleiro[i][0] != 0 && tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]){
                return true; // vitoria por linha
            }
            if (tabuleiro[0][i] != 0 && tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i]){
                return true; // vitoria por coluna
            }
        }
        if (tabuleiro[0][0] != 0 && tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) {
            return true; // vitoria diagonal (esquerda para direita)
        }
        if (tabuleiro[0][2] != 0 && tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {
            return true; // vitoria diagonal (direita para esquerda)
        }
        return false; // Não há vencedor
    }

    static void exibeFim(int jogadas){
        if(vitoria()){
            System.out.println();
            System.out.println("Vitória do jogador: " + ((jogadas % 2 == 0) ? 2 : 1) + "!");
        }
    }
}
