package estruturasprontas;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> numeros = new Stack<>();

        numeros.push(2);
        numeros.push(3);
        numeros.push(5);
        numeros.push(7);
        System.out.println(numeros);
        System.out.println("Está vazio? " + numeros.isEmpty());
        System.out.println("Tamanho: " + numeros.size());
        System.out.println("Topo: " + numeros.peek());

        System.out.println("\nDesempilhando o elemento: " + numeros.pop());
        System.out.println("Desempilhando o elemento: " + numeros.pop());
        System.out.println(numeros);
    }
}
