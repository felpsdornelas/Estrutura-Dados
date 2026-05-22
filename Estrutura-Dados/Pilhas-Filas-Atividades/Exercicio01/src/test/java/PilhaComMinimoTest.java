import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PilhaComMinimoTest {

    // Caso normal: verifica min após cada push
    @Test
    void deveAtualizarMinimoACadaPush() {
        PilhaComMinimo<Integer> pilha = new PilhaComMinimo<>();

        pilha.push(5);
        assertEquals(5, pilha.min());

        pilha.push(3);
        assertEquals(3, pilha.min());

        pilha.push(7);
        assertEquals(3, pilha.min());

        pilha.push(2);
        assertEquals(2, pilha.min());
    }

    // Caso normal: verifica min após cada pop
    @Test
    void deveAtualizarMinimoACadaPop() {
        PilhaComMinimo<Integer> pilha = new PilhaComMinimo<>();

        pilha.push(5);
        pilha.push(3);
        pilha.push(7);
        pilha.push(2);

        assertEquals(2, pilha.min());

        pilha.pop(); // remove 2
        assertEquals(3, pilha.min());

        pilha.pop(); // remove 7
        assertEquals(3, pilha.min());

        pilha.pop(); // remove 3
        assertEquals(5, pilha.min());
    }

    // Caso especial: remoção do mínimo
    @Test
    void deveAtualizarMinimoAoRemoverMinimo() {
        PilhaComMinimo<Integer> pilha = new PilhaComMinimo<>();

        pilha.push(10);
        pilha.push(5);
        pilha.push(8);

        assertEquals(5, pilha.min());

        pilha.pop(); // remove 8
        assertEquals(5, pilha.min());

        pilha.pop(); // remove 5 (mínimo)
        assertEquals(10, pilha.min());
    }

    // Caso de borda: um único elemento
    @Test
    void deveFuncionarComUmElemento() {
        PilhaComMinimo<Integer> pilha = new PilhaComMinimo<>();

        pilha.push(42);
        assertEquals(42, pilha.min());

        pilha.pop();
        assertTrue(pilha.isEmpty());
    }
}