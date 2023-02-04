package listasequencial;

public class ListaSequencial<T> {
    private T[] elementos;
    private int tamanho;

    public ListaSequencial(int capacidade) {
        if (capacidade < 0) throw new IllegalArgumentException("Capacidade inicial inválida: " + capacidade);
        elementos = (T[]) new Object[capacidade];
        tamanho = 0;
    }

    public ListaSequencial() {
        this(10);
    }



    public boolean adicionar(T elemento) {
        garantirCapacidade();
        if (tamanho < elementos.length) {
            elementos[tamanho] = elemento;
            tamanho++;
            return true;
        }
        return false;
    }

    public void adicionar(int posicao, T elemento) {
        validarPosicao(posicao);
        garantirCapacidade();

        for (int i = tamanho - 1; i >= posicao; i--) {
            elementos[i + 1] = elementos[i];
        }
        elementos[posicao] = elemento;
        tamanho++;
    }

    public T buscarElemento(int posicao) {
        validarPosicao(posicao);
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
        validarPosicao(posicao);

        for (int i = posicao; i < tamanho - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        elementos[--tamanho] = null; //Diminui o tamanho e coloca null no último.
        //Outra forma de fazer a linha acima é deixar "tamanho" em vez de "tamanho - 1" no laço. Porém, ainda iria precisar do --tamanho.
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



    public void garantirCapacidade() {
        if (tamanho == elementos.length) {
            int novaCapacidade = (tamanho * 3)/2 + 1;
            T[] elementosNovos = (T[]) new Object[novaCapacidade];

            for (int i = 0; i < elementos.length; i++) {
                elementosNovos[i] = elementos[i];
            }
            elementos = elementosNovos;
        }
    }

    public void validarPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) throw new IllegalArgumentException("Posição inválida: " + posicao);
    }

    public int tamanho() {
        return tamanho;
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
