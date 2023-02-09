package fila.prioridade;

import fila.Fila;

public class FilaComPrioridade<T> extends Fila<T> {
    @Override
    public void enfileirar(T elemento) {
        Comparable<T> chave = (Comparable<T>) elemento;

        int i; //Caso a lista esteja vazia
        for (i = 0; i < tamanho; i++) {
            if (chave.compareTo(elementos[i]) < 0) {
                break;
            }
        }
        adicionar(i, elemento);
    }
}
