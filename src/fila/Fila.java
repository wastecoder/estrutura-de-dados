package fila;

import bases.EstruturaEstatica;

public class Fila<T> extends EstruturaEstatica<T> {
    public Fila(int capacidade) {
        super(capacidade);
    }

    public Fila() {
        super(10);
    }


    public void enfileirar(T elemento) {
        super.adicionar(elemento);
    }

    public T desenfileirar() {
        if (estaVazia()) return null;

        T removido = elementos[0];
        super.removerPosicao(0);
        return removido;
    }

    public T primeiro() {
        if (estaVazia()) return null;
        return elementos[0];
    }
}
