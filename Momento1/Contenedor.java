public class Contenedor {

    private String codigo;
    private String origen;
    private double peso;

    public Contenedor(String codigo, double peso2, double peso) {
        this.codigo = codigo;
        this.origen = peso2;
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

    public int getPrioridad() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPrioridad'");
    }

    public String getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }
}