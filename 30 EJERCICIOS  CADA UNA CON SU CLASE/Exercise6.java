public class Exercise6 {
    public static void areaTriangulo() {
        double a = Todos.numero1D;
        double b = Todos.numero2D;
        double c = Todos.numero3D;
        double s = (a + b + c) / 2.0;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        Todos.calcularDouble = area;
        System.out.println("El área del triángulo es: " + area);
    }
}