import java.util.NoSuchElementException;

public class Exercicio3<T> implements Fila<T> {

    private final PilhaArray<T> entrada = new PilhaArray<>();
    private final PilhaArray<T> saida   = new PilhaArray<>();

    @Override
    public void enqueue(T elemento) {
        entrada.push(elemento);
    }

    @Override
    public T dequeue() {
        transferirSeNecessario();
        if (saida.isEmpty()) throw new NoSuchElementException();
        return saida.pop();
    }

    @Override
    public T peek() {
        transferirSeNecessario();
        if (saida.isEmpty()) throw new NoSuchElementException();
        return saida.peek();
    }

    @Override
    public boolean isEmpty() {
        return entrada.isEmpty() && saida.isEmpty();
    }

    @Override
    public int size() {
        return entrada.size() + saida.size();
    }

    private void transferirSeNecessario() {
        if (saida.isEmpty()) {
            while (!entrada.isEmpty()) {
                saida.push(entrada.pop());
            }
        }
    }
}