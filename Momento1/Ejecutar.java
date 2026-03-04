public class Ejecutar {
    public static void main(String[] args) {

        Buque [] b = new Buque[10];
        Contenedores [][] c = new Contenedores[10][10];

        b[0] = new Buque("chile", 5);
        b[1] = new Buque("peru", 10);
        b[2] = new Buque("colombia", 15);
        b[3] = new Buque("argentina", 20);
        b[4] = new Buque("brasil", 25);
        b[5] = new Buque("ecuador", 30);

        c[2][0] = new Contenedores("c1","Usa", 100);
        c[9][1] = new Contenedores("c2","china", 200);
        c[7][2] = new Contenedores("c3","italia", 300);
        c[6][3] = new Contenedores("c4","francia", 400);
        c[0][4] = new Contenedores("c5","españa", 500);
        c[1][5] = new Contenedores("c6","alemania", 600);

        System.out.println("Buques registrados:");

        for (int i = 0; i < b.length; i++) {
            if (b[i] != null) {
                System.out.println(b[i]);
            }
        }

        double total = 0;

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {

                if (c[i][j] != null) {
                    total += c[i][j].getPeso();
                }

            }
        }

        System.out.println("Peso total de los contenedores: " + total);
    }
}