import java.util.Stack;

public class Buque {

    private Stack<Contenedor> pila = new Stack<>();

    public void cargar(Contenedor c) {

        if (pila.isEmpty()) {
            pila.push(c);
            System.out.println("Cargado en buque: " + c.getId());
        } else {
            Contenedor tope = pila.peek();

            
            if (c.getPeso() <= tope.getPeso()) {
                pila.push(c);
                System.out.println("Cargado en buque: " + c.getId());
            } else {
                System.out.println("No se puede cargar " + c.getId() + " (peso mayor al tope)");
            }
        }
    }

    
    public void eliminarFondo() {
        if (pila.isEmpty()) {
            System.out.println("Buque vacío");
            return;
        }

        Stack<Contenedor> aux = new Stack<>();

        while (pila.size() > 1) {
            aux.push(pila.pop());
        }

        System.out.println("Eliminado del fondo: " + pila.pop().getId());

        while (!aux.isEmpty()) {
            pila.push(aux.pop());
        }
    }

    public void mostrar() {
        System.out.println("Contenido del buque:");
        for (Contenedor c : pila) {
            System.out.println(c);
        }
    }
}