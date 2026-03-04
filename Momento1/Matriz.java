public class Matriz {

    private Contenedores[][] matriz = new Contenedores[10][10];

        public void registrarContenedor(int col, Contenedores nuevo) {

        if (col < 0 || col > 9) {
            System.out.println("Columna inválida.");
            return;
        }

        for (int fila = 9; fila >= 0; fila--) {

            if (matriz[fila][col] == null) {
                matriz[fila][col] = nuevo;
                System.out.println("Contenedor ubicado en [" + fila + "][" + col + "]");
                return;
            }
        }

        System.out.println("Columna llena.");
    }

    
    public double calcularPesoTotal() {

        double total = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                if (matriz[i][j] != null) {
                    total += matriz[i][j].getPeso();
                }
            }
        }

        return total;
    }

     public void mostrarMatriz() {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                if (matriz[i][j] == null) {
                    System.out.print("[ VACIO ] ");
                } else {
                    System.out.print("[Codigo:" + matriz[i][j].getCodigo()
                            + " Origen:" + matriz[i][j].getOrigen()
                            + " Peso:" + matriz[i][j].getPeso() + "] ");
                }
            }
            System.out.println();
        }
    }
}