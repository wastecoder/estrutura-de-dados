package pilha;

public class PilhaTeste {
    public static void main(String[] args) {
        Pilha<Integer> numeros = new Pilha<>(5);

        numeros.empilhar(1);
        numeros.empilhar(2);
        numeros.empilhar(3);
        System.out.println(numeros);
        System.out.println("Topo: " + numeros.topo() + "\n");


        numeros.desempilhar();
        System.out.println("Desempilhando o elemento: " + numeros.desempilhar());
        System.out.println("Desempilhando o elemento: " + numeros.desempilhar());
        System.out.println(numeros);
        System.out.println("Desempilhando o elemento: " + numeros.desempilhar() + "\n");
    }
}
