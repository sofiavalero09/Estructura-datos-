 import java.util.LinkedList;
 
 public class HistorialNavegacion{
     public static void main(String[] args) {

        LinkedList<String> historial = new LinkedList<>();

        historial.add("google.com");
        historial.add("github.com");
        historial.add("stackoverflow.com");

        System.out.println("Página actual: " + historial.getLast());

        historial.removeLast();

        System.out.println("Después de ir atrás: " + historial.getLast());

        System.out.println("Historial restante:");

        for (String pagina : historial) {
            System.out.println(pagina);
        }
    }
}