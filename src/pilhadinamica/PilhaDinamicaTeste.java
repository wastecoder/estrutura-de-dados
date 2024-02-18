package pilhadinamica;

public class PilhaDinamicaTeste {
    public static void main(String[] args) {
        PilhaDinamica<Integer> numeros = new PilhaDinamica<>();

        numeros.empilhar(0);
        numeros.empilhar(2);
        numeros.empilhar(4);
        numeros.empilhar(6);
        numeros.empilhar(8);
        System.out.println("Pilha = " + numeros);

        System.out.println("\nDesempilhando = " + numeros.desempilhar());
        System.out.println("Desempilhando = " + numeros.desempilhar());
        System.out.println("Pilha = " + numeros);

        System.out.println("\nElemento na frente = " + numeros.topo());
        System.out.println("Tamanho da pilha = " + numeros.tamanho());
        System.out.println("Está vazia? " + numeros.estaVazia());
    }
}
