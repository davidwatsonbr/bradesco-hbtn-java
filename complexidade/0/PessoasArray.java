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

    // implementar o método de pesquisaConstante
    public void pesquisaTempoConstante(int id){
        if (id > this.nomes.length) {
            throw new IllegalArgumentException(String.format("O array de nomes possui :%d nomes.", this.nomes.length));
        }

        System.out.println(String.format("Nome pesquisado é %s que está na posição %d", this.nomes[id], id));
    }
}