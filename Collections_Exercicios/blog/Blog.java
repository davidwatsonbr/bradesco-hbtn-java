import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Blog {
    List<Post> postagens;

    public Blog() {
        postagens = new ArrayList<>();
    }

    public void adicionarPostagem(Post postagem) {
        postagens.add(postagem);
    }

    public Set<String> obterTodosAutores() {
        Set<String> autores = new TreeSet<>();
        for (Post postagem : postagens) {
            autores.add(postagem.getAutor());
        }
        return autores;
    }

    public Map<String, Integer> obterContagemPorCategoria() {
        Map<String, Integer> contagemPorCategoria = new TreeMap<>();
        System.out.println("Quantidade: " + postagens.stream().map(c -> c.getCategoria()).count());
        for (Post postagem : postagens) {
            contagemPorCategoria.put(postagem.getCategoria(), 10);
        }
        return contagemPorCategoria;
    }
}
