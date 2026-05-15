import java.util.HashMap;

public class GestionMaterias {

    private HashMap<String, Materia>
            materias = new HashMap<>();

    public void crearMateria(
            Materia m) {

        materias.put(
                m.getCodigo(),
                m
        );

        System.out.println(
                "Materia creada"
        );
    }

    public Materia buscarMateria(
            String codigo) {

        return materias.get(codigo);
    }

    // INSCRIBIR
    public void inscribir(
            Estudiante e,
            String codigo)
            throws CupoLlenoException {

        Materia m =
                materias.get(codigo);

        if (m == null) {

            System.out.println(
                    "Materia no existe"
            );

            return;
        }

        // VALIDAR CUPOS
        if (m.getInscritos().size()
                >= m.getCupos()) {

            m.getColaEspera().add(e);

            throw new CupoLlenoException(
                    "Materia llena. Agregado a cola"
            );
        }

        m.getInscritos().add(e);

        e.getHistorial().add(codigo);

        System.out.println(
                "Inscripcion exitosa"
        );
    }

    // MOSTRAR COLA
    public void mostrarCola(
            String codigo) {

        Materia m =
                materias.get(codigo);

        for (Estudiante e :
                m.getColaEspera()) {

            System.out.println(
                    e.getNombre()
            );
        }
    }

    // AGREGAR PRERREQUISITO
    public void agregarPrerequisito(
            String materia,
            String prerequisito) {

        Materia m =
                materias.get(materia);

        if (m != null) {

            m.agregarPrerequisito(
                    prerequisito
            );

            System.out.println(
                    "Prerequisito agregado"
            );
        }
    }

    // MOSTRAR PRERREQUISITOS
    public void mostrarPrerequisitos(
            String codigo) {

        Materia m =
                materias.get(codigo);

        if (m != null) {

            m.mostrarPrerequisitos();
        }
    }
}