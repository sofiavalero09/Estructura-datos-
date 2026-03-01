import java.util.Arrays;

public class Inventario {
    private Producto[] productos;

    public Inventario(int tamaño) {
        productos = new Producto[tamaño];
    }

    public boolean agregarProducto(Producto p) {
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] == null) {
                productos[i] = p;
                return true;
            }
        }
        return false;
    }

    public Producto buscarPorId(int id) {
        for (Producto p : productos) {
            if (p != null && p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public boolean actualizarStock(int id, int nuevaCantidad) {
        Producto p = buscarPorId(id);
        if (p != null) {
            p.setCantidadStock(nuevaCantidad);
            return true;
        }
        return false;
    }

    public double generarInformeValorTotal() {
        double total = 0;
        for (Producto p : productos) {
            if (p != null) {
                total += p.getPrecio() * p.getCantidadStock();
            }
        }
        return total;
    }

    public void ordenarPorPrecioDescendente() {
        for (int i = 0; i < productos.length - 1; i++) {
            for (int j = 0; j < productos.length - 1 - i; j++) {
                if (productos[j] != null && productos[j + 1] != null &&
                    productos[j].getPrecio() < productos[j + 1].getPrecio()) {

                    Producto temp = productos[j];
                    productos[j] = productos[j + 1];
                    productos[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(productos);
    }
}
