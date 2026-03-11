import java.util.Random;
public class Ejecutar {
public static void main(String[] args) {
    Random r =new Random ();

    int[]energiaContenedores = new int[12];
    for (int i = 0; i < energiaContenedores.length; i++) {
        energiaContenedores[i]= r.nextInt(101)+50;
    }
    System.out.println("Energia generada:");
    for (int e : energiaContenedores) {
            System.out.print(e + " ");
        }

        int[] filtrados = new int[12];
        int contador = 0;

        for (int i = 0; i < energiaContenedores.length; i++) {

            if (energiaContenedores[i] % 10 == 0) { 
                

                filtrados[contador] = energiaContenedores[i];
                contador++;
            }
        }

        System.out.println("Energia filtrada (multiplos de 10):");
        for (int i = 0; i < contador; i++) {
            System.out.print(filtrados[i] + " ");
        }



        int[][] mapaCarga = new int[3][3]; 

        int index = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (index < contador) {
                    mapaCarga[i][j] = filtrados[index];
                    index++;
                } else {
                    mapaCarga[i][j] = -1;
                }
            }
        }

        System.out.println("\nMapa de carga:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(mapaCarga[i][j] + " ");
            }
            System.out.println();
        }

        Suministro[] manifiesto = new Suministro[9];

        int pos = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                int valor = mapaCarga[i][j];

                if (valor != -1) {

                    String prioridad;

                    if (valor > 100) {
                        prioridad = "ALTA";
                    } else {
                        prioridad = "ESTANDAR";
                    }

                    String id = "C-" + i + "-" + j;

                    manifiesto[pos] = new Suministro(id, valor, prioridad);
                } 
                else {
                    manifiesto[pos] = null;
                }

                pos++;
            }
        }


        System.out.println("\nManifiesto de vuelo:");

        for (int i = 0; i < manifiesto.length; i++) {

            if (manifiesto[i] != null) {
                System.out.println(manifiesto[i]);
            } else {
                System.out.println("Posicion vacia");
            }
        }
    }
}