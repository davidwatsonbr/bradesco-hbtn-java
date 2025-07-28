public class PersonagemGame {
    private int saudeAtual;
    private String nome;

    public int getSaudeAtual() {
        return saudeAtual;
    }
    public void setSaudeAtual(int saudeAtual) {
        this.saudeAtual = saudeAtual;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void tomarDano(int quantidadeDeDano) {
        if (getSaudeAtual() - quantidadeDeDano >= 0) {
            setSaudeAtual(getSaudeAtual() - quantidadeDeDano);
        } else {
            setSaudeAtual(0);
        }
    }

    public void receberCura(int quantidadeDeCura) {
        if (getSaudeAtual() + quantidadeDeCura <= 100) {
            setSaudeAtual(getSaudeAtual() + quantidadeDeCura);
        } else {
            setSaudeAtual(100);
        }
    }
}
