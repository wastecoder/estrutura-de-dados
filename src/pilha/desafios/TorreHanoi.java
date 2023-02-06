package pilha.desafios;

import java.util.Stack;

public class TorreHanoi {
    public static void main(String[] args) {
        Stack<Integer> torre1 = new Stack<>();
        Stack<Integer> torre2 = new Stack<>();
        Stack<Integer> torre3 = new Stack<>();

        int quantidadeDisco = 3;
        for (int i = quantidadeDisco; i > 0; i--) {
            torre1.push(i);
        }

        resolverTorre(quantidadeDisco, torre1, torre2, torre3);
    }

    public static void resolverTorre(int quantidadeInicial, Stack<Integer> origem, Stack<Integer> destino, Stack<Integer> auxiliar) {
        if (quantidadeInicial > 0) {
            resolverTorre(quantidadeInicial - 1, origem, auxiliar, destino);
            destino.push(origem.pop());

            System.out.println("\n+=================================+");
            System.out.println("TORRE 1: " + origem);
            System.out.println("TORRE 2: " + destino);
            System.out.println("TORRE 3: " + auxiliar);
            System.out.println("+=================================+\n");

            resolverTorre(quantidadeInicial - 1, auxiliar, destino, origem);
        }
    }
}
