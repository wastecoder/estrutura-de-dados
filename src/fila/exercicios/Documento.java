package fila.exercicios;

import java.util.LinkedList;
import java.util.Queue;

public class Documento {
    public static void main(String[] args) {
        Queue<Documento> documentos = new LinkedList<>();
        documentos.add(new Documento("Doc 1", 20));
        documentos.add(new Documento("Doc 2", 30));
        documentos.add(new Documento("Doc 3", 40));
        System.out.println(documentos);

        while (!documentos.isEmpty()) {
            int tempoLevado = 100 * documentos.peek().getQuantidadeFolhas();
            System.out.println("Imprimindo o documento: [" + documentos.remove().getNome() + "]. Irá levar " + tempoLevado/1000 + " segundos.");

            try {
                Thread.sleep(tempoLevado);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Impressora livre. Todos documentos impressos.");
    }



    private String nome;
    private int quantidadeFolhas;

    public Documento(String nome, int quantidadeFolhas) {
        this.nome = nome;
        this.quantidadeFolhas = quantidadeFolhas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeFolhas() {
        return quantidadeFolhas;
    }

    public void setQuantidadeFolhas(int quantidadeFolhas) {
        this.quantidadeFolhas = quantidadeFolhas;
    }

    @Override
    public String toString() {
        return "Documento{" +
                "nome='" + nome + '\'' +
                ", quantidadeFolhas=" + quantidadeFolhas +
                '}';
    }
}
