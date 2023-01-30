package listaencadeada;

public class No<T> {
    private T elemento;
    private No<T> proximo;


     public No(T elemento) { //Adiciona em �ltimo
        this.elemento = elemento;
        this.proximo = null;
    }

    public No(T elemento, No<T> proximo) { //Adiciona no come�o ou meio (TO DO)
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }


    @Override
    public String toString() {
        return "No{" +
                "elemento=" + elemento +
                ", proximo=" + proximo +
                '}';
    }
}
