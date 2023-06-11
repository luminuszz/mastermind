package game;

import java.util.Arrays;

public class Mastermind extends GameUi {

    private final int tamanho;
    private final int numeroMaximo;
    private final int maxTentativas;
    private final int tentativaAtual;
    private int[] sequencia;


    private boolean terminado;
    private boolean venceu;

    private int numCorretos;
    private int numPosicaoCorreta;


    public int getTamanho() {
        return tamanho;
    }

    public int getNumeroMaximo() {
        return numeroMaximo;
    }

    public int getMaxTentativas() {
        return maxTentativas;
    }

    public int getTentativaAtual() {
        return tentativaAtual;
    }

    public int[] getSequencia() {
        return sequencia;
    }

    public boolean isTerminado() {
        return terminado;
    }

    public boolean isVenceu() {
        return venceu;
    }


    public Mastermind(int tamanho, int numeroMaximo, int maxTentativas) {
        this.tamanho = tamanho;
        this.numeroMaximo = numeroMaximo;
        this.maxTentativas = maxTentativas;
        this.tentativaAtual = 1;
        this.sequencia = Utils.generateRandomSequence(tamanho, numeroMaximo);
        this.terminado = false;
        this.venceu = false;
    }


    public void mostrarFeedback() {
        this.showMessage("Números de elementos corretos: " + numCorretos);
        this.showMessage("Números de elementos corretos na posição correta: " + numPosicaoCorreta);
    }


    public void makeTentativa(int[] palpite) {
        this.numCorretos = 0;
        this.numPosicaoCorreta = 0;

        for (int i = 0; i < tamanho; i++) {
            if (palpite[i] == sequencia[i]) {
                numPosicaoCorreta++;
            } else if (Utils.estaDentroDaLista(sequencia, palpite[i])) {
                numCorretos++;
            }
        }

        if (numPosicaoCorreta == tamanho) {
            this.terminado = true;
            this.venceu = true;
        } else if (tentativaAtual == maxTentativas) {
            this.terminado = true;
        }

        this.tentativaAtual++;
    }


    @Override
    public void initGame() {

        this.showMessage("Iniciando o jogo MasterMind");

        while (!this.isTerminado()) {
            System.out.println("\nTentativa " + this.getTentativaAtual() + " de " + this.getMaxTentativas());
            System.out.print("Digite uma sequência de " + this.getTamanho() + " números (separados por espaço): ");
            int[] palpite = new int[tamanho];
            for (int i = 0; i < tamanho; i++) {
                palpite[i] = this.getIntParam();
            }
            this.makeTentativa(palpite);
            this.mostrarFeedback();
        }

        System.out.println("\nFim do jogo!");
        if (this.isVenceu()) {
            System.out.println("Parabéns, você venceu!");
        } else {
            System.out.println("Você perdeu! A sequência correta era: " + Arrays.toString(this.getSequencia()));
        }


    }
}