import java.util.Scanner;

public class ControlPortuario {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Contenedor[] manifiesto = new Contenedor[5];
        Patio patio = new Patio(3, 3);
        Inspeccion inspeccion = new Inspeccion();
        Buque buque = new Buque();

        double totalPeso = 0;

        System.out.println("REGISTRO DE CONTENEDORES");

      
        for (int i = 0; i < manifiesto.length; i++) {

            System.out.println("Contenedor #" + (i + 1));

            System.out.print("ID: ");
            String id = sc.nextLine();

            System.out.print("Peso: ");
            double peso = sc.nextDouble();

            System.out.print("Prioridad (1 = Alta / 2 = Normal): ");
            int prioridad = sc.nextInt();
            sc.nextLine();

            Contenedor c = new Contenedor(id, peso, prioridad);
            manifiesto[i] = c;
            totalPeso += peso;


            patio.ubicarContenedor(c);

            if (c.getPrioridad() == 1) {
                inspeccion.agregar(c);
            } else {
                // Flujo directo al buque si no es prioridad alta
                buque.cargar(c);
            }
        }

        
        System.out.println("Peso total del cargamento: " + totalPeso);

        
        inspeccion.procesar(buque);

        
        patio.mostrar();
        buque.mostrar();

        sc.close();
    }
}