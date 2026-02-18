public class EjecutarCursos {
    public static void main(String[] args) {
        Cursos[] c = new Cursos[5];
        c[0] = new Cursos(1150184573, "Calculo", 15);
        c[1] = new Cursos(31431814, "Estadistica", 28);  
        c[2] = new Cursos(70009543, "Estructura de Datos", 30);
        c[3] = new Cursos(22367495, "Programacion", 17);
        c[4] = new Cursos(1179903467, "Sistemas", 45);
        int totalEstudiantes = 0;  // Minúscula para convención
        for (int i = 0; i < c.length; i++) {
            totalEstudiantes += c[i].getCantidadEstudiantes();
        }
        System.out.println("El total de estudiantes es: " + totalEstudiantes);
    }
}