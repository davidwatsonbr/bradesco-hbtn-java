public class PersonagemGame {
    private int saudeAtual;
    private String nome;
    private String status;

    public PersonagemGame(int saudeAtual, String nome) {
        setSaudeAtual(saudeAtual);
        setNome(nome);
    }

    public int getSaudeAtual() {
        return saudeAtual;
    }
    public void setSaudeAtual(int saudeAtual) {
        this.saudeAtual = saudeAtual;
        if (getSaudeAtual() > 0) {
            this.status = "vivo";
        } else {
            this.status = "morto";
        }
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        }
    }
    public String getStatus() {
        return status;
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
