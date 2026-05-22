import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Exercicio3Test {

    // Caso normal
    @Test
    void deveRespeitarFIFO() {
        Exercicio3<Integer> fila = new Exercicio3<>();

        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);

        assertEquals(1, fila.dequeue());
        assertEquals(2, fila.dequeue());
        assertEquals(3, fila.dequeue());
    }

    // Caso de borda
    @Test
    void deveLancarErroAoRemoverFilaVazia() {
        Exercicio3<Integer> fila = new Exercicio3<>();

        assertThrows(java.util.NoSuchElementException.class, () -> {
            fila.dequeue();
        });
    }

}