public class Conductor {
    public static void registrarConductores() {
        for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese el nombre del conductor " + (i + 1) + ": ");
            Main.Conductores[i] = Main.teclado.nextLine();
        }

        System.out.println("Conductores registrados:");
        for (int i = 0; i < 10; i++) {
            if (Main.Conductores[i] != null) {
                System.out.println((i + 1) + ". " + Main.Conductores[i]);
            }
        }
    }
}

