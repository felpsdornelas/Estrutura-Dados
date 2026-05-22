public interface Fila<T> {
    void enqueue(T elemento);
    T dequeue();
    T peek();
    boolean isEmpty();
    int size();
}