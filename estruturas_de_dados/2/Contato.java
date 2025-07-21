import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Contato {
    private List<String> telefones;
    private Set<String> emails;

    public Contato() {
        telefones = new ArrayList<String>();
        emails = new HashSet<String>();
    }
    public List<String> getTelefones() {
        return telefones;
    }

    public void adicionarTelefone(String telefone) {
        telefones.add(telefone);
    }

    public Set<String> getEmails() {
        return emails;
    }

    public void adicionarEmail(String email) {
        emails.add(email);
    }
}
