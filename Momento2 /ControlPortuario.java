import java.util.Scanner;

public class ControlPortuario {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Contenedor[] manifiesto = new Contenedor[5];
        Patio patio = new Patio(3, 3);
        Inspeccion inspeccion = new Inspeccion();
        Buque buque = new Buque();

        double totalPeso = 0;

        
        for (int i = 0; i < manifiesto.length; i++) {
            System.out.println("Contenedor #" + i);

            System.out.print("ID: ");
            String id = sc.nextLine();

            System.out.print("Peso: ");
            double peso = sc.nextDouble();

            System.out.print("Prioridad: ");
            int prioridad = sc.nextInt();
            sc.nextLine();

            Contenedor c = new Contenedor(id, peso, prioridad);
            manifiesto[i] = c;
            totalPeso += peso;

            
            if (!patio.ubicarContenedor(c)) {
                System.out.println("Puerto saturado");
            }

            
            if (prioridad == 1) {
                inspeccion.agregar(c);
            }

            // MÓDULO 4: BUQUE
            buque.cargar(c);
        }

        System.out.println("Peso total: " + totalPeso);

        
        inspeccion.procesar();

        sc.close();
    }
}
