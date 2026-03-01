public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int cantidadStock;

    public Producto(int id, String nombre, double precio, int cantidadStock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getCantidadStock() { return cantidadStock; }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    @Override
    public String toString() {
        return nombre + " - $" + precio + " - stock: " + cantidadStock;
    }
}
