package pilha;

import bases.EstruturaEstatica;

public class Pilha<T> extends EstruturaEstatica<T> {
    public Pilha(int capacidade) {
        super(capacidade);
    }

    public Pilha() {
        super();
    }


    public void empilhar(T elemento) {
        super.adicionar(elemento);
    }

    public T desempilhar() {
        if (estaVazia()) {
            return null;
        }
        T removido = elementos[--tamanho];
        elementos[tamanho] = null;
        return removido;
    }

    public T topo() {
        if (estaVazia()) {
            return null;
        }
        return elementos[tamanho - 1];
    }
}
