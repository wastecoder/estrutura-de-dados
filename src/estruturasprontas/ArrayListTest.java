package estruturasprontas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();

        numeros.add(3);
        numeros.add(5);
        numeros.add(7);
        numeros.add(0, 2);
        numeros.add(1, 19);
        numeros.add(2, 17);
        System.out.println("Lista: " + numeros);

        System.out.println("\n1º item (antes): " + numeros.get(0));
        numeros.set(0, 11);
        System.out.println("1º item (depois): " + numeros.get(0) + "\n");

        numeros.add(7); //Há 7 repetido
        numeros.removeAll(List.of(11, 7)); //Esse remove os repetidos. O remove() não.

        Collections.sort(numeros);
        for (int numero : numeros) {
            System.out.print(numero + "; ");
        }

        System.out.println("\n\nTamanho: " + numeros.size());
        System.out.println("Possui 7? " + numeros.contains(7));
        System.out.println("Está vazia? " + numeros.isEmpty());

        numeros.clear();
        System.out.println("\nLista: " + numeros);
    }
}
