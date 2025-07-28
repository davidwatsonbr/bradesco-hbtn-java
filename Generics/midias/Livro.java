public class Livro extends Midia {
    private int edicao;

    public Livro(String nome, int edicao) {
        super.setNome(nome);
        this.edicao = edicao;
    }
}
