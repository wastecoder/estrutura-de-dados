package filadinamica;

public class FilaDinamicaTeste {
    public static void main(String[] args) {
        FilaDinamica<Integer> numeros = new FilaDinamica<>();

        numeros.enfileirar(0);
        numeros.enfileirar(2);
        numeros.enfileirar(4);
        numeros.enfileirar(6);
        numeros.enfileirar(8);
        System.out.println("Fila = " + numeros);

        System.out.println("\nDesenfileirando = " + numeros.desenfileirar());
        System.out.println("Desenfileirando = " + numeros.desenfileirar());
        System.out.println("Fila = " + numeros);

        System.out.println("\nElemento na frente = " + numeros.frente());
        System.out.println("Tamanho da fila = " + numeros.tamanho());
        System.out.println("Está vazia? " + numeros.estaVazia());
    }
}
