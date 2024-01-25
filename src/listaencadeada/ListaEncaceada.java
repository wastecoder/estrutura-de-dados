package listaencadeada;

public class ListaEncaceada<T> {
    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho;

    private final int NAO_ENCONTRADO = -1;

    public void adicionar(T elemento) {
        No<T> celula = new No<>(elemento);
        if (tamanho == 0) { //É o primeiro
            this.inicio = celula;
        } else {
            this.ultimo.setProximo(celula); //Último vira penúltimo
        }
        this.ultimo = celula; //Novo elemento em último
        this.tamanho++;
    }

    public void adicionar(int posicao, T elemento) {
        if (posicao == tamanho) { //Última posição ou lista vazia
            adicionar(elemento);
        } else if (posicao == 0) { //Primeira posição
            inicio = new No<>(elemento, inicio);
            tamanho++;
        } else { //No meio
            No<T> noAnterior = buscarNo(posicao - 1);
            No<T> proximoNo = noAnterior.getProximo();
            No<T> noNovo = new No<>(elemento, proximoNo);
            noAnterior.setProximo(noNovo);
            tamanho++;
        }
    }

    public void limpar() {
        for (No<T> atual = this.inicio; atual != null;) {
            No<T> proximo = atual.getProximo();
            atual.setElemento(null);
            atual.setProximo(null);
            atual = proximo;
        }

        //O código abaixo seria suficiente, mas o acima ajuda o Garbage Collector
        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public void remover(T elemento) {
        No<T> primeiro = this.inicio;
        if (primeiro.getElemento() == elemento) {
            this.inicio = primeiro.getProximo();
            tamanho--;
        } else {

            No<T> atual = primeiro.getProximo();
            No<T> anterior = primeiro; //"Mudei" o nome para aumentar a legibilidade, mas não era necessário
            while (atual != null) {
                if (atual.getElemento() == elemento) {
                    anterior.setProximo(atual.getProximo());
                    tamanho--;
                    break;
                }
                anterior = atual;
                atual = atual.getProximo();
            }
        }
    }

    private No<T> buscarNo(int posicao) {
        validarPosicao(posicao);

        No<T> atual = this.inicio;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }

        return atual;
    }

    public T buscarElemento(int posicao) {
        return this.buscarNo(posicao).getElemento();
    }

    public int buscarPosicao(T elemento) {
        int posicao = 0;
        for (No<T> atual = this.inicio; atual != null; atual = atual.getProximo()) {
            if (atual.getElemento().equals(elemento)) {
                return posicao;
            }
            posicao++;
        }

        return NAO_ENCONTRADO;
    }


    public int getTamanho() {
        return this.tamanho;
    }

    private void validarPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho)
            throw new IllegalArgumentException("Posição inválida: " + posicao);
    }

    @Override
    public String toString() {
        if (this.tamanho == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");

        No<T> atual = this.inicio;
        for (int i = 0; i < this.tamanho - 1; i++) {
            builder.append(atual.getElemento()).append(", ");
            atual = atual.getProximo();
        }
        builder.append(atual.getElemento()).append("]");

        return builder.toString();
    }
}
