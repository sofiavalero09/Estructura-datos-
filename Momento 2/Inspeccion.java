import java.util.LinkedList;
import java.util.Queue;

public class Inspeccion {

    private Queue<Contenedor> cola = new LinkedList<>();

    public void agregar(Contenedor c) {
        cola.add(c);
        System.out.println("Enviado a inspección: " + c.getId());
    }

    public void procesar(Buque buque) {
        System.out.println("INICIANDO INSPECCIÓN ");

        while (!cola.isEmpty()) {
            Contenedor c = cola.poll();
            System.out.println("Inspeccionando: " + c.getId());

            
            buque.cargar(c);
        }
    }
}
