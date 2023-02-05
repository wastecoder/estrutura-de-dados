package pilha.desafios;

import java.util.Stack;

public class Palindromo {
    public static void main(String[] args) {
        exibirResultado("1234321");
        exibirResultado("Ana");
        exibirResultado("ararA");
        exibirResultado("Luz azul");
        exibirResultado("Amor a roma");

        exibirResultado("Ovoo");
        exibirResultado("Radaar");
    }

    public static void exibirResultado(String palavra) {
        String resultado = verificaPalindromo(palavra) ? "Sim" : "Não";
        System.out.println("[" + palavra + "] é palíndromo? " + resultado);
    }

    public static boolean verificaPalindromo(String palavra) {
        Stack<Character> letras = new Stack<>();

        palavra = palavra.replaceAll("\\s", "");
        for (int i = 0; i < palavra.length(); i++) {
            letras.push(palavra.charAt(i));
        }

        String palavraInversa = "";
        for (int j = 0; j < palavra.length(); j++) {
            palavraInversa += letras.pop();
        }

        return palavra.equalsIgnoreCase(palavraInversa);
    }
}
