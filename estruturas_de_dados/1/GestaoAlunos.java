import java.util.ArrayList;
import java.util.List;

public class GestaoAlunos {
    List<Aluno> alunos = new ArrayList<Aluno>();

    public void adicionarAluno(String nome, int idade) {
        alunos.add(new Aluno(nome, idade));
    }

    public void excluirAluno(String nome) {
        boolean removido = alunos.removeIf(aluno -> aluno.getNome().equals(nome));
        if (removido) {
            System.out.println("Aluno removido com sucesso");
        } else {
            System.out.println("Aluno nao encontrado para exclusao");
        }
    }

    public void buscarAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                System.out.println(aluno.toString());
                return;
            }
        }

        System.out.println("Aluno nao encontrado");
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado");
        } else {
            System.out.println("Lista de alunos:");
            for (Aluno aluno : alunos) {                
                System.out.println(aluno.toString());
            }
        }
    }

    public static void main(String[] args) {
        GestaoAlunos alunos = new GestaoAlunos();
        alunos.adicionarAluno("Joao", 10);
        alunos.adicionarAluno("Ana", 20);
        alunos.adicionarAluno("Ana Clara", 30);

        alunos.listarAlunos();
        alunos.buscarAluno("Joao");
        alunos.excluirAluno("Ana");
        alunos.excluirAluno("Ana");
        alunos.buscarAluno("Joana");
    }
}
