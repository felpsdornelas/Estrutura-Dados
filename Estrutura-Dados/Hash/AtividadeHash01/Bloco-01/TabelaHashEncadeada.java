import java.util.LinkedList;
import java.util.Objects;

public class TabelaHashEncadeada<K, V> {

    private static final int CAPACIDADE_PADRAO = 16;

    private LinkedList<Entrada<K, V>>[] buckets;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public TabelaHashEncadeada(int capacidade) {

        buckets = new LinkedList[capacidade];

        for (int i = 0; i < capacidade; i++) {
            buckets[i] = new LinkedList<>();
        }

        this.tamanho = 0;
    }

    public TabelaHashEncadeada() {
        this(CAPACIDADE_PADRAO);
    }

    // Retorna o índice do bucket para a chave k.
    // Trate k == null explicitamente.
    private int indiceBucket(K k) {

        if (k == null) {
            throw new IllegalArgumentException("Chave não pode ser null");
        }

        return Math.abs(k.hashCode()) % buckets.length;
    }

    // Insere ou atualiza o par (chave, valor).
    // Se a chave já existir, substitui o valor e NÃO incrementa tamanho.
    public void put(K chave, V valor) {

        int indice = indiceBucket(chave);

        LinkedList<Entrada<K, V>> bucket = buckets[indice];

        for (Entrada<K, V> entrada : bucket) {

            if (Objects.equals(entrada.chave, chave)) {

                entrada.valor = valor;
                return;
            }
        }

        bucket.add(new Entrada<>(chave, valor));
        tamanho++;
    }

    // Retorna o valor associado à chave, ou null se não encontrado.
    public V get(K chave) {

        int indice = indiceBucket(chave);

        LinkedList<Entrada<K, V>> bucket = buckets[indice];

        for (Entrada<K, V> entrada : bucket) {

            if (Objects.equals(entrada.chave, chave)) {
                return entrada.valor;
            }
        }

        return null;
    }

    // Remove o par com a chave dada.
    // Retorna true se removido, false se não encontrado.
    public boolean remove(K chave) {

        int indice = indiceBucket(chave);

        LinkedList<Entrada<K, V>> bucket = buckets[indice];

        for (Entrada<K, V> entrada : bucket) {

            if (Objects.equals(entrada.chave, chave)) {

                bucket.remove(entrada);
                tamanho--;

                return true;
            }
        }

        return false;
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    // Classe interna de entrada
    private static class Entrada<K, V> {

        K chave;
        V valor;

        Entrada(K chave, V valor) {
            this.chave = chave;
            this.valor = valor;
        }
    }
}