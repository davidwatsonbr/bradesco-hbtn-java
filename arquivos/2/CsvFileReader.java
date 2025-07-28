import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReader {
    public static void main(String[] args) {
        String filename = "funcionarios.csv";
        String linha;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            while ((linha = bufferedReader.readLine()) != null) {
                String[] dados = linha.split(",");
                System.out.println(String.format("Funcionário: %s", dados[0]));
                System.out.println(String.format("Idade: %s", dados[1]));
                System.out.println(String.format("Departamento: %s", dados[2]));
                System.out.println(String.format("Salarial: %s", dados[3]));
                System.out.println("------------------------");
            }

            System.out.println("Leitura do arquivo concluída.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }            
    }
}
