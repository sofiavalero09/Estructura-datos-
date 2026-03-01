public class Ejecutarproductinve {
    public static void main(String[] args) {

        Inventario inv = new Inventario(8);

        inv.agregarProducto(new Producto(1, "Mouse", 25000, 10));
        inv.agregarProducto(new Producto(2, "Teclado", 50000, 3));
        inv.agregarProducto(new Producto(3, "Monitor", 800000, 2));
        inv.agregarProducto(new Producto(4, "USB", 15000, 20));
        inv.agregarProducto(new Producto(5, "Audifonos", 70000, 4));
        inv.agregarProducto(new Producto(6, "Laptop", 2500000, 1));
        inv.agregarProducto(new Producto(7, "Impresora", 600000, 6));
        inv.agregarProducto(new Producto(8, "Camara", 1200000, 2));

        System.out.println("Buscar ID 2: " + inv.buscarPorId(2));

        inv.actualizarStock(2, 15);

        System.out.println("Valor total: " + inv.generarInformeValorTotal());

        inv.ordenarPorPrecioDescendente();

        System.out.println("Inventario ordenado:");
        System.out.println(inv);
    }
}