import java.util.Scanner;
import java.util.Random;

public class Ejecutar {

    static Buque[] buques = new Buque[10];
    static GestionMatriz gestion = new GestionMatriz();
    static Scanner sc = new Scanner(System.in);
    static Random r = new Random();

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("MENU PRINCIPAL");
            System.out.println("1. Registrar Buque");
            System.out.println("2. Registrar Contenedor");
            System.out.println("3. Mostrar Peso Total");
            System.out.println("4. Mostrar Matriz");
            System.out.println("5. Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    registrarBuque();
                    break;

                case 2:
                    registrarContenedor();
                    break;

                case 3:
                    System.out.println("Peso total: " + gestion.calcularPesoTotal());
                    break;

                case 4:
                    gestion.mostrarMatriz();
                    break;

                case 5:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 5);
    }

    public static void registrarBuque() {

        for (int i = 0; i < buques.length; i++) {
            if (buques[i] == null) {

                System.out.print("Nombre del buque: ");
                String nombre = sc.nextLine();

                System.out.print("Capacidad: ");
                int capacidad = sc.nextInt();
                sc.nextLine();

                buques[i] = new Buque(nombre, capacidad);
                System.out.println("Buque registrado en posición " + i);
                return;
            }
        }

        System.out.println("No hay espacio para más buques.");
    }

    public static void registrarContenedor() {

        System.out.print("Columna (0-9): ");
        int col = sc.nextInt();
        sc.nextLine();

        System.out.print("Código: ");
        String codigo = sc.nextLine();

        System.out.print("Origen: ");
        String origen = sc.nextLine();

      
        int min = 10;
        int max = 35;
        double peso = r.nextInt((max - min + 1)) + min;

        System.out.println("Peso generado automáticamente: " + peso);

        Contenedores nuevo = new Contenedores(codigo, origen, peso);
        gestion.registrarContenedor(col, nuevo);
    }
}