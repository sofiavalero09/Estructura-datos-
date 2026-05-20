import java.util.Stack;

public class NavegadorReportes {

    private Stack<String> atras =
            new Stack<>();

    private Stack<String> adelante =
            new Stack<>();

    public void verReporte(
            String reporte) {

        atras.push(reporte);

        System.out.println(
                "Viendo: "
                        + reporte
        );
    }

    public void atras() {

        if (atras.size() <= 1) {

            System.out.println(
                    "No hay reportes"
            );

            return;
        }

        adelante.push(
                atras.pop()
        );

        System.out.println(
                "Reporte actual: "
                        + atras.peek()
        );
    }

    public void adelante() {

        if (adelante.empty()) {

            System.out.println(
                    "No hay reportes adelante"
            );

            return;
        }

        String r =
                adelante.pop();

        atras.push(r);

        System.out.println(
                "Reporte actual: "
                        + r
        );
    }
}