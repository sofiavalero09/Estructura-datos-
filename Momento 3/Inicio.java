import java.util.Scanner;

public class principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        GestionEstudiantes gestion =
                new GestionEstudiantes();

        int opcion;

        do {

            System.out.println("\n===== SISTEMA UNIVERSITARIO =====");

            System.out.println("1. Registrar estudiante");
            System.out.println("2. Buscar estudiante");
            System.out.println("3. Listar estudiantes");
            System.out.println("4. Eliminar estudiante");
            System.out.println("5. Deshacer eliminar");
            System.out.println("6. Mostrar facultades");
            System.out.println("7. Salir");

            System.out.print("Seleccione: ");

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

                    gestion.mostrarFacultades();

                    break;
            }

        } while (opcion != 7);

        System.out.println("Fin del programa");
    }
}