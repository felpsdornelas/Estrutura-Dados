

public class Exercicio1 {

    public static String inverter(String texto) {
        Pilha<Character> pilha = new PilhaArray<>();

        // Passo 1: empilhar cada caractere
        for (int i = 0; i < texto.length(); i++) {
            pilha.push(texto.charAt(i));
        }

        // Passo 2: desempilhar e montar a string invertida
        String resultado = "";
        while (!pilha.isEmpty()) {
            resultado += pilha.pop();
        }

        return resultado;
    }
}