public class RutaCampus {

    // MATRIZ OBLIGATORIA
    private int[][] distancias =
            new int[5][5];

    public void conectar(
            int origen,
            int destino,
            int distancia) {

        distancias[origen][destino] =
                distancia;

        distancias[destino][origen] =
                distancia;
    }

    public void mostrarMatriz() {

        for (int i = 0;
             i < distancias.length;
             i++) {

            for (int j = 0;
                 j < distancias[i].length;
                 j++) {

                System.out.print(
                        distancias[i][j]
                                + " "
                );
            }

            System.out.println();
        }
    }
}