package listaencadeada;

public class ListaEncaceada<T> {
    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho;

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

    public int buscaLinear(T elemento) {
        int posicao = -1;

        int aux = 0;
        for (No<T> atual = this.inicio; atual != null; atual = atual.getProximo()) {
            if (atual.getElemento().equals(elemento)) {
                return aux;
            }
            aux++;
        }

        return posicao;
    }


    public int getTamanho() {
        return this.tamanho;
    }

    @Override
    public String toString() {
        if (this.tamanho == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");

        No<T> atual = this.inicio;
        for (int i = 0; i < this.tamanho - 1; i++) {
            builder.append(atual.getElemento()).append(",");
            atual = atual.getProximo();
        }
        builder.append(atual.getElemento()).append("]");

        return builder.toString();
    }
}
