import java.util.ArrayList;
import java.util.List;

public class Biblioteca<T extends Midia> {
    private List<T> listaMidia;

    public Biblioteca() {
        this.listaMidia = new ArrayList<T>();
    }

    public void adicionarMidia(T midia) {
        this.listaMidia.add(midia);
    }

    public List<T> obterListaMidias() {
        return this.listaMidia;
    }
}
