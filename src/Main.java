import java.util.*;

public class Main {

    static Scanner scanner;
    static int tamanho;
    static int numeroMaximo;
    static int maxTentativas;
    static int tentativaAtual;
    static int[] sequencia;
    static boolean terminado;
    static boolean venceu;
    static int numCorretos;
    static int numPosicaoCorreta;


    public static int[] generateRandomSequence(int range, int maxNumber) {

        Random random = new Random();

        int[] sequence = new int[range];

        for (int i = 0; i < range; i++) {
            sequence[i] = random.nextInt(maxNumber) + 1;
        }
        return sequence;

    }


    private static void showMessage(String message) {
        System.out.println(message);
    }

    public static void mostrarFeedback() {
        showMessage("Numero corretos: " + numPosicaoCorreta);
        showMessage("Números descolados: " + numCorretos);
    }

    public static boolean estaDentroDaLista(int[] lista, int element) {
        for (int i : lista) {
            if (i == element) {
                return true;
            }
        }
        return false;
    }

    public static void makeTentativa(int[] palpite) {
        numCorretos = 0;
        numPosicaoCorreta = 0;

        List<Integer> numerosEncontrados = new ArrayList<>();

        for (int i = 0; i < tamanho; i++) {

            int numeroAtualDentroDoPalpite = palpite[i];
            int numeroAtualDaSequencia = sequencia[i];

            if (numeroAtualDentroDoPalpite == numeroAtualDaSequencia) {
                numPosicaoCorreta++;
                numerosEncontrados.add(numeroAtualDentroDoPalpite);

            } else if (estaDentroDaLista(sequencia, numeroAtualDentroDoPalpite)) {


                boolean esseNumeroJaFoiEncontrado = numerosEncontrados.contains(numeroAtualDentroDoPalpite);

                if (!esseNumeroJaFoiEncontrado) {
                    numCorretos++;
                }

            }
        }

        if (numPosicaoCorreta == tamanho) {
            terminado = true;
            venceu = true;
        } else if (tentativaAtual == maxTentativas) {
            terminado = true;
        }

        tentativaAtual++;
    }


    public static int getIntParam() {
        return scanner.nextInt();
    }


    public static void initGame() {

        showMessage("Iniciando o jogo MasterMind");

        while (!terminado) {
            System.out.println("\nTentativa " + tentativaAtual + " de " + maxTentativas);
            System.out.print("Digite uma sequência de " + tamanho + " números (separados por espaço): ");
            int[] palpite = new int[tamanho];
            for (int i = 0; i < tamanho; i++) {
                palpite[i] = getIntParam();
            }
            makeTentativa(palpite);
            mostrarFeedback();
        }

        System.out.println("\nFim do jogo!");
        if (venceu) {
            System.out.println("Parabéns, você venceu!");
        } else {
            System.out.println("Você perdeu! A sequência correta era: " + Arrays.toString(sequencia));
        }


    }


    public static void main(String[] args) {
        tamanho = 4;
        numeroMaximo = 9;
        maxTentativas = 5;
        tentativaAtual = 1;
        sequencia = generateRandomSequence(tamanho, numeroMaximo);
        terminado = false;
        venceu = false;
        scanner = new Scanner(System.in);

        initGame();
    }

}