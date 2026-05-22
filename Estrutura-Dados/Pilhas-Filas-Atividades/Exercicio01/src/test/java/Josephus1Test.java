import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Josephus1Test {

    @Test
    void casoClassico() {
        assertEquals(3, Josephus1.josephus(7, 3));
    }

    @Test
    void casoSimples() {
        assertEquals(4, Josephus1.josephus(6, 2));
    }

    @Test
    void casoBordaUmaPessoa() {
        assertEquals(0, Josephus1.josephus(1, 5));
    }

    @Test
    void kIgual1() {
        assertEquals(4, Josephus1.josephus(5, 1));
    }

    @Test
    void deveLancarErro() {
        assertThrows(IllegalArgumentException.class, () -> {
            Josephus1.josephus(0, 3);
        });
    }
}