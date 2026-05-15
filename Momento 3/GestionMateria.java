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

    public void inscribir(
            Estudiante e,
            String codigo)
            throws CupoLlenoException {

        Materia m = materias.get(codigo);

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

        Materia m = materias.get(codigo);

        for (Estudiante e :
                m.getColaEspera()) {

            System.out.println(
                    e.getNombre()
            );
        }
    }
}