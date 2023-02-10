package fila.exercicios;

import java.util.LinkedList;
import java.util.Queue;

public class Atendimento {
    public static void main(String[] args) {
        Queue<String> normal = new LinkedList<>();
        Queue<String> prioritaria = new LinkedList<>();

        for (int quantidade = 1; quantidade <= 6; quantidade++) {
            normal.add("Normal " + quantidade);
            prioritaria.add("Prioritária " + quantidade);
        }

        int MAX_PRIORIDADE = 3;
        while (!normal.isEmpty() || !prioritaria.isEmpty()) {
            int acumulador = 0;
            while (!prioritaria.isEmpty() && acumulador < MAX_PRIORIDADE) {
                atender(prioritaria);
                acumulador++;
            }

            if (!normal.isEmpty()) {
                atender(normal);
            }
        }

        System.out.println("Todas pessoas atendidas.");
    }

    public static <T> void atender(Queue<T> pessoa) {
        System.out.println("Pessoa [" + pessoa.remove() + "] atendida.");
    }
}
