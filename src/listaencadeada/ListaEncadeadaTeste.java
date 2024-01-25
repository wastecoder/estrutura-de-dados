package listaencadeada;

public class ListaEncadeadaTeste {
    public static void main(String[] args) {
        ListaEncaceada<Integer> lista1 = new ListaEncaceada<>();
        lista1.adicionar(1);
        lista1.adicionar(2);
        lista1.adicionar(3);
        lista1.adicionar(4);
        lista1.remover(2);

        System.out.println(lista1);
        System.out.println("Tamanho [lista1] = " + lista1.getTamanho());
        System.out.println("Posição do elemento [3] = " + lista1.buscarPosicao(3));
        System.out.println("Elemento na posição [0] = " + lista1.buscarElemento(0));



        System.out.println("\n=================================");
        ListaEncaceada<String> lista2 = new ListaEncaceada<>();
        lista2.adicionar("João");
        lista2.adicionar("Maria");
        lista2.adicionar(1, "Ana");

        System.out.println(lista2);
        System.out.println("Tamanho [lista2] = " + lista2.getTamanho());
        System.out.println("Posição do elemento [Carlos] = " + lista2.buscarPosicao("Carlos"));

        lista2.limpar();
        System.out.println(lista2);
    }
}
