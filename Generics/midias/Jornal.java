public class Jornal extends Midia {
    private int quantidadeArtigos;

    public Jornal(String nome, int quantidadeArtigos) {
        super.setNome(nome);
        this.quantidadeArtigos = quantidadeArtigos;
    }
}
