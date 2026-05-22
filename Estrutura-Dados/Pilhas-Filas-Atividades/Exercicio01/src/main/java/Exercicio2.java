public class Exercicio2 {

public static double avaliarPosFixa(String expressao) {
    Pilha<Double> pilha = new PilhaArray<>();

    for (String token : expressao.split(" ")) {

        switch (token) {

            case "+":
                double bSoma = pilha.pop();
                double aSoma = pilha.pop();
                pilha.push(aSoma + bSoma);
                break;

            case "-":
                double bSub = pilha.pop();
                double aSub = pilha.pop();
                pilha.push(aSub - bSub);
                break;

            case "*":
                double bMul = pilha.pop();
                double aMul = pilha.pop();
                pilha.push(aMul * bMul);
                break;

            case "/":
                double bDiv = pilha.pop();
                double aDiv = pilha.pop();
                if (bDiv == 0) {
                    throw new ArithmeticException("Divisão por zero");
                }
                pilha.push(aDiv / bDiv);
                break;

            case "%":
                double bMod = pilha.pop();
                double aMod = pilha.pop();
                pilha.push(aMod % bMod);
                break;

            default:
                pilha.push(Double.parseDouble(token));
                break;
        }
    }

    return pilha.pop();
}
}