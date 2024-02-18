package pilhadinamica;

import listaencadeadadupla.ListaEncadeadaDupla;

public class PilhaDinamica<T> {
    ListaEncadeadaDupla<T> listaEncadeada;

    public PilhaDinamica() {
        listaEncadeada = new ListaEncadeadaDupla<>();
    }

    public void empilhar(T elemento) {
        listaEncadeada.adicionarNoFim(elemento);
    }

    public T desempilhar() {
        return listaEncadeada.removerDoFim();
    }

    public T topo() {
        return listaEncadeada.ultimo();
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
