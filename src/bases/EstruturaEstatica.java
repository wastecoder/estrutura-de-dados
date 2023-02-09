package bases;

public class EstruturaEstatica<T> {
    protected T[] elementos;
    protected int tamanho;



    public EstruturaEstatica(int capacidade) {
        if (capacidade < 0) throw new IllegalArgumentException("Capacidade inicial inválida: " + capacidade);
        elementos = (T[]) new Object[capacidade];
        tamanho = 0;
    }

    public EstruturaEstatica() {
        this(10);
    }



    protected boolean adicionar(T elemento) {
        garantirCapacidade();
        if (tamanho < elementos.length) {
            elementos[tamanho] = elemento;
            tamanho++;
            return true;
        }
        return false;
    }

    protected void adicionar(int posicao, T elemento) { //Protected porque será herdado pelas filhas, mas não usável pelos objetos, como pilha e fila.
        validarPosicao(posicao);
        garantirCapacidade();

        for (int i = tamanho - 1; i >= posicao; i--) {
            elementos[i + 1] = elementos[i];
        }
        elementos[posicao] = elemento;
        tamanho++;
    }

    protected void removerPosicao(int posicao) {
        validarPosicao(posicao);

        for (int i = posicao; i < tamanho - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        elementos[--tamanho] = null; //Diminui o tamanho e coloca null no último.
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int tamanho() {
        return tamanho;
    }



    protected void garantirCapacidade() {
        if (tamanho == elementos.length) {
            int novaCapacidade = (tamanho * 3)/2 + 1;
            T[] elementosNovos = (T[]) new Object[novaCapacidade];

            for (int i = 0; i < elementos.length; i++) {
                elementosNovos[i] = elementos[i];
            }
            elementos = elementosNovos;
        }
    }

    protected void validarPosicao(int posicao) {
        if (posicao < 0 || posicao > tamanho) throw new IllegalArgumentException("Posição inválida: " + posicao);
    }

    @Override
    public String toString() {
        if (tamanho == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < tamanho - 1; i++) {
            builder.append(elementos[i]).append(", ");
        }
        builder.append(elementos[tamanho - 1]).append("]");

        return builder.toString();
    }
}
