public class Suministro {

    String id;
    int nivelEnergia;
    String prioridad;

    public Suministro(String id, int nivelEnergia, String prioridad) {
        this.id = id;
        this.nivelEnergia = nivelEnergia;
        this.prioridad = prioridad;
    }

    public String toString() {
        return id + " | Energia: " + nivelEnergia + " | Prioridad: " + prioridad;
    }
}