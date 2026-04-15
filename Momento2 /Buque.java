import java.util.Stack;

public class Buque {

    private Stack<Contenedor> pila = new Stack<>();

    public void cargar(Contenedor c) {
        if (pila.isEmpty()) {
            pila.push(c);
        } else {
            Contenedor tope = pila.peek();

            // BONO: control de peso
            if (c.peso <= tope.peso) {
                pila.push(c);
            } else {
                System.out.println("No se puede cargar " + c.id);
            }
        }
    }

    // EXTRA: pila auxiliar
    public void eliminarFondo() {
        Stack<Contenedor> aux = new Stack<>();

        while (pila.size() > 1) {
            aux.push(pila.pop());
        }

        System.out.println("Eliminado: " + pila.pop().id);

        while (!aux.isEmpty()) {
            pila.push(aux.pop());
        }
    }
}