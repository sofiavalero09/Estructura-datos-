import java.util.HashMap;

public class GestionMaterias {

    private HashMap<String,
            Materia> materias =
            new HashMap<>();

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

    public void inscribir(
            Estudiante e,
            String codigo)
            throws CupoLlenoException,
            PreRequisitoNoAprobadoException {

        Materia m =
                materias.get(codigo);

        if (m == null) {

            System.out.println(
                    "Materia no existe"
            );

            return;
        }

        for (String pre :
                m.getPrerequisitos()) {

            if (!e.aproboMateria(pre)) {

                throw new PreRequisitoNoAprobadoException(
                        "No cumple prerrequisito: "
                                + pre
                );
            }
        }

        if (m.getInscritos().size()
                >= m.getCupos()) {

            m.getColaEspera().add(e);

            throw new CupoLlenoException(
                    "Materia llena"
            );
        }

        m.getInscritos().add(e);

        e.getHistorial().add(codigo);

        System.out.println(
                "Inscripcion exitosa"
        );
    }

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

    public void mostrarPrerequisitos(
            String codigo) {

        Materia m =
                materias.get(codigo);

        if (m != null) {

            m.mostrarPrerequisitos();
        }
    }
}