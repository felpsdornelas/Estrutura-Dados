

public class PilhaArray<T> implements Pilha<T> {

    private Object[] elementos;
    private int topo;

    public PilhaArray() {
        elementos = new Object[100]; // tamanho fixo simples
        topo = -1;
    }

    @Override
    public void push(T elemento) {
        topo++;
        elementos[topo] = elemento;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha vazia");
        }
        T elemento = (T) elementos[topo];
        topo--;
        return elemento;
    }

    @Override
    public boolean isEmpty() {
        return topo == -1;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Pilha vazia");
        return (T) elementos[topo];
    }

    public int size() {
        return topo + 1;
    }
}