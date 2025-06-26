public class Reportes {
    public static void generarReportes() {
       
        System.out.println("Reporte de recorridos:");
        for (int i = 0; i < Main.ambulancias.length; i++) {
            if (Main.ambulancias[i] != null && (Main.funeraria[0] == null || !Main.ambulancias[i].equals(Main.funeraria[0]))) {
                System.out.println("Ambulancia " + Main.ambulancias[i] + ":");
                System.out.println("Kilómetros recorridos: " + Main.kmAmbulancias[i]);
                System.out.println("Recorridos realizados: " + Main.recorridosPorConductor[i]);
                for (int j = 0; j < 3; j++) {
                    if (Main.recorridos[i][j] > 0) {
                        System.out.println("  - " + Main.clinicas[j].getNombre() + ": " + Main.recorridos[i][j] + " recorridos");
                    }
                }
            }
        }


        System.out.println("No movidos:");
        boolean hayNoMovidos = false;
        for (int i = 0; i < Main.ambulancias.length; i++) {
            if (Main.ambulancias[i] != null && Main.kmAmbulancias[i] == 0 && 
                (Main.funeraria[0] == null || !Main.ambulancias[i].equals(Main.funeraria[0]))) {
                System.out.println("Ambulancia " + Main.ambulancias[i] + " no se movió.");
                hayNoMovidos = true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (Main.clinicas[i].getSolicitudes() == 1) { 
                System.out.println(Main.clinicas[i].getNombre() + " no fue atendida.");
                hayNoMovidos = true;
            }
        }
        if (!hayNoMovidos) {
            System.out.println("Todos se movieron.");
        }

        // R8: Cantidad total de recorridos
        int totalRecorridos = 0;
        for (int i = 0; i < Main.recorridosPorConductor.length; i++) {
            totalRecorridos += Main.recorridosPorConductor[i];
        }
        System.out.println("\nCantidad total de recorridos (R8): " + totalRecorridos);
    }
}
