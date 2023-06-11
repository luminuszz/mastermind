import game.GameUi;
import game.Mastermind;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // configurando jogo

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Mastermind!");

        System.out.print("Digite o tamanho da sequência (entre 2 e 10): ");
        int tamanho = scanner.nextInt();

        System.out.print("Digite o número máximo para cada posição (entre 1 e 9): ");
        int numeroMaximo = scanner.nextInt();

        System.out.print("Digite o número máximo de tentativas: ");
        int maxTentativas = scanner.nextInt();


        GameUi game = new Mastermind(
                tamanho,
                numeroMaximo,
                maxTentativas
        );


        game.initGame();


    }
}