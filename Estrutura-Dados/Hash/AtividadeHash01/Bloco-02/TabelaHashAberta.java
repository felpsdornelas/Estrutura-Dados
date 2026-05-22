import java.util.Objects;

public class TabelaHashAberta<K, V> {

    // Marcador de slot deletado (lazy deletion)
    private static final Object DELETADO = new Object();

    private static final double LIMIAR_CARGA = 0.70;

    private Object[] chaves;
    private Object[] valores;

    private int tamanho;
    private int capacidade;

    public TabelaHashAberta(int capacidade) {

        this.capacidade = capacidade;

        this.chaves = new Object[capacidade];
        this.valores = new Object[capacidade];

        this.tamanho = 0;
    }

    private int sonda(K chave, int i) {
        return (Math.abs(chave.hashCode()) + i) % capacidade;
    }

    public void put(K chave, V valor) {

        if (chave == null) {
            throw new IllegalArgumentException("Chave não pode ser null");
        }

        // dispara rehash quando λ >= 0.70
        if (fatorDeCarga() >= LIMIAR_CARGA) {
            rehash();
        }

        for (int i = 0; i < capacidade; i++) {

            int idx = sonda(chave, i);

            if (chaves[idx] == null || chaves[idx] == DELETADO) {

                chaves[idx] = chave;
                valores[idx] = valor;

                tamanho++;

                return;
            }

            if (Objects.equals(chaves[idx], chave)) {

                valores[idx] = valor;
                return;
            }
        }

        throw new IllegalStateException("Tabela cheia");
    }

    // dobra capacidade e reinserere todos os pares válidos
    private void rehash() {

        Object[] chavesAntigas = chaves;
        Object[] valoresAntigos = valores;

        capacidade = capacidade * 2;

        chaves = new Object[capacidade];
        valores = new Object[capacidade];

        int tamanhoAntigo = tamanho;

        tamanho = 0;

        for (int i = 0; i < chavesAntigas.length; i++) {

            if (chavesAntigas[i] != null &&
                chavesAntigas[i] != DELETADO) {

                K chave = (K) chavesAntigas[i];
                V valor = (V) valoresAntigos[i];

                put(chave, valor);
            }
        }

        tamanho = tamanhoAntigo;
    }

    public V get(K chave) {

        for (int i = 0; i < capacidade; i++) {

            int idx = sonda(chave, i);

            if (chaves[idx] == null) {
                return null;
            }

            if (Objects.equals(chaves[idx], chave)) {
                return (V) valores[idx];
            }
        }

        return null;
    }

    public double fatorDeCarga() {
        return (double) tamanho / capacidade;
    }

    public int tamanho() {
        return tamanho;
    }

    public int capacidade() {
        return capacidade;
    }
}