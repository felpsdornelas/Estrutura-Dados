public class PilhaLista<T> {

    private static class No<T> {
        T valor;
        No<T> proximo;

        No(T valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    private No<T> topo;
    private int tamanho;

    public PilhaLista() {
        topo = null;
        tamanho = 0;
    }

    public void push(T elemento) {
        No<T> novo = new No<>(elemento);
        novo.proximo = topo;
        topo = novo;
        tamanho++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha vazia");
        }
        T valor = topo.valor;
        topo = topo.proximo;
        tamanho--;
        return valor;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha vazia");
        }
        return topo.valor;
    }

    public boolean isEmpty() {
        return topo == null;
    }

    public int size() {
        return tamanho;
    }
}