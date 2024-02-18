package listaencadeadadupla;

public class ListaEncadeadaDuplaTeste {
    public static void main(String[] args) {
        ListaEncadeadaDupla<Integer> numeros = new ListaEncadeadaDupla<>();

        numeros.adicionarNoInicio(2);
        numeros.adicionarNoInicio(1);
        System.out.println("Lista = " + numeros);

        numeros.adicionarNoFim(4);
        numeros.adicionarNoFim(5);
        System.out.println("Lista = " + numeros);

        numeros.adicionarNaPosicao(0, 0);
        numeros.adicionarNaPosicao(3, 3);
        numeros.adicionarNaPosicao(6, 6);
        System.out.println("Lista = " + numeros);


        System.out.println("\nRemovendo da posição [3] = " + numeros.removerDaPosicao(3));
        System.out.println("Removendo do inicio = " + numeros.removerDoInicio());
        System.out.println("Removendo do fim = " + numeros.removerDoFim());
        System.out.println("Lista = " + numeros);

        System.out.println("\nElemento na posição [3] = " + numeros.obter(3));

        System.out.println("\nPossui o elemento [9]? " + numeros.contem(9));
        System.out.println("Possui o elemento [5]? " + numeros.contem(5));

        numeros.inverter();
        System.out.println("\nLista = " + numeros);

        numeros.limpar();
        System.out.println("\nLista = " + numeros);
    }
}
