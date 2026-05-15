public class RutaCampus {
   private int[][] distancias =
            new int[5][5];

    private String[] edificios = {
            "Ingenieria",
            "Biblioteca",
            "Cafeteria",
            "Rectoria",
            "Laboratorios"
    };

    public void conectar(
            int origen,
            int destino,
            int distancia) {

        distancias[origen][destino] =
                distancia;

        distancias[destino][origen] =
                distancia;
    }

    // DIJKSTRA SIMPLE
    public void rutaMasCorta(
            int origen,
            int destino) {

        boolean[] visitado =
                new boolean[5];

        int[] distancia =
                new int[5];

        for (int i = 0;
             i < 5;
             i++) {

            distancia[i] = 9999;
        }

        distancia[origen] = 0;

        for (int i = 0;
             i < 5;
             i++) {

            int minimo = 9999;
            int nodo = 0;

            for (int j = 0;
                 j < 5;
                 j++) {

                if (!visitado[j]
                        && distancia[j] < minimo) {

                    minimo = distancia[j];
                    nodo = j;
                }
            }

            visitado[nodo] = true;

            for (int j = 0;
                 j < 5;
                 j++) {

                if (distancias[nodo][j] > 0) {

                    if (distancia[nodo]
                            + distancias[nodo][j]
                            < distancia[j]) {

                        distancia[j] =
                                distancia[nodo]
                                        + distancias[nodo][j];
                    }
                }
            }
        }

        System.out.println(
                "Distancia minima: "
                        + distancia[destino]
                        + " metros"
        );
    }

    public void mostrarEdificios() {

        for (int i = 0;
             i < edificios.length;
             i++) {

            System.out.println(
                    i + ". " + edificios[i]
            );
        }
    }
}