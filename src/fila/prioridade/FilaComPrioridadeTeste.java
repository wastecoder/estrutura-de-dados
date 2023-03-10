package fila.prioridade;

public class FilaComPrioridadeTeste {
    public static void main(String[] args) {
        FilaComPrioridade<Integer> numeros = new FilaComPrioridade<>();

        numeros.enfileirar(1);
        numeros.enfileirar(5);
        numeros.enfileirar(3);
        numeros.enfileirar(2);
        numeros.enfileirar(4);
        System.out.println(numeros);


        FilaComPrioridade<Paciente> pacientes = new FilaComPrioridade<>();

        pacientes.enfileirar(new Paciente("A", Prioridade.VERDE));
        pacientes.enfileirar(new Paciente("B", Prioridade.VERMELHO));
        pacientes.enfileirar(new Paciente("C", Prioridade.AMARELO));
        System.out.println("\n" +pacientes);
        System.out.println("Desenfileirado: " + pacientes.desenfileirar());
        System.out.println(pacientes);
    }
}
