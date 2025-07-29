public class Tarefa {
    private String descricao;
    private boolean estahFeita;
    private int identificador;

    public Tarefa(String descricao, int identificador) {
        modificarDescricao(descricao);
        this.identificador = identificador;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getIdentificador() {
        return identificador;
    }

    public boolean getEstahFeita() {
        return estahFeita;
    }

    public void setEstahFeita(boolean estahFeita) {
        this.estahFeita = estahFeita;
    }

    public void modificarDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new RuntimeException("Descricao de tarefa invalida");
        }
        this.descricao = descricao;
    }
}
