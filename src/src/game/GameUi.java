package src.game;

import java.util.Scanner;

public abstract class GameUi {

    private final Scanner scanner;


    public GameUi() {

        this.scanner = new Scanner(System.in);


    }


    public void showMessage(String message) {
        System.out.println(message);
    }


    public int getIntParam() {

        return this.scanner.nextInt();
    }


    public abstract void initGame();
}
