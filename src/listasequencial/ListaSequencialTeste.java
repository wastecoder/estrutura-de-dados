package listasequencial;

public class ListaSequencialTeste {
    public static void main(String[] args) {
        ListaSequencial<Integer> numeros = new ListaSequencial<>();

        numeros.adicionar(1);
        numeros.adicionar(2);
        numeros.adicionar(4);
        System.out.println(numeros);

        numeros.adicionar(0,0);
        numeros.adicionar(3,3);
        System.out.println(numeros);

        numeros.removerPosicao(2);
        System.out.println(numeros);

        System.out.println("\nElemento na 2� posi��o: " + numeros.buscarElemento(1));
        System.out.println("Posi��o do elemento 2: " + numeros.buscarPosicao(2));

        System.out.println("\nCont�m 3? " + numeros.contem(3));
        System.out.println("Cont�m 2? " + numeros.contem(2));

        numeros.adicionar(0);
        System.out.println("\n" + numeros);
        System.out.println("�ltima posi��o de 0: " + numeros.ultimaPosicao(0));
        System.out.println("�ltima posi��o de 9: " + numeros.ultimaPosicao(9));

        System.out.println("\nRemoveu o elemento 0? " + numeros.removerElemento(0));
        System.out.println("Removeu o elemento 9? " + numeros.removerElemento(9));
        System.out.println(numeros);
    }
}
