package listasequencial;

import bases.EstruturaEstatica;

public class ListaSequencial<T> extends EstruturaEstatica<T> {
    public ListaSequencial(int capacidade) {
        super(capacidade);
    }

    public ListaSequencial() {
        super();
    }



    public boolean adicionar(T elemento) {
        return super.adicionar(elemento);
    }

    public void adicionar(int posicao, T elemento) {
        super.adicionar(posicao, elemento);
    }

    public T buscarElemento(int posicao) {
        super.validarPosicao(posicao);
        return elementos[posicao];
    }

    public int buscarPosicao(T elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public void removerPosicao(int posicao) {
        super.removerPosicao(posicao);
    }

    public boolean removerElemento(T elemento) {
        int posicao = buscarPosicao(elemento); //Ou ultimaPosicao()
        if (posicao >= 0) {
            removerPosicao(posicao);
            return true;
        }
        return false;
    }

    public boolean contem(T elemento) {
        return buscarPosicao(elemento) >= 0;
    }

    public int ultimaPosicao(T elemento) {
        for (int i = tamanho - 1; i >= 0; i--) {
            if (elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public void limpar() {
//        elementos = (T[]) new Object[tamanho]; //Ambas soluções ajudam o GC, escolha uma.
        for (int i = 0; i < tamanho; i++) elementos[i] = null;

        tamanho = 0;
    }
}
