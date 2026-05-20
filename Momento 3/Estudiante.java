import java.util.LinkedList;
import java.util.Queue;

public class Estudiante extends Persona {

    private int semestre;

    private Double[][] notas =
            new Double[10][20];

    private Queue<String> historial =
            new LinkedList<>();

    public Estudiante(
            String id,
            String nombre,
            String email,
            int semestre) {

        super(id, nombre, email);

        this.semestre = semestre;
    }

    public int getSemestre() {
        return semestre;
    }

    public Queue<String> getHistorial() {
        return historial;
    }

    public void registrarNota(
            int semestre,
            int materia,
            double nota) {

        notas[semestre][materia] = nota;
    }

    public boolean aproboMateria(
            String codigo) {

        return historial.contains(codigo);
    }

    public double calcularPromedio() {

        double suma = 0;
        int cantidad = 0;

        for (int i = 0;
             i < notas.length;
             i++) {

            for (int j = 0;
                 j < notas[i].length;
                 j++) {

                if (notas[i][j] != null) {

                    suma += notas[i][j];
                    cantidad++;
                }
            }
        }

        if (cantidad == 0) {

            return 0;
        }

        return suma / cantidad;
    }

    @Override
    public void mostrarInformacion() {

        System.out.println(
                "ID: " + id
        );

        System.out.println(
                "Nombre: " + nombre
        );

        System.out.println(
                "Email: " + email
        );

        System.out.println(
                "Semestre: " + semestre
        );

        System.out.println(
                "Promedio: "
                        + calcularPromedio()
        );
    }
}