package filadinamica;

import listaencadeadadupla.ListaEncadeadaDupla;

public class FilaDinamica<T> {
    private ListaEncadeadaDupla<T> listaEncadeada;

    public FilaDinamica() {
        listaEncadeada = new ListaEncadeadaDupla<>();
    }

    public void enfileirar(T elemento) {
        listaEncadeada.adicionarNoFim(elemento);
    }

    public T desenfileirar() {
        return listaEncadeada.removerDoInicio();
    }

    public T frente() {
        return listaEncadeada.primeiro();
    }

    public int tamanho() {
        return listaEncadeada.tamanho();
    }

    public boolean estaVazia() {
        return listaEncadeada.estaVazia();
    }

    @Override
    public String toString() {
        return listaEncadeada.toString();
    }
}
