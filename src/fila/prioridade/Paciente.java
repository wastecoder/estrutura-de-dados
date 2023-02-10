package fila.prioridade;

public class Paciente implements Comparable<Paciente> {
    private String nome;
    private Integer prioridade;

    public Paciente(String nome, Prioridade prioridade) {
        this.nome = nome;
        setPrioridade(prioridade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Prioridade getPrioridade() {
        return Prioridade.valueOf(this.prioridade);
    }

    public void setPrioridade(Prioridade prioridade) {
        if (prioridade != null) {
            this.prioridade = prioridade.getCode();
        }
    }

    @Override
    public String toString() {
        return "Paciente[" +
                "nome='" + nome + '\'' +
                ", prioridade=" + prioridade +
                ']';
    }

    @Override
    public int compareTo(Paciente p) {
        return Integer.compare(prioridade, p.getPrioridade().getCode());
    }
}
