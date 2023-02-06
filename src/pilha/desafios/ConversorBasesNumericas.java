package pilha.desafios;

import java.util.Stack;

public class ConversorBasesNumericas {
    public static void main(String[] args) {
        for (int i = 0; i <= 15; i++) {
            exibirResultado(i, 16);
        }
    }

    public static void exibirResultado(int decimal, int base) {
        System.out.println(decimal + "(10) = " + decimalParaX(decimal, base) + "(" + base + ")");
    }

    public static StringBuilder decimalParaX(int decimal, int x) {
        if (x < 2 || x > 16) {
            throw new IllegalArgumentException("Apenas bases entre 2 e 16 são aceitáveis - base recebida: " + x);
        }

        Stack<Integer> numeros = new Stack<>();
        String algarismos = "0123456789ABCDEF";

        do { //Com while(), 0 volta vazio.
            numeros.push(decimal % x);
            decimal /= x;
        } while (decimal != 0);

        StringBuilder binario = new StringBuilder();
        while (!numeros.isEmpty()) {
            binario.append(algarismos.charAt(numeros.pop()));
        }

        return binario;
    }
}
