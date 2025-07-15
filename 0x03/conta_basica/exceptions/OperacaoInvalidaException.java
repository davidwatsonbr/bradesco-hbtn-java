package exceptions;

public class OperacaoInvalidaException extends Exception {
    public OperacaoInvalidaException(String descricaoExcecao) {
        super(descricaoExcecao);
    }
}
