import java.util.ArrayDeque;

public class Exercicio4 {

    public static void main(String[] args) {

        int repeticoes = 3;

        long somaArray = 0;
        long somaLista = 0;
        long somaDeque = 0;

        for (int i = 0; i < repeticoes; i++) {
            somaArray += medir(() -> {
                PilhaArray<Integer> p = new PilhaArray<>();
                for (int j = 0; j < 1_000_000; j++) {
                    p.push(j);
                    p.pop();
                }
            });

            somaLista += medir(() -> {
                PilhaLista<Integer> p = new PilhaLista<>();
                for (int j = 0; j < 1_000_000; j++) {
                    p.push(j);
                    p.pop();
                }
            });

            somaDeque += medir(() -> {
                ArrayDeque<Integer> d = new ArrayDeque<>();
                for (int j = 0; j < 1_000_000; j++) {
                    d.push(j);
                    d.pop();
                }
            });
        }

        System.out.printf("PilhaArray:  %.2f ms%n", (somaArray / repeticoes) / 1e6);
        System.out.printf("PilhaLista:  %.2f ms%n", (somaLista / repeticoes) / 1e6);
        System.out.printf("ArrayDeque:  %.2f ms%n", (somaDeque / repeticoes) / 1e6);
    }

    static long medir(Runnable tarefa) {
        tarefa.run(); // aquecimento (JIT)
        long inicio = System.nanoTime();
        tarefa.run();
        return System.nanoTime() - inicio;
    }
}