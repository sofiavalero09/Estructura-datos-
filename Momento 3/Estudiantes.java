import java.util.LinkedList;
import java.util.Queue;

public class Estudiante extends Persona {

    private int semestre;

    // MATRIZ OBLIGATORIA
    private Double[][] notas = new Double[10][20];

    // COLA OBLIGATORIA
    private Queue<String> historial = new LinkedList<>();

    public Estudiante(String id, String nombre,
                       String email, int semestre) {

        super(id, nombre, email);

        this.semestre = semestre;
    }

    public int getSemestre() {
        return semestre;
    }

    public Double[][] getNotas() {
        return notas;
    }

    public Queue<String> getHistorial() {
        return historial;
    }

    @Override
    public void mostrarInformacion() {

        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Email: " + email);
        System.out.println("Semestre: " + semestre);
    }
}