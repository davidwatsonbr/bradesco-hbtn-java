import java.util.List;

public class ManipularArrayNumeros {
    private static int buscarPosicaoNumero(List<Integer> listaNumeros, int numero) {
        return listaNumeros.indexOf(numero);
    }

    public static void adicionarNumero(List<Integer> listaNumeros, int numero) {
        if (buscarPosicaoNumero(listaNumeros, numero) == -1) {
            listaNumeros.add(numero);
        } else {
            throw new RuntimeException("Numero jah contido na lista");
        }
    }

    public static void removerNumero(List<Integer> listaNumeros, int numero) {
        int posicaoNumero = buscarPosicaoNumero(listaNumeros, numero);
        if (posicaoNumero != -1) {
            listaNumeros.remove(posicaoNumero);
        } else {
            throw new RuntimeException("Numero nao encontrado na lista");
        }
    }

    public static void substituirNumero(List<Integer> listaNumeros, int numeroSubstituir, int numeroSubstituto) {
        int posicaoNumero = buscarPosicaoNumero(listaNumeros, numeroSubstituir);
        if (posicaoNumero == -1) {
            listaNumeros.add(numeroSubstituto);
        } else {
            listaNumeros.set(posicaoNumero, numeroSubstituto);
        }
    }
}
