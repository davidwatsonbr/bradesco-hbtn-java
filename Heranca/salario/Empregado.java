public class Empregado {
    private final double salarioFixo;

    public Empregado(double salarioFixo) {
        this.salarioFixo = salarioFixo;
    }

    public double calcularBonus(Departamento departamento) {
        if (departamento.alcancouMeta()) {
            return (getSalarioFixo() * 0.10);
        }
        return (0.0);
    }

    public double calcularSalarioTotal(Departamento departamento) {
        return (getSalarioFixo() + calcularBonus(departamento));
    }

    public double getSalarioFixo() {
        return salarioFixo;
    }
}