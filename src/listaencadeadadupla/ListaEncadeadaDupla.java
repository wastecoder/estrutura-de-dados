package listaencadeadadupla;

import java.util.NoSuchElementException;

public class ListaEncadeadaDupla<T> {
    private No<T> inicio;
    private No<T> fim;
    private int tamanho = 0;

    public ListaEncadeadaDupla() {
    }

    public void adicionarNoInicio(T elemento) {
        No<T> noNovo = new No<>(null, elemento, inicio);
        if (estaVazia()) { //inicio == null
            fim = noNovo;
        } else {
            inicio.anterior = noNovo;
        }
        inicio = noNovo; //Seria executado no if e else
        tamanho++;
    }

    public void adicionarNoFim(T elemento) {
        No<T> noNovo = new No<>(fim, elemento, null);
        if (estaVazia()) { //fim == null
            inicio = noNovo;
        } else {
            fim.proximo = noNovo;
        }
        fim = noNovo;
        tamanho++;
    }

    public void adicionarNaPosicao(int posicao, T elemento) {
        validarPosicao(posicao);

        if (posicao == 0) {
            adicionarNoInicio(elemento);
        } else if (posicao == tamanho) {
            adicionarNoFim(elemento);
        } else {
            No<T> noAnterior = buscarNo(posicao - 1);

            No<T> noNovo = new No<>(noAnterior, elemento, noAnterior.proximo);
            noAnterior.proximo.anterior = noNovo;
            noAnterior.proximo = noNovo;
            tamanho++;
        }
    }

    public T removerDoInicio() {
        validarRemocao();

        T elementoRemovido = inicio.elemento;
        if (tamanho == 1) {
            inicio = fim = null;
        } else {
            inicio = inicio.proximo;
            inicio.anterior = null;
        }
        tamanho--;

        return elementoRemovido;
    }

    public T removerDoFim() {
        validarRemocao();

        T elementoRemovido = fim.elemento;
        if (tamanho == 1) {
            inicio = fim = null;
        } else {
            fim = fim.anterior;
            fim.proximo = null;
        }
        tamanho--;

        return elementoRemovido;
    }

    public T removerDaPosicao(int posicao) {
        validarPosicao(posicao);
        validarRemocao();

        if (posicao == 0) {
            return removerDoInicio();
        } else if (posicao == tamanho - 1) {
            return removerDoFim();
        }

        No<T> noRemovido = buscarNo(posicao);
        noRemovido.anterior.proximo = noRemovido.proximo;
        noRemovido.proximo.anterior = noRemovido.anterior;
        tamanho--;

        return noRemovido.elemento;
    }

    public T obter(int posicao) {
        validarPosicao(posicao);

        return buscarNo(posicao).elemento;
    }

    public T primeiro() {
        return (inicio == null) ? null : inicio.elemento;
    }

    public T ultimo() {
        return (fim == null) ? null : fim.elemento;
    }

    public void limpar() {
        //while (!estaVazia()) removerDoInicio();

        No<T> proximo;
        for (No<T> atual = inicio; atual != null; ) {
            proximo = atual.proximo;
            atual.anterior = null;
            atual.elemento = null;
            atual.proximo = null;
            atual = proximo;
        }
        inicio = fim = null;
        tamanho = 0;
    }

    public boolean contem(T elemento) {
        No<T> atual = inicio;
        while (atual != null) {
            if (atual.elemento.equals(elemento)) {
                return true;
            }

            atual = atual.proximo;
        }

        return false;
    }

    public void inverter() {
        No<T> noAuxiliar;
        for (No<T> atual = inicio; atual != null; atual = atual.anterior) {
            noAuxiliar = atual.proximo;
            atual.proximo = atual.anterior;
            atual.anterior = noAuxiliar;
        }

        noAuxiliar = inicio;
        inicio = fim;
        fim = noAuxiliar;
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }


    private No<T> buscarNo(int posicao) {
        if (posicao < tamanho / 2) { //Escolhe o menor caminho
            No<T> atual = inicio;
            for (int i = 0; i < posicao; i++) {
                atual = atual.proximo;
            }
            return atual;
        } else {
            No<T> atual = fim;
            for (int i = tamanho - 1; i > posicao; i--) {
                atual = atual.anterior;
            }
            return atual;
        }
    }

    private void validarPosicao(int posicao) {
        if (posicao < 0 || posicao > tamanho)
            throw new IndexOutOfBoundsException("Posição inválida: " + posicao + ", tamanho atual: " + tamanho);
    }

    private void validarRemocao() {
        if (estaVazia())
            throw new NoSuchElementException("Não é possível remover, pois a lista está vazia");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");

        for (No<T> atual = inicio; atual != null; atual = atual.proximo) {
            builder.append(atual.elemento);

            if (atual.proximo != null) {
                builder.append(", ");
            }
        }

        builder.append("]");
        return builder.toString();
    }

    private static class No<E> {
        E elemento;
        No<E> proximo;
        No<E> anterior;

        public No(No<E> anterior, E elemento, No<E> proximo) {
            this.elemento = elemento;
            this.proximo = proximo;
            this.anterior = anterior;
        }
    }
}
