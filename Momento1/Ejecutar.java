import java.util.Scanner;
import java.util.Random;

public class Ejecutar {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        Buque[] buques = new Buque[10];
        Matriz gestion = new Matriz();

        int opcion;

        do {

            System.out.println("1 Registrar Buque");
            System.out.println("2 Registrar Contenedor");
            System.out.println("3 Mostrar Peso Total");
            System.out.println("4 Mostrar Matriz");
            System.out.println("5 Agrupar por Origen");
            System.out.println("6 Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {

                for (int i = 0; i < buques.length; i++) {

                    if (buques[i] == null) {

                        System.out.print("Nombre del buque: ");
                        String nombre = sc.nextLine();

                        System.out.print("Capacidad: ");
                        int capacidad = sc.nextInt();
                        sc.nextLine();

                        buques[i] = new Buque(nombre, capacidad);

                        System.out.println("Buque registrado");
                        break;
                    }
                }
            }

            else if (opcion == 2) {

                System.out.print("Codigo: ");
                String codigo = sc.nextLine();

                System.out.print("Origen: ");
                String origen = sc.nextLine();

                int peso = r.nextInt(26) + 10;

                int columna = r.nextInt(10);

                System.out.println("Peso generado: " + peso);
                System.out.println("Columna asignada: " + columna);

                Contenedor nuevo = new Contenedor(codigo, origen, peso);

                gestion.registrarContenedor(columna, nuevo);
            }

            else if (opcion == 3) {

                System.out.println("Peso total: " + gestion.calcularPesoTotal());
            }

            else if (opcion == 4) {

                gestion.mostrarMatriz();
            }

            else if (opcion == 5) {

                gestion.agruparOrigen();
            }

        } while (opcion != 6);

        System.out.println("Fin");
    }
}