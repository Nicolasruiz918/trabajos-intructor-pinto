import java.util.Scanner;

public class Ambulancia {
    public static void registrarAmbulancias() {
        Scanner teclado = Main.teclado;
        for (int i = 0; i < 3; i++) {
            System.out.print("Ingrese ID de la ambulancia " + (i + 1) + " (1-10): ");
            Main.ambulancias[i] = teclado.nextLine();
        }

        System.out.println("Ambulancias registradas:");
        for (int i = 0; i < 3; i++) {
            if (Main.ambulancias[i] != null) {
                System.out.println((i + 1) + ". " + Main.ambulancias[i]);
            }
        }
    }

    public static void asignarRecorridos() {

        if (Main.clinicas[0] == null) {
            Main.clinicas[0] = new Clinica("Clínica de Factura", 55.0);
            Main.clinicas[1] = new Clinica("Carmen Emilia Ospina", 35.0);
            Main.clinicas[2] = new Clinica("Clínica Belo Horizonte", 45.0);
            Main.clinicas[3] = new Clinica("Funeraria", 15.0);
        }


        for (int i = 0; i < 3; i++) {
            Main.clinicas[i].solicitarAmbulancia();
        }

        for (int i = 0; i < Main.ambulancias.length; i++) {
            if (Main.ambulancias[i] != null && (Main.funeraria[0] == null || !Main.Conductores[i].equals(Main.funeraria[0]))) {
                int recorridos = 0;
                double kmTotal = 0;

                while (recorridos < 8 && kmTotal < 400) {
                    boolean assigned = false;
                    for (int j = 0; j < 3; j++) {
                        if (Main.clinicas[j].getSolicitudes() > 0) {
                            double distancia = Main.clinicas[j].distanciaRecorrido();
                            if (kmTotal + distancia <= 400) {
                                Main.recorridos[i][j]++;
                                kmTotal += distancia;
                                recorridos++;
                                Main.recorridosPorConductor[i]++;
                                Main.clinicas[j].solicitarAmbulancia(); 
                                assigned = true;
                            }
                        }
                    }
                    if (!assigned) break; 
                }
                Main.kmAmbulancias[i] = kmTotal;
            }
        }
    }
}