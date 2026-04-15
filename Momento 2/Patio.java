public class Patio {

    private Contenedor[][] matriz;

    public Patio(int filas, int columnas) {
        matriz = new Contenedor[filas][columnas];
    }

    public boolean ubicarContenedor(Contenedor c) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                if (matriz[i][j] == null) {
                    matriz[i][j] = c;
                    System.out.println("Ubicado en patio: [" + i + "," + j + "]");
                    return true;
                }
            }
        }

        System.out.println("Puerto Saturado");
        return false;
    }

    public void mostrar() {
        System.out.println("Estado del patio:");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                if (matriz[i][j] == null) {
                    System.out.print("[Libre] ");
                } else {
                    System.out.print("[" + matriz[i][j].getId() + "] ");
                }
            }
            System.out.println();
        }
    }
}