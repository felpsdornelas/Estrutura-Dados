public class Josephus1 {

    public static int josephus(int n, int k) {

        if (n <= 0 || k <= 0) {
            throw new IllegalArgumentException("n e k devem ser maiores que zero");
        }

        ListaCircular<Integer> circulo = new ListaCircular<>();

        for (int i = 0; i < n; i++) {
            circulo.adicionar(i);
        }

        while (circulo.tamanho() > 1) {

            for (int i = 0; i < k - 1; i++) {
                circulo.girar();
            }

            circulo.removerInicio();
        }

        return circulo.primeiro();
    }
}