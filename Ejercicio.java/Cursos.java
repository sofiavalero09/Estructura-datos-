public class Cursos {
    private int id;
    private String NombreCurso;  // Corregido: string -> String
    private int CantidadEstudiantes;

    public Cursos(int id, String NombreCurso, int CantidadEstudiantes) {  // Corregido: string -> String
        this.id = id;
        this.NombreCurso = NombreCurso;
        this.CantidadEstudiantes = CantidadEstudiantes;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {  // Corregido: parámetro ahora es int id
        this.id = id;
    }

    public String getNombreCurso() {
        return NombreCurso;
    }

    public void setNombreCurso(String NombreCurso) {
        this.NombreCurso = NombreCurso;
    }

    public int getCantidadEstudiantes() {
        return CantidadEstudiantes;
    }

    public void setCantidadEstudiantes(int CantidadEstudiantesE) {  // Corregido: asignación ahora usa el parámetro
        this.CantidadEstudiantes = CantidadEstudiantesE;
    }

    @Override  // Agregado: anotación @Override
    public String toString() {
        return "Cursos [id=" + id + ", NombreCurso=" + NombreCurso + ", CantidadEstudiantes=" + CantidadEstudiantes + "]";  // Corregido: CCantidadEstudiantes -> CantidadEstudiantes
    }
}