import game.GameUi;
import game.Mastermind;

public class Main {
    public static void main(String[] args) {


        int tamanho = 4;
        int numeroMaximo = 9;
        int maxTentativas = 5;


        GameUi game = new Mastermind(
                tamanho,
                numeroMaximo,
                maxTentativas
        );


        game.initGame();


    }
}