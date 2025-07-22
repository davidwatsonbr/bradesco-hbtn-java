public class PessoasArray {

    private String[] nomes;

    public PessoasArray() {
        nomes =new String[]{"Amanda", "Beatriz", "Carlos","Daniela","Eduardo",
                "Fabio","Gustavo", "Hingrid","Isabela","Joao","Leise","Maria",
                "Norberto","Otavio","Paulo", "Quirino","Renata","Sabata",
                "Tais","Umberto","Vanessa","Xavier"};
    }

    public String[] getNomes() {
        return nomes;
    }

    public void setNomes(String[] nomes) {
        this.nomes = nomes;
    }

    // implementar o método de buscaBinaria
    public void buscaBinaria(String nome){
        boolean encontrado = false;
        int inicio = 0;
        int fim = getNomes().length - 1;

        System.out.println(String.format("Procurando o nome: \"%s\"", nome));
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            int comparacao = nome.compareTo(getNomes()[meio]);
            System.out.println(String.format("Passando pelo indice: %d", meio));
            if (comparacao == 0) {
                encontrado = true;
                System.out.println(String.format("Nome %s encontrado na posição %d", nome, meio));
                return;
            } else if (comparacao < 0) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }
        if (!encontrado) {
            throw new IllegalArgumentException(String.format("O nome %s não se encontra no array de nomes", nome));
        }
    }
}