import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SistemaPedidos {

    public static void main(String[] args) {

        Map<String, LinkedList<String>> pedidos = new HashMap<>();

        LinkedList<String> listaAna = new LinkedList<>();
        listaAna.add("Camisa");
        listaAna.add("Pantalón");
        pedidos.put("Ana", listaAna);

        LinkedList<String> listaLuis = new LinkedList<>();
        listaLuis.add("Zapatos");
        pedidos.put("Luis", listaLuis);

        System.out.println("Productos de Ana: " + pedidos.get("Ana").size());

        pedidos.get("Luis").add("Camisa");

        System.out.println("Pedidos completos:");

        for (String cliente : pedidos.keySet()) {
            System.out.println(cliente + ": " + pedidos.get(cliente));
        }
    }
}