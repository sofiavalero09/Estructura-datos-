import java.util.TreeMap;

public class GestionHorarios {

    // TREEMAP
    private TreeMap<String, Aula>
            aulas = new TreeMap<>();

    public void agregarAula(
            String nombre) {

        aulas.put(
                nombre,
                new Aula(nombre)
        );
    }

    public Aula buscarAula(
            String nombre) {

        return aulas.get(nombre);
    }
}