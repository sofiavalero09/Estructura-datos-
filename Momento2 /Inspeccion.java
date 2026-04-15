import java.util.LinkedList;
import java.util.Queue;

public class Inspeccion {

    private Queue<Contenedor> cola = new LinkedList<>();

    public void agregar(Contenedor c) {
        cola.add(c);
    }

    public void procesar() {
        while (!cola.isEmpty()) {
            Contenedor c = cola.poll();
            System.out.println("Inspeccionando: " + c.id);
        }
    }
}
