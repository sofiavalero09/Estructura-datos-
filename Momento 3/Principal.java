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

        RutaCampus rutas =
                new RutaCampus();

        ProcesadorBatch batch =
                new ProcesadorBatch();

        NavegadorReportes nav =
                new NavegadorReportes();

        rutas.conectar(0,1,100);
        rutas.conectar(1,2,120);
        rutas.conectar(2,3,150);
        rutas.conectar(3,4,200);

        int opcion;

        do {

            System.out.println(
                    "SISTEMA UNIVERSITARIO"
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
                    "5. Deshacer"
            );

            System.out.println(
                    "6. Rehacer"
            );

            System.out.println(
                    "7. Crear materia"
            );

            System.out.println(
                    "8. Inscribir estudiante"
            );

            System.out.println(
                    "9. Mostrar cola"
            );

            System.out.println(
                    "10. Agregar prerequisito"
            );

            System.out.println(
                    "11. Mostrar prerequisitos"
            );

            System.out.println(
                    "12. Agregar aula"
            );

            System.out.println(
                    "13. Reservar aula"
            );

            System.out.println(
                    "14. Liberar aula"
            );

            System.out.println(
                    "15. Consultar aula"
            );

            System.out.println(
                    "16. Registrar nota"
            );

            System.out.println(
                    "17. Ruta mas corta"
            );

            System.out.println(
                    "18. Mostrar facultades"
            );

            System.out.println(
                    "19. Procesar CSV"
            );

            System.out.println(
                    "20. Navegador reportes"
            );

            System.out.println(
                    "21. Salir"
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

                    try {

                        gestion.deshacer();

                    } catch (Exception ex) {

                        System.out.println(
                                ex.getMessage()
                        );
                    }

                    break;

                case 6:

                    try {

                        gestion.rehacer();

                    } catch (Exception ex) {

                        System.out.println(
                                ex.getMessage()
                        );
                    }

                    break;

                case 7:

                    System.out.print("Codigo: ");
                    String codigo = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nom = sc.nextLine();

                    System.out.print("Cupos: ");
                    int cupos = sc.nextInt();

                    System.out.print("Creditos: ");
                    int creditos = sc.nextInt();

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

                case 8:

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

                        try {
                            java.lang.reflect.Method inscribir =
                                    materias.getClass().getMethod(
                                            "inscribir",
                                            Estudiante.class,
                                            String.class
                                    );
                            inscribir.invoke(
                                    materias,
                                    est,
                                    cod
                            );
                        } catch (java.lang.reflect.InvocationTargetException ex) {
                            Throwable causa = ex.getCause();
                            System.out.println(
                                    causa != null ?
                                            causa.getMessage() :
                                            ex.getMessage()
                            );
                        }

                    } catch (Exception ex) {

                        System.out.println(
                                ex.getMessage()
                        );
                    }

                    break;

                case 9:

                    System.out.print(
                            "Codigo materia: "
                    );

                    String c =
                            sc.nextLine();

                    materias.mostrarCola(c);

                    break;

                case 10:

                    System.out.print(
                            "Materia: "
                    );

                    String mat =
                            sc.nextLine();

                    System.out.print(
                            "Prerequisito: "
                    );

                    String pre =
                            sc.nextLine();

                    materias.agregarPrerequisito(
                            mat,
                            pre
                    );

                    break;

                case 11:

                    System.out.print(
                            "Codigo materia: "
                    );

                    String mp =
                            sc.nextLine();

                    materias.mostrarPrerequisitos(mp);

                    break;

                case 12:

                    System.out.print(
                            "Nombre aula: "
                    );

                    String aula =
                            sc.nextLine();

                    horarios.agregarAula(aula);

                    break;

                case 13:

                    try {

                        System.out.print("Aula: ");
                        String a = sc.nextLine();

                        Aula au =
                                horarios.buscarAula(a);

                        System.out.print("Dia: ");
                        int dia = sc.nextInt();

                        System.out.print("Hora: ");
                        int hora = sc.nextInt();

                        System.out.print("Duracion: ");
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

                case 14:

                    System.out.print("Aula: ");
                    String aula2 =
                            sc.nextLine();

                    Aula au2 =
                            horarios.buscarAula(aula2);

                    System.out.print("Dia: ");
                    int dia2 =
                            sc.nextInt();

                    System.out.print("Hora: ");
                    int hora2 =
                            sc.nextInt();

                    System.out.print("Duracion: ");
                    int dur2 =
                            sc.nextInt();

                    sc.nextLine();

                    au2.liberar(
                            dia2,
                            hora2,
                            dur2
                    );

                    break;

                case 15:

                    System.out.print("Aula: ");
                    String aula3 =
                            sc.nextLine();

                    Aula au3 =
                            horarios.buscarAula(aula3);

                    System.out.print("Dia: ");
                    int dia3 =
                            sc.nextInt();

                    System.out.print("Hora: ");
                    int hora3 =
                            sc.nextInt();

                    sc.nextLine();

                    au3.consultar(
                            dia3,
                            hora3
                    );

                    break;

                case 16:

                    try {

                        System.out.print(
                                "ID estudiante: "
                        );

                        String idN =
                                sc.nextLine();

                        Estudiante es =
                                gestion.buscar(idN);

                        System.out.print(
                                "Semestre: "
                        );

                        int sem =
                                sc.nextInt();

                        System.out.print(
                                "Materia posicion: "
                        );

                        int matPos =
                                sc.nextInt();

                        System.out.print(
                                "Nota: "
                        );

                        double nota =
                                sc.nextDouble();

                        sc.nextLine();

                        es.registrarNota(
                                sem,
                                matPos,
                                nota
                        );

                        nav.verReporte(
                                "Reporte de "
                                        + es.getNombre()
                        );

                        System.out.println(
                                "Nota registrada"
                        );

                    } catch (Exception ex) {

                        System.out.println(
                                ex.getMessage()
                        );
                    }

                    break;

                case 17:

                    rutas.mostrarEdificios();

                    System.out.print(
                            "Origen: "
                    );

                    int o =
                            sc.nextInt();

                    System.out.print(
                            "Destino: "
                    );

                    int d =
                            sc.nextInt();

                    sc.nextLine();

                    rutas.rutaMasCorta(
                            o,
                            d
                    );

                    break;

                case 18:

                    gestion.mostrarFacultades();

                    break;

                case 19:

                    try {

                        System.out.print(
                                "Archivo CSV: "
                        );

                        String archivo =
                                sc.nextLine();

                        batch.cargarArchivo(
                                archivo
                        );

                        batch.procesar(
                                gestion,
                                materias
                        );

                    } catch (Exception ex) {

                        System.out.println(
                                ex.getMessage()
                        );
                    }

                    break;

                case 20:

                    nav.atras();
                    nav.adelante();

                    break;
            }

        } while (opcion != 21);

        System.out.println(
                "Fin del programa"
        );
    }
}