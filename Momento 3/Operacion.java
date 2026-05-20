public class Operacion {

    private String tipo;
    private Estudiante estudiante;

    public Operacion(
            String tipo,
            Estudiante estudiante) {

        this.tipo = tipo;
        this.estudiante = estudiante;
    }

    public String getTipo() {

        return tipo;
    }

    public Estudiante getEstudiante() {

        return estudiante;
    }
}