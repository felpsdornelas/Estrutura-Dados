import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TabelaHashAbertaTest {

    @Test
    @DisplayName("rehashing deve ser disparado quando λ >= 0.70")
    void testRehashingDisparado() {

        TabelaHashAberta<Integer, String> tabela =
                new TabelaHashAberta<>(10);

        tabela.put(1, "A");
        tabela.put(2, "B");
        tabela.put(3, "C");
        tabela.put(4, "D");
        tabela.put(5, "E");
        tabela.put(6, "F");
        tabela.put(7, "G");

        // λ = 7 / 10 = 0.70
        // próxima inserção dispara rehash

        tabela.put(8, "H");

        assertEquals(20, tabela.capacidade());
    }

    @Test
    @DisplayName("todos os pares devem ser migrados corretamente após rehash")
    void testMigracaoCorreta() {

        TabelaHashAberta<Integer, String> tabela =
                new TabelaHashAberta<>(4);

        tabela.put(10, "A");
        tabela.put(20, "B");
        tabela.put(30, "C");

        // λ = 3/4 = 0.75 -> próximo put pode disparar rehash

        tabela.put(40, "D");

        assertEquals("A", tabela.get(10));
        assertEquals("B", tabela.get(20));
        assertEquals("C", tabela.get(30));
        assertEquals("D", tabela.get(40));

        assertEquals(4, tabela.tamanho());
    }
}