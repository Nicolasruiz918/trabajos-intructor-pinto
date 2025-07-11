import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar nombre del colegio
        String nombreColegio = "";
        while (nombreColegio.trim().isEmpty()) {
            System.out.print("Ingrese el nombre del colegio: ");
            nombreColegio = scanner.nextLine().trim();
            if (nombreColegio.isEmpty()) {
                System.out.println("El nombre del colegio no puede estar vacío.");
            }
        }

        // Solicitar número de salones
        int numSalones = -1;
        while (numSalones < 0 || numSalones > 200) {
            System.out.print("Ingrese el número de salones (0-200): ");
            try {
                numSalones = Integer.parseInt(scanner.nextLine().trim());
                if (numSalones < 0 || numSalones > 200) {
                    System.out.println("El número de salones debe estar entre 0 y 200.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }

        // Solicitar alumnos por salón
        int alumnosPorSalon = 0;
        while (alumnosPorSalon <= 0) {
            System.out.print("Ingrese la cantidad de alumnos por salón: ");
            try {
                alumnosPorSalon = Integer.parseInt(scanner.nextLine().trim());
                if (alumnosPorSalon <= 0) {
                    System.out.println("La cantidad de alumnos por salón debe ser mayor que 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }

        // Crear instancia del colegio
        Colegio colegio = new Colegio(nombreColegio, numSalones, alumnosPorSalon, scanner);

        while (true) {
            System.out.println(" Sistema de Gestion Escolar ===");
            System.out.println("1. Ver reporte general");
            System.out.println("2. Listar alumnos por salón y grupo");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción (1-3): ");

            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1" -> colegio.reporteGeneral();
                case "2" -> colegio.listarAlumnosPorSalon();
                case "3" -> {
                    System.out.println("Gracias por usar el sistema. Hasta pronto.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opción no válida. Por favor, seleccione 1, 2 o 3.");
            }
        }
    }
}