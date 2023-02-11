package estruturasprontas;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> primos = new LinkedList<>();

        primos.add(3);
        primos.add(5);
        primos.add(11);
        primos.add(0, 2);
        primos.add(3, 7);
        System.out.println("Lista: " + primos);

        System.out.println("\n1� item (antes): " + primos.get(0));
        primos.set(0, 17);
        System.out.println("1� item (depois): " + primos.getFirst());

        primos.add(17);
        primos.add(17);
        primos.add(17);
        primos.remove(primos.getFirst()); //Remove s� o primeiro 17
        System.out.println("\nLista: " + primos);
        primos.removeAll(List.of(17)); //Remove todos os 17
        System.out.println("Lista: " + primos);

        System.out.println("\nTamanho: " + primos.size());
        System.out.println("Primeiro: " + primos.getFirst());
        System.out.println("�ltimo: " + primos.getLast());
        System.out.println("Possui 17? " + primos.contains(17));
        System.out.println("Est� vazia? " + primos.isEmpty());

        primos.clear();
        System.out.println("\nLista: " + primos);
    }
}
