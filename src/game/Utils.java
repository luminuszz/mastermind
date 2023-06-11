package game;

import java.util.Random;

public class Utils {

    public static int[] generateRandomSequence(int range, int maxNumber) {

        Random random = new Random();

        int[] sequence = new int[range];

        for (int i = 0; i < range; i++) {
            sequence[i] = random.nextInt(maxNumber) + 1;
        }
        return sequence;

    }


    public static boolean estaDentroDaLista(int[] lista, int element) {
        for (int i : lista) {
            if (i == element) {
                return true;
            }
        }
        return false;
    }

}
