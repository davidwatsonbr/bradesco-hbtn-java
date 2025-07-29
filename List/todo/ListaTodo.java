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
                throw new RuntimeException(String.format("Tarefa com identificador %s ja existente na lista", tarefa.getIdentificador()));
            }
        }
        tarefas.add(tarefa);
    }

    public boolean marcarTarefaFeita(int identificador) {
        Iterator<Tarefa> i = tarefas.iterator();
        while (i.hasNext()) {
            Tarefa tarefaItem = i.next();
            if (tarefaItem.getIdentificador() == identificador) {
                tarefaItem.setEstahFeita(true);
                return true;
            }
        }
        return false;
    }

    public boolean desfazerTarefa(int identificador) {
        Iterator<Tarefa> i = tarefas.iterator();
        while (i.hasNext()) {
            Tarefa tarefaItem = i.next();
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
        Iterator<Tarefa> i = tarefas.iterator();
        StringBuilder sb = new StringBuilder();
        while (i.hasNext()) {
            Tarefa tarefaItem = i.next();
            sb.append(String.format("[%s]  Id: %s - Descricao: %s\n", tarefaItem.getEstahFeita() ? "X" : " ", tarefaItem.getIdentificador(), tarefaItem.getDescricao()));
        }
        System.out.println(sb);
    }
}
