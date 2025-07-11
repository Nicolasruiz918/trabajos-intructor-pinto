import java.util.ArrayList;

public class Salon {
    private String id; 
    private ArrayList<String> alumnos;

    public Salon(String id) {
        this.id = id;
        this.alumnos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public ArrayList<String> getAlumnos() {
        return alumnos;
    }

    public void agregarAlumno(String alumno) {
        alumnos.add(alumno);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAlumnos(ArrayList<String> alumnos) {
        this.alumnos = alumnos;
    }
}