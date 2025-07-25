import java.util.HashMap;
import java.util.Map;

public class GerenciamentoDeContatos {
    private Map<String, Contato> contatos;

    // Construtor
    public GerenciamentoDeContatos() {
        contatos = new HashMap<>();
    }

    // Adiciona um novo contato
    public void adicionarContato(String nome, String telefone, String email) {
        if (contatos.containsKey(nome)) {
            System.out.println(String.format("Erro: Contato com nome %s já existe!", nome));
        } else {
            Contato contato = new Contato();
            contato.adicionarTelefone(telefone);
            contato.adicionarEmail(email);
            this.contatos.put(nome, contato);
            System.out.println(String.format("Contato %s adicionado com sucesso!", nome));
        }
    }

    // Exibe todos os contatos
    public void exibirContatos() {
        for (Map.Entry<String, Contato> entry : contatos.entrySet()) {
            System.out.println(String.format("Nome: %s", entry.getKey()));
            System.out.println(String.format("Telefones: %s", entry.getValue().getTelefones()));
            System.out.println(String.format("Emails: %s", entry.getValue().getEmails()));
            System.out.println("-------------------------------");
        }
    }

    // Busca um contato pelo nome
    public void buscarContato(String nome) {
        if (this.contatos.containsKey(nome)) {
            System.out.println(String.format("Contato encontrado: %s", nome));
            Contato contato = contatos.get(nome);
            System.out.println(String.format("Telefones: %s", contato.getTelefones()));
            System.out.println(String.format("Emails: %s", contato.getEmails()));
        }
    }


    // Remove um contato pelo nome
    public void removerContato(String nome) {
        if (!this.contatos.containsKey(nome)) {
            System.out.println(String.format("Contato %s não encontrado.", nome));
        } else {
            contatos.remove(nome);
            System.out.println(String.format("Contato %s removido com sucesso!", nome));
        }
    }

    public static void main(String[] args) {
        GerenciamentoDeContatos gestao = new GerenciamentoDeContatos();

        // Adicionando contatos
        gestao.adicionarContato("Carlos", "1234-5678", "carlos@email.com");
        gestao.adicionarContato("Maria", "8765-4321", "maria@email.com");
        gestao.adicionarContato("Ana", "1122-3344", "ana@email.com");
        gestao.adicionarContato("Carlos", "1234-5678", "carlos@email.com"); // Tentando duplicar


        // Exibindo todos os contatos
        System.out.println("\nExibindo todos os contatos:");
        gestao.exibirContatos();


        // Buscando um contato
        System.out.println("\nBuscando contato 'Maria':");
        gestao.buscarContato("Maria");


        // Removendo um contato
        System.out.println("\nRemovendo contato 'Carlos':");
        gestao.removerContato("Carlos");


        // Tentando remover um contato inexistente
        System.out.println("\nTentando remover contato 'João' que não existe:");
        gestao.removerContato("João");


        // Exibindo todos os contatos após remoções
        System.out.println("\nExibindo todos os contatos após remoções:");
        gestao.exibirContatos();
    }
}