import java.util.LinkedList;
import java.util.Queue;

public class Materia {

    private String codigo;
    private String nombre;
    private int cupos;
    private int creditos;

    // LISTA ENLAZADA
    private LinkedList<String> prerequisitos =
            new LinkedList<>();

    // COLA
    private Queue<Estudiante> colaEspera =
            new LinkedList<>();

    // LISTA
    private LinkedList<Estudiante> inscritos =
            new LinkedList<>();

    public Materia(String codigo,
                   String nombre,
                   int cupos,
                   int creditos) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.cupos = cupos;
        this.creditos = creditos;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCupos() {
        return cupos;
    }

    public Queue<Estudiante> getColaEspera() {
        return colaEspera;
    }

    public LinkedList<Estudiante> getInscritos() {
        return inscritos;
    }

    public void agregarPrerequisito(
            String codigo) {

        prerequisitos.add(codigo);
    }

    public void mostrarPrerequisitos() {

        for (String p : prerequisitos) {

            System.out.println(p);
        }
    }
}