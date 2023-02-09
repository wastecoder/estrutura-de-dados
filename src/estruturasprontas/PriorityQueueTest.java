package estruturasprontas;

import fila.prioridade.FilaComPrioridade;
import fila.prioridade.Paciente;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        Queue<Integer> numeros = new PriorityQueue<>();

        numeros.add(1);
        numeros.add(5);
        numeros.add(3);
        numeros.add(2);
        numeros.add(4);
        System.out.println(numeros);
        System.out.println("Desenfileirado: " + numeros.remove());
        System.out.println("Desenfileirado: " + numeros.remove());
        System.out.println(numeros);


        Queue<Paciente> pacientes = new PriorityQueue<>();

        pacientes.add(new Paciente("A", 3));
        pacientes.add(new Paciente("B", 1));
        pacientes.add(new Paciente("C", 2));
        pacientes.add(new Paciente("D", 1));
        System.out.println("\n" +pacientes);
        System.out.println("Desenfileirado: " + pacientes.remove());
        System.out.println("Desenfileirado: " + pacientes.remove());
        System.out.println(pacientes);
    }
}
