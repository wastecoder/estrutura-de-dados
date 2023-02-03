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

        numeros.remover(2);
        System.out.println(numeros);

        System.out.println(numeros.buscarElemento(1));
        System.out.println(numeros.buscarPosicao(2));
    }
}
