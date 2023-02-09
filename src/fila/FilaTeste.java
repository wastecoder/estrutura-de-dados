package fila;

public class FilaTeste {
    public static void main(String[] args) {
        Fila<Integer> numeros = new Fila<>();

        numeros.enfileirar(1);
        numeros.enfileirar(2);
        numeros.enfileirar(3);
        System.out.println(numeros);
        System.out.println("Primeiro: " + numeros.primeiro());

        System.out.println("Desenfileirado: " + numeros.desenfileirar());
        System.out.println("Desenfileirado: " + numeros.desenfileirar());
        System.out.println(numeros);
    }
}
