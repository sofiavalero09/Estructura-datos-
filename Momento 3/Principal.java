import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc =
                new Scanner(System.in);

        GestionEstudiantes gestion =
                new GestionEstudiantes();

        GestionMaterias materias =
                new GestionMaterias();

        GestionHorarios horarios =
                new GestionHorarios();

        int opcion;

        do {

            System.out.println(
                    "\n===== SISTEMA UNIVERSITARIO ====="
            );

            System.out.println(
                    "1. Registrar estudiante"
            );

            System.out.println(
                    "2. Buscar estudiante"
            );

            System.out.println(
                    "3. Listar estudiantes"
            );

            System.out.println(
                    "4. Eliminar estudiante"
            );

            System.out.println(
                    "5. Deshacer eliminar"
            );

            System.out.println(
                    "6. Crear materia"
            );

            System.out.println(
                    "7. Inscribir estudiante"
            );

            System.out.println(
                    "8. Mostrar cola espera"
            );

            System.out.println(
                    "9. Agregar aula"
            );

            System.out.println(
                    "10. Reservar aula"
            );

            System.out.println(
                    "11. Mostrar facultades"
            );

            System.out.println(
                    "12. Salir"
            );

            System.out.print(
                    "Seleccione: "
            );

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("ID: ");
                    String id = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Semestre: ");
                    int semestre = sc.nextInt();
                    sc.nextLine();

                    Estudiante e =
                            new Estudiante(
                                    id,
                                    nombre,
                                    email,
                                    semestre
                            );

                    gestion.registrar(e);

                    break;

                case 2:

                    try {

                        System.out.print("ID: ");

                        String buscar =
                                sc.nextLine();

                        Estudiante encontrado =
                                gestion.buscar(buscar);

                        encontrado.mostrarInformacion();

                    } catch (Exception ex) {

                        System.out.println(
                                ex.getMessage()
                        );
                    }

                    break;

                case 3:

                    gestion.listar();

                    break;

                case 4:

                    try {

                        System.out.print("ID: ");

                        String eliminar =
                                sc.nextLine();

                        gestion.eliminar(eliminar);

                    } catch (Exception ex) {

                        System.out.println(
                                ex.getMessage()
                        );
                    }

                    break;

                case 5:

                    gestion.deshacerEliminar();

                    break;

                case 6:

                    System.out.print(
                            "Codigo: "
                    );

                    String codigo =
                            sc.nextLine();

                    System.out.print(
                            "Nombre: "
                    );

                    String nom =
                            sc.nextLine();

                    System.out.print(
                            "Cupos: "
                    );

                    int cupos =
                            sc.nextInt();

                    System.out.print(
                            "Creditos: "
                    );

                    int creditos =
                            sc.nextInt();

                    sc.nextLine();

                    Materia m =
                            new Materia(
                                    codigo,
                                    nom,
                                    cupos,
                                    creditos
                            );

                    materias.crearMateria(m);

                    break;

                case 7:

                    try {

                        System.out.print(
                                "ID estudiante: "
                        );

                        String idEst =
                                sc.nextLine();

                        Estudiante est =
                                gestion.buscar(idEst);

                        System.out.print(
                                "Codigo materia: "
                        );

                        String cod =
                                sc.nextLine();

                        materias.inscribir(
                                est,
                                cod
                        );

                    } catch (Exception ex) {

                        System.out.println(
                                ex.getMessage()
                        );
                    }

                    break;

                case 8:

                    System.out.print(
                            "Codigo materia: "
                    );

                    String c =
                            sc.nextLine();

                    materias.mostrarCola(c);

                    break;

                case 9:

                    System.out.print(
                            "Nombre aula: "
                    );

                    String aula =
                            sc.nextLine();

                    horarios.agregarAula(aula);

                    break;

                case 10:

                    try {

                        System.out.print(
                                "Aula: "
                        );

                        String a =
                                sc.nextLine();

                        Aula au =
                                horarios.buscarAula(a);

                        System.out.print(
                                "Dia: "
                        );

                        int dia =
                                sc.nextInt();

                        System.out.print(
                                "Hora: "
                        );

                        int hora =
                                sc.nextInt();

                        System.out.print(
                                "Duracion: "
                        );

                        int duracion =
                                sc.nextInt();

                        sc.nextLine();

                        au.reservar(
                                dia,
                                hora,
                                duracion
                        );

                    } catch (Exception ex) {

                        System.out.println(
                                ex.getMessage()
                        );
                    }

                    break;

                case 11:

                    gestion.mostrarFacultades();

                    break;
            }

        } while (opcion != 12);

        System.out.println(
                "Fin del programa"
        );
    }
}