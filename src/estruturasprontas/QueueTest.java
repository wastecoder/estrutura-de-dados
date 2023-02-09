package estruturasprontas;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        //Instancia uma lista sequencial, mas só vem os métodos de fila (FIFO)
        Queue<Integer> numeros = new LinkedList<>();

        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        System.out.println(numeros);

        System.out.println("Está vazia? " + numeros.isEmpty());
        System.out.println("Tamanho: " + numeros.size());
        System.out.println("Primeiro: " + numeros.peek());

        System.out.println("\nDesenfileirado: " + numeros.remove());
        System.out.println("Desenfileirado: " + numeros.remove());
        System.out.println(numeros);
    }
}
