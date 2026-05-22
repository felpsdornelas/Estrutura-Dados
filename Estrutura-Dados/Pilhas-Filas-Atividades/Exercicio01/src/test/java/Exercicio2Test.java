import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Exercicio2Test {

    // Caso normal
    @Test
    void deveAvaliarExpressaoSimples() {
        double resultado = Exercicio2.avaliarPosFixa("3 4 +");
        assertEquals(7.0, resultado);
    }

    // Caso normal mais complexo
    @Test
    void deveAvaliarExpressaoComplexa() {
        double resultado = Exercicio2.avaliarPosFixa("5 1 2 + 4 * + 3 -");
        assertEquals(14.0, resultado);
    }

    // Caso de borda (módulo)
    @Test
    void deveCalcularModulo() {
        double resultado = Exercicio2.avaliarPosFixa("10 3 %");
        assertEquals(1.0, resultado);
    }

    // Caso de erro
    @Test
    void deveLancarErroDivisaoPorZero() {
        assertThrows(ArithmeticException.class, () -> {
            Exercicio2.avaliarPosFixa("10 0 /");
        });
    }
}