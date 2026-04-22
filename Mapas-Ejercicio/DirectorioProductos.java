import java.util.HashMap;

public class DirectorioProductos {

    public static void main(String[] args) {

        
        HashMap<Integer, String> productos = new HashMap<>();

       
        productos.put(101, "Laptop");
        productos.put(102, "Mouse");
        productos.put(103, "Teclado");

       
        if (productos.containsKey(102)) {
            System.out.println("La clave 102 sí existe.");
        } else {
            System.out.println("La clave 102 no existe.");
        }

        
        productos.put(101, "Monitor");

        
        System.out.println("Producto con código 101: " + productos.get(101));

        
        System.out.println("Listado de productos:");

        for (Integer clave : productos.keySet()) {
            System.out.println("Código: " + clave + " -> Producto: " + productos.get(clave));
        }
    }
}