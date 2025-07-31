import java.util.function.Consumer;
import java.util.function.Supplier;

public class Produto {
    private String nome;
    private Double preco;
    private Double percentualMarkup;
    public Supplier<Double> precoComMarkup;
    public Consumer<Double> atualizarMarkup;

    public Produto(Double preco, String nome) {
        this.preco = preco;
        this.nome = nome;
        this.percentualMarkup = 10.00;
        this.precoComMarkup = () -> (getPreco() * (1 + (getPercentualMarkup() / 100.00)));
        this.atualizarMarkup = novoPrecoComMarkup -> this.percentualMarkup = novoPrecoComMarkup;
    }

    public String getNome() { return nome; }

    public Double getPreco() { return preco; }

    public Double getPercentualMarkup() { return percentualMarkup; }
}
