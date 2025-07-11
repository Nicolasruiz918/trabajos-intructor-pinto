import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Colegio {
    private static final String[] GRADOS = {"Primero", "Segundo", "Tercero", "Cuarto", "Quinto","Sexto","Septimo","Octavo","Noveno","Decimo","Once"};
    private static final char[] GRUPOS = {'A', 'B', 'C', 'D', 'E'};
    private final String nombre;            
    private final int numSalones;             
    private final int alumnosPorSalon;       
    private final ArrayList<Salon> salones;   

    public Colegio(String nombre, int numSalones, int alumnosPorSalon, Scanner scanner) {
        this.nombre = nombre;
        this.numSalones = numSalones;
        this.alumnosPorSalon = alumnosPorSalon;
        this.salones = new ArrayList<>();
        inicializarSalones(scanner);
    }

    private void inicializarSalones(Scanner scanner) {
        Random random = new Random();
        ArrayList<String> idSalonesUsados = new ArrayList<>();

        for (int i = 0; i < numSalones; i++) {
            String idSalon;
            do {
                String grado = GRADOS[random.nextInt(GRADOS.length)];
                char grupo = GRUPOS[random.nextInt(GRUPOS.length)];
                idSalon = grado + "-" + grupo;
            } while (idSalonesUsados.contains(idSalon)); // Evitar duplicados
            idSalonesUsados.add(idSalon);

            Salon salon = new Salon(idSalon);
            System.out.println("\nIngresando alumnos para el salón: " + idSalon);
            for (int j = 0; j < alumnosPorSalon; j++) {
                System.out.print("Ingrese el nombre del alumno " + (j + 1) + ": ");
                String nombre = scanner.nextLine();
                while (nombre.isEmpty()) {
                    System.out.print("El nombre no puede estar vacío. Ingrese el nombre del alumno " + (j + 1) + ": ");
                    nombre = scanner.nextLine();
                }
                salon.agregarAlumno(nombre);
               
            }
              salones.add(salon);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void reporteGeneral() {
        System.out.println(" Reporte General del " + nombre );
        System.out.println("Total de salones: " + numSalones);
        System.out.println("Alumnos por salón: " + alumnosPorSalon);
        System.out.println("Total de alumnos matriculados: " + (numSalones * alumnosPorSalon) + "\n");
    }

    public void listarAlumnosPorSalon() {
        System.out.println(" Listado de Alumnos por Salón y Grupo ");
        for (Salon salon : salones) {
            System.out.println("Salón: " + salon.getId());
            System.out.println("Número de alumnos: " + salon.getAlumnos().size());
            System.out.println("Alumnos:");
            for (int i = 0; i < salon.getAlumnos().size(); i++) {
                System.out.println("  " + (i + 1) + ". " + salon.getAlumnos().get(i));
            }
        }
        System.out.println();
    }
}