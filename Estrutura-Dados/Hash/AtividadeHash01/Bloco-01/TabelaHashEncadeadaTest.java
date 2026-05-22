import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TabelaHashEncadeadaTest {

    private TabelaHashEncadeada<String, Integer> tabela;

    @BeforeEach
    void setUp() {
        tabela = new TabelaHashEncadeada<>(4);
    }

    @Test
    @DisplayName("put e get: chave inserida deve ser recuperada")
    void testPutGet() {

        tabela.put("produto-42", 100);

        Integer valor = tabela.get("produto-42");

        assertEquals(100, valor);
    }

    @Test
    @DisplayName("put com atualização: tamanho não deve aumentar")
    void testAtualizacaoNaoIncrementaTamanho() {

        tabela.put("produto", 10);
        tabela.put("produto", 50);

        assertEquals(1, tabela.tamanho());
        assertEquals(50, tabela.get("produto"));
    }

    @Test
    @DisplayName("colisão: duas chaves no mesmo bucket devem ser recuperadas corretamente")
    void testColisao() {

        tabela.put("A", 1);
        tabela.put("E", 2);

        assertEquals(1, tabela.get("A"));
        assertEquals(2, tabela.get("E"));
    }
}