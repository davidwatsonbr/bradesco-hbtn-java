import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Blog {
    private List<Post> postagens;

    public Blog() {
        postagens = new ArrayList<>();
    }

    public void adicionarPostagem(Post postagem) {
        for (Post o : postagens) {
            if (o.compareTo(postagem) == 0) {
                throw new RuntimeException("Postagem jah existente");
            }
        }
        postagens.add(postagem);
    }

    public Set<Autor> obterTodosAutores() {
        Set<Autor> autores = new TreeSet<>();
        for (Post postagem : postagens) {
            autores.add(new Autor(postagem.getAutor().getNome(), postagem.getAutor().getSobrenome()));
        }
        return autores;
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        Map<Categorias, Integer> contagemPorCategoria = new LinkedHashMap<>();
        for (Post postagem : postagens) {
            Categorias categoria = postagem.getCategoria();
            contagemPorCategoria.put(categoria, contagemPorCategoria.getOrDefault(categoria, 0) + 1);
        }
        return contagemPorCategoria;
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        Set<Post> postsPorAutor = new TreeSet<>(Comparator.comparing(Post::getTitulo));
        for(Post postagem : postagens) {
            if (postagem.getAutor().compareTo(autor) == 0) {
                postsPorAutor.add(postagem);
            }
        }
        return postsPorAutor;
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        Set<Post> postsPorCategoria = new TreeSet<>(Comparator.comparing(Post::getTitulo));
        for (Post postagem : postagens) {
            if (postagem.getCategoria().compareTo(categoria) == 0) {
                postsPorCategoria.add(postagem);
            }
        }
        return postsPorCategoria;
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> todosPostsPorCategoria = new TreeMap<>();
        for (Post postagem : postagens) {
            todosPostsPorCategoria.merge(
                    postagem.getCategoria(),
                    criarSetOrdenadoPorTitulo(postagem),
                    (conjuntoExistente, novoPostSet) -> {
                        conjuntoExistente.addAll(novoPostSet);
                        return conjuntoExistente;
                    }
            );
        }
        return todosPostsPorCategoria;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        Map<Autor, Set<Post>> todosPostsPorAutor = new TreeMap<>();
        for (Post postagem : postagens) {
            todosPostsPorAutor.merge(
                    postagem.getAutor(),
                    criarSetOrdenadoPorTitulo(postagem),
                    (conjuntoExistente, novoPostSet) -> {
                        conjuntoExistente.addAll(novoPostSet);
                        return conjuntoExistente;
                    }
            );
        }
        return todosPostsPorAutor;
    }

    private Set<Post> criarSetOrdenadoPorTitulo(Post postagem) {
        TreeSet<Post> setOrdenado = new TreeSet<>(Comparator.comparing(Post::getTitulo));
        setOrdenado.add(postagem);
        return setOrdenado;
    }
}
