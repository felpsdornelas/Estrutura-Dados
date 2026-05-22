public class ListaCircular<T> {

    private static class No<T> {
        T valor;
        No<T> proximo;

        No(T valor) {
            this.valor = valor;
        }
    }

    private No<T> atual; // aponta para o "início lógico"
    private int tamanho;

    public ListaCircular() {
        atual = null;
        tamanho = 0;
    }

    // adiciona no final (mantendo circularidade)
    public void adicionar(T valor) {
        No<T> novo = new No<>(valor);

        if (atual == null) {
            atual = novo;
            atual.proximo = atual; // aponta para ele mesmo
        } else {
            No<T> ultimo = atual;

            // encontra o último (que aponta para o atual)
            while (ultimo.proximo != atual) {
                ultimo = ultimo.proximo;
            }

            ultimo.proximo = novo;
            novo.proximo = atual;
        }

        tamanho++;
    }

    // gira a lista (avança o "início")
    public void girar() {
        if (atual != null) {
            atual = atual.proximo;
        }
    }

    // remove o primeiro elemento (atual)
    public void removerInicio() {
        if (atual == null) return;

        if (tamanho == 1) {
            atual = null;
        } else {
            No<T> ultimo = atual;

            // encontra o último
            while (ultimo.proximo != atual) {
                ultimo = ultimo.proximo;
            }

            ultimo.proximo = atual.proximo;
            atual = atual.proximo;
        }

        tamanho--;
    }

    public T primeiro() {
        if (atual == null) throw new RuntimeException("Lista vazia");
        return atual.valor;
    }

    public int tamanho() {
        return tamanho;
    }
}