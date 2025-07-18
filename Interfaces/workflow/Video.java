public class Video {
    private String arquivo;
    private FormatoVideo formato;

    public Video() {}

    public Video(String arquivo, FormatoVideo formato) {
        setArquivo(arquivo);
        setFormato(formato);
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public FormatoVideo getFormato() {
        return formato;
    }

    public void setFormato(FormatoVideo formato) {
        this.formato = formato;
    }
}
