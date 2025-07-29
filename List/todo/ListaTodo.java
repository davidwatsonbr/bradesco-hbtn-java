import java.util.ArrayList;
import java.util.Iterator;

public class ListaTodo {
    private ArrayList<Tarefa> tarefas;

    public ListaTodo() {
        tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        Iterator<Tarefa> i = tarefas.iterator();
        while (i.hasNext()) {
            Tarefa tarefaItem = i.next();
            if (tarefaItem.getIdentificador() == tarefa.getIdentificador()) {
                throw new IllegalArgumentException(String.format("Tarefa com identificador %s ja existente na lista", tarefa.getIdentificador()));
            }
        }
        tarefas.add(tarefa);
    }

    public boolean marcarTarefaFeita(int identificador) {
        for (Tarefa tarefaItem : tarefas) {
            if (tarefaItem.getIdentificador() == identificador) {
                tarefaItem.setEstahFeita(true);
                return true;
            }
        }
        return false;
    }

    public boolean desfazerTarefa(int identificador) {
        for (Tarefa tarefaItem : tarefas) {
            if (tarefaItem.getIdentificador() == identificador) {
                tarefaItem.setEstahFeita(false);
                return true;
            }
        }
        return false;
    }

    public void desfazerTodas() {
        Iterator<Tarefa> i = tarefas.iterator();
        while (i.hasNext()) {
            i.next().setEstahFeita(false);
        }
    }

    public void fazerTodas() {
        Iterator<Tarefa> i = tarefas.iterator();
        while (i.hasNext()) {
            i.next().setEstahFeita(true);
        }
    }

    public void listarTarefas() {
        for (Tarefa tarefaItem : tarefas) {
            System.out.printf("[%s]  Id: %d - Descricao: %s\n",
                tarefaItem.getEstahFeita() ? "X" : " ",
                tarefaItem.getIdentificador(),
                tarefaItem.getDescricao());
        }
    }
}
