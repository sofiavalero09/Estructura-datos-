public class Matriz {

    private Contenedor[][] matriz = new Contenedor[10][10];

    public void registrarContenedor(int col, Contenedor nuevo) {

        if (col < 0 || col > 9) {
            System.out.println("Columna invalida");
            return;
        }

        for (int fila = 9; fila >= 0; fila--) {

            if (matriz[fila][col] == null) {

                matriz[fila][col] = nuevo;

                System.out.println("Contenedor ubicado en [" + fila + "][" + col + "]");
                return;
            }
        }

        System.out.println("Columna llena");
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
                    System.out.print("[ " + matriz[i][j].getCodigo() + " ] ");
                }
            }

            System.out.println();
        }
    }

    public void agruparOrigen() {

        int china = 0;
        int usa = 0;
        int brasil = 0;
        int otros = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                if (matriz[i][j] != null) {

                    String origen = matriz[i][j].getOrigen().toLowerCase();

                    if (origen.equals("china"))
                        china++;

                    else if (origen.equals("usa"))
                        usa++;

                    else if (origen.equals("brasil"))
                        brasil++;

                    else
                        otros++;
                }
            }
        }

        System.out.println("Contenedores por origen:");
        System.out.println("China: " + china);
        System.out.println("USA: " + usa);
        System.out.println("Brasil: " + brasil);
        System.out.println("Otros: " + otros);
    }
}