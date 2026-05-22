
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercicio1Test {

    // Caso normal
    @Test
    void deveInverterTextoNormal() {
        String resultado = Exercicio1.inverter("IFTM");
        assertEquals("MTFI", resultado);
    }

    // Caso de borda
    @Test
    void deveRetornarStringVazia() {
        String resultado = Exercicio1.inverter("");
        assertEquals("", resultado);
    }
}