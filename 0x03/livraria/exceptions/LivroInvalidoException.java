package exceptions;

public class LivroInvalidoException extends Exception {
    public LivroInvalidoException(String descricaoExcecao) {
        super(descricaoExcecao);
    }
}
