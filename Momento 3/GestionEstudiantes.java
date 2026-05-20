import java.util.HashMap;
import java.util.Stack;

public class GestionEstudiantes {

    private HashMap<String,
            Estudiante> estudiantes =
            new HashMap<>();

    private Stack<Operacion>
            pilaDeshacer =
            new Stack<>();

    private Stack<Operacion>
            pilaRehacer =
            new Stack<>();

    private Facultad[] facultades =
            new Facultad[5];

    public GestionEstudiantes() {

        facultades[0] =
                new Facultad("Ingenieria");

        facultades[1] =
                new Facultad("Medicina");

        facultades[2] =
                new Facultad("Derecho");

        facultades[3] =
                new Facultad("Arquitectura");

        facultades[4] =
                new Facultad("Administracion");
    }

    public void registrar(
            Estudiante e) {

        estudiantes.put(
                e.getId(),
                e
        );

        System.out.println(
                "Estudiante registrado"
        );
    }

    public Estudiante buscar(
            String id)
            throws EstudianteNoEncontradoException {

        if (!estudiantes.containsKey(id)) {

            throw new EstudianteNoEncontradoException(
                    "No existe estudiante"
            );
        }

        return estudiantes.get(id);
    }

    public void listar() {

        for (Estudiante e :
                estudiantes.values()) {

            e.mostrarInformacion();

            System.out.println(
                    "-------------"
            );
        }
    }

    public void eliminar(
            String id)
            throws EstudianteNoEncontradoException {

        Estudiante e =
                buscar(id);

        pilaDeshacer.push(
                new Operacion(
                        "ELIMINAR",
                        e
                )
        );

        estudiantes.remove(id);

        System.out.println(
                "Eliminado"
        );
    }

    public void deshacer()
            throws PilaDeshacerVaciaException {

        if (pilaDeshacer.empty()) {

            throw new PilaDeshacerVaciaException(
                    "Nada para deshacer"
            );
        }

        Operacion op =
                pilaDeshacer.pop();

        estudiantes.put(
                op.getEstudiante().getId(),
                op.getEstudiante()
        );

        pilaRehacer.push(op);

        System.out.println(
                "Operacion deshecha"
        );
    }

    public void rehacer()
            throws PilaDeshacerVaciaException {

        if (pilaRehacer.empty()) {

            throw new PilaDeshacerVaciaException(
                    "Nada para rehacer"
            );
        }

        Operacion op =
                pilaRehacer.pop();

        estudiantes.remove(
                op.getEstudiante().getId()
        );

        pilaDeshacer.push(op);

        System.out.println(
                "Operacion rehecha"
        );
    }

    public void mostrarFacultades() {

        for (Facultad f :
                facultades) {

            System.out.println(
                    f.getNombre()
            );
        }
    }
}