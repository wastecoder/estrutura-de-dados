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

        System.out.println("\nElemento na 2ª posição: " + numeros.buscarElemento(1));
        System.out.println("Posição do elemento 2: " + numeros.buscarPosicao(2));

        System.out.println("\nContém 3? " + numeros.contem(3));
        System.out.println("Contém 2? " + numeros.contem(2));

        numeros.adicionar(0);
        System.out.println("\n" + numeros);
        System.out.println("Última posição de 0: " + numeros.ultimaPosicao(0));
        System.out.println("Última posição de 9: " + numeros.ultimaPosicao(9));

        System.out.println("\nRemoveu o elemento 0? " + numeros.removerElemento(0));
        System.out.println("Removeu o elemento 9? " + numeros.removerElemento(9));
        System.out.println(numeros);
    }
}
