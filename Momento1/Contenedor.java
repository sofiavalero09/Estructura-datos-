public class Contenedor {

    private String codigo;
    private String origen;
    private double peso;

    public Contenedor(String codigo, String origen, double peso) {
        this.codigo = codigo;
        this.origen = origen;
        this.peso = peso;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getOrigen() {
        return origen;
    }

    public double getPeso() {
        return peso;
    }
}