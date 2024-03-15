package arvorebinariadebusca;

public class BSTTeste {
    public static void main(String[] args) {
        BST<Integer> arvore = new BST<>();

        arvore.adicionar(4);
        arvore.adicionar(2);
        arvore.adicionar(6);
        arvore.adicionar(1);
        arvore.adicionar(3);
        arvore.adicionar(5);
        arvore.adicionar(7);
        arvore.percorrerEmLargura();


        arvore.remover(4);
        arvore.remover(1);
        arvore.percorrerEmLargura();

        System.out.println("Contem 7? " + arvore.contem(7));
        System.out.println("Contem 4? " + arvore.contem(4));

        System.out.println("Altura da arvore: " + arvore.altura());
        System.out.println("Altura do nó 6: " + arvore.alturaDoNo(6));
        System.out.println("Nivel do nó 5: " + arvore.nivelDoNo(5));

        System.out.println("Menor valor: " + arvore.minimo());
        System.out.println("Maior valor: " + arvore.maximo());
    }
}
