package arvorebinariadebusca;

import java.util.LinkedList;
import java.util.Queue;

public class BST<T extends Comparable<T>> {
    private No<T> raiz;

    public BST() {
        raiz = null;
    }

    public void adicionar(T elemento) {
        raiz = adicionarRecursivo(raiz, elemento);
    }

    private No<T> adicionarRecursivo(No<T> noAtual, T elemento) {
        if (noAtual == null)
            return new No<>(elemento);

        if (elemento.compareTo(noAtual.elemento) < 0) //elemento < no.elemento
            noAtual.esquerda = adicionarRecursivo(noAtual.esquerda, elemento);
        else
            noAtual.direita = adicionarRecursivo(noAtual.direita, elemento);

        return noAtual;
    }

    public void remover(T elemento) {
        raiz = remover(raiz, elemento);
    }

    private No<T> remover(No<T> noAtual, T elemento) {
        if (noAtual == null) //Nó não foi encontrado
            return null;

        if (elemento.compareTo(noAtual.elemento) < 0)
            noAtual.esquerda = remover(noAtual.esquerda, elemento);
        else if (elemento.compareTo(noAtual.elemento) > 0)
            noAtual.direita = remover(noAtual.direita, elemento);
        else {  //Nó que vai ser removido encontrado
            if (noAtual.esquerda == null)     //Grau 1 - filho na direita
                return noAtual.direita;
            else if (noAtual.direita == null) //Grau 1 - filho na esquerda
                return noAtual.esquerda;
            else {                            //Grau 2 - ambos filhos
                //Encontra o sucessor: menor elemento na subárvore direita
                No<T> sucessor = noAtual.direita;
                while (sucessor.esquerda != null) {
                    sucessor = sucessor.esquerda;
                }
                //Coloca o elemento do sucessor no nó vai ser removido
                noAtual.elemento = sucessor.elemento;

                //Remove o sucessor
                noAtual.direita = remover(noAtual.direita, sucessor.elemento);
            }
        }
        return noAtual;
    }

    public void preorder() {
        preorderRecursivo(raiz);
        System.out.println(); //Opcional
    }

    private void preorderRecursivo(No<T> no) {
        if (no != null) {
            System.out.print(no.elemento + " ");
            preorderRecursivo(no.esquerda);
            preorderRecursivo(no.direita);
        }
    }

    public void inorder() {
        inorderRecursivo(raiz);
        System.out.println();
    }

    private void inorderRecursivo(No<T> no) {
        if (no != null) {
            inorderRecursivo(no.esquerda);
            System.out.print(no.elemento + " ");
            inorderRecursivo(no.direita);
        }
    }

    public void postorder() {
        postorderRecursivo(raiz);
        System.out.println();
    }

    private void postorderRecursivo(No<T> no) {
        if (no != null) {
            postorderRecursivo(no.esquerda);
            postorderRecursivo(no.direita);
            System.out.print(no.elemento + " ");
        }
    }

    public void percorrerEmLargura() {
        if (estaVazia()) return;

        Queue<No<T>> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No<T> no = fila.remove();
            System.out.print(no.elemento + " ");

            if (no.esquerda != null) fila.add(no.esquerda);
            if (no.direita != null) fila.add(no.direita);
        }
        System.out.println(); //Opcional
    }

    //Se retornar No<T>, seus atributos poderão ser alterados - valor e filhos
    private No<T> buscarNo(T elemento) {
        return buscarNo(raiz, elemento);
    }

    private No<T> buscarNo(No<T> noAtual, T elemento) {
        if (noAtual == null)
            return null;
        if (elemento.compareTo(noAtual.elemento) == 0) //elemento == elemento
            return noAtual;
        if (elemento.compareTo(noAtual.elemento) < 0)  //elemento < no.elemento
            return buscarNo(noAtual.esquerda, elemento);
        else                                           //elemento > no.elemento
            return buscarNo(noAtual.direita, elemento);
    }

    public boolean contem(T elemento) {
        return buscarNo(elemento) != null;
    }

    public int nivelDoNo(T elemento) {
        return nivelDoNoRecursivo(raiz, elemento, 0);
    }

    private int nivelDoNoRecursivo(No<T> no, T elemento, int nivelAtual) {
        if (no == null)
            return -1;
        if (elemento.compareTo(no.elemento) == 0)
            return nivelAtual;
        if (elemento.compareTo(no.elemento) < 0)
            return nivelDoNoRecursivo(no.esquerda, elemento, ++nivelAtual);
        else
            return nivelDoNoRecursivo(no.direita, elemento, ++nivelAtual);
    }

    public int altura() {
        return altura(this.raiz);
    }

    public int alturaDoNo(T elemento) {
        return altura(buscarNo(elemento));
    }

    private int altura(No<T> noAtual) {
        if(noAtual == null) return -1;
        else return 1 + Math.max(altura(noAtual.esquerda), altura(noAtual.direita));
    }

    public T minimo() {
        if (estaVazia()) return null;
        return minimo(this.raiz).elemento;
    }

    private No<T> minimo(No<T> noAtual) {
        if (noAtual.esquerda == null) return noAtual;
        else return minimo(noAtual.esquerda);
    }

    public T maximo() {
        if (estaVazia()) return null;

        No<T> noAtual = this.raiz;
        while(noAtual.direita != null) noAtual = noAtual.direita;

        return noAtual.elemento;
    }

    public boolean estaVazia() {
        return this.raiz == null;
    }
}

class No<T> {
    T elemento;
    No<T> esquerda;
    No<T> direita;

    public No(T elemento) {
        this.elemento = elemento;
    }
}
