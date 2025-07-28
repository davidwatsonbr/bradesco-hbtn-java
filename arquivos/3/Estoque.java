import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> produtos;
    private String arquivo;

    public Estoque(String arquivo) {
        this.arquivo = arquivo;
        this.produtos = new ArrayList<>();
        carregarProdutos();
    }

    private void carregarProdutos() {
        produtos.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;
                String[] partes = linha.split(",");
                int id = Integer.parseInt(partes[0]);
                String nome = partes[1];
                int quantidade = Integer.parseInt(partes[2]);
                double preco = Double.parseDouble(partes[3]);
                produtos.add(new Produto(id, nome, quantidade, preco));
            }
        } catch (FileNotFoundException e) {
            // Arquivo ainda não existe, será criado ao salvar
        } catch (IOException e) {
            System.out.println("Erro ao carregar produtos: " + e.getMessage());
        }
    }

    private void salvarProdutos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            for (Produto p : produtos) {
                writer.write(p.toCsv());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar produtos: " + e.getMessage());
        }
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {
        int novoId = gerarNovoId();
        Produto novoProduto = new Produto(novoId, nome, quantidade, preco);
        produtos.add(novoProduto);
        salvarProdutos();
        System.out.println("Produto adicionado com sucesso!");
    }

    public void excluirProduto(int id) {
        boolean removido = produtos.removeIf(p -> p.getId() == id);
        if (removido) {
            salvarProdutos();
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }

    public void exibirEstoque() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio.");
        } else {
            for (Produto p : produtos) {
                System.out.println(p);
            }
        }
    }

    public void atualizarQuantidade(int id, int novaQuantidade) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setQuantidade(novaQuantidade);
                salvarProdutos();
                System.out.println("Quantidade atualizada com sucesso!");
                return;
            }
        }
        System.out.println("Produto com ID " + id + " não encontrado.");
    }

    private int gerarNovoId() {
        int maxId = 0;
        for (Produto p : produtos) {
            if (p.getId() > maxId) {
                maxId = p.getId();
            }
        }
        return maxId + 1;
    }
}
