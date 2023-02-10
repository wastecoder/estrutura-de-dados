package fila.prioridade;

public enum Prioridade {
    VERMELHO(1),
    AMARELO(2),
    VERDE(3);

    private int code;

    private Prioridade(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Prioridade valueOf(int code) {
        for (Prioridade value : Prioridade.values()) {
            if (code == value.code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Código de Prioridade inválido: " + code);
    }
}
