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

    // implementar o método de buscaLinear
    public void buscaLinear(String nome){
        boolean encontrado = false;
        System.out.println(String.format("Procurando pelo nome: \"%s\"", nome));
        for (int i = 0; i < getNomes().length; i++) {
            System.out.println(String.format("Passando pelo indice:%d", i));
            if (nomes[i] == nome) {
                encontrado = true;
                System.out.println(String.format("Nome pesquisado é %s que está na posição %d", nome, i));
            }
        }
        if (!encontrado) {
            throw new IllegalArgumentException(String.format("O nome %s não se encontra no array de nomes", nome));
        }
    }
}