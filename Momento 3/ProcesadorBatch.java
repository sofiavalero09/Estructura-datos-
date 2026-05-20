import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;

public class ProcesadorBatch {

    private Queue<Solicitud> cola =
            new LinkedList<>();

    public void cargarArchivo(
            String archivo)
            throws ArchivoInvalidoException {

        try {

            BufferedReader br =
                    new BufferedReader(
                            new FileReader(archivo)
                    );

            String linea;

            while ((linea = br.readLine())
                    != null) {

                String[] partes =
                        linea.split(",");

                cola.add(
                        new Solicitud(
                                partes[0],
                                partes[1]
                        )
                );
            }

            br.close();

            System.out.println(
                    "Solicitudes cargadas: "
                            + cola.size()
            );

        } catch (Exception e) {

            throw new ArchivoInvalidoException(
                    "Error leyendo archivo"
            );
        }
    }

    public void procesar(
            GestionEstudiantes ge,
            GestionMaterias gm) {

        while (!cola.isEmpty()) {

            Solicitud s =
                    cola.poll();

            try {

                Estudiante e =
                        ge.buscar(
                                s.getIdEstudiante()
                        );

                gm.inscribir(
                        e,
                        s.getCodigoMateria()
                );

                System.out.println(
                        "Inscripcion exitosa"
                );

            } catch (Exception ex) {

                System.out.println(
                        ex.getMessage()
                );
            }
        }
    }
}