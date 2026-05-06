import java.util.HashMap;
import java.util.Stack;

public class GestionEstudiantes {

    // HASHMAP OBLIGATORIO
    private HashMap<String, Estudiante> estudiantes =
            new HashMap<>();

    // PILA PARA DESHACER
    private Stack<Estudiante> eliminados =
            new Stack<>();

    // ARREGLO FIJO OBLIGATORIO
    private Facultad[] facultades =
            new Facultad[5];

    public GestionEstudiantes() {

        facultades[0] = new Facultad("Ingenieria");
        facultades[1] = new Facultad("Medicina");
        facultades[2] = new Facultad("Derecho");
        facultades[3] = new Facultad("Arquitectura");
        facultades[4] = new Facultad("Administracion");
    }

    public void registrar(Estudiante e) {

        estudiantes.put(e.getId(), e);

        System.out.println(
                "Estudiante registrado"
        );
    }

    public Estudiante buscar(String id)
            throws EstudianteNoEncontradoException {

        if (!estudiantes.containsKey(id)) {

            throw new EstudianteNoEncontradoException(
                    "No existe estudiante con ID: " + id
            );
        }

        return estudiantes.get(id);
    }

    public void listar() {

        for (Estudiante e : estudiantes.values()) {

            e.mostrarInformacion();

            System.out.println("----------------");
        }
    }

    public void eliminar(String id)
            throws EstudianteNoEncontradoException {

        Estudiante e = buscar(id);

        eliminados.push(e);

        estudiantes.remove(id);

        System.out.println(
                "Estudiante eliminado"
        );
    }

    public void deshacerEliminar() {

        if (eliminados.empty()) {

            System.out.println(
                    "Nada para recuperar"
            );

            return;
        }

        Estudiante e = eliminados.pop();

        estudiantes.put(e.getId(), e);

        System.out.println(
                "Estudiante restaurado"
        );
    }

    public void mostrarFacultades() {

        for (Facultad f : facultades) {

            System.out.println(
                    f.getNombre()
            );
        }
    }
}