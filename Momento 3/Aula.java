public class Aula {

    private String nombre;

    private boolean[][] horarios =
            new boolean[7][24];

    public Aula(String nombre) {

        this.nombre = nombre;
    }

    public String getNombre() {

        return nombre;
    }

    public void reservar(
            int dia,
            int hora,
            int duracion)
            throws HorarioConflictivoException {

        for (int i = hora;
             i < hora + duracion;
             i++) {

            if (horarios[dia][i]) {

                throw new HorarioConflictivoException(
                        "Horario ocupado"
                );
            }
        }

        for (int i = hora;
             i < hora + duracion;
             i++) {

            horarios[dia][i] = true;
        }

        System.out.println(
                "Reserva exitosa"
        );
    }

    public void liberar(
            int dia,
            int hora,
            int duracion) {

        for (int i = hora;
             i < hora + duracion;
             i++) {

            horarios[dia][i] = false;
        }

        System.out.println(
                "Horario liberado"
        );
    }

    public void consultar(
            int dia,
            int hora) {

        if (horarios[dia][hora]) {

            System.out.println(
                    "Horario ocupado"
            );

        } else {

            System.out.println(
                    "Horario disponible"
            );
        }
    }
}