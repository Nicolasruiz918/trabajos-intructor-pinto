import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ejercicios {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Mostrar menú de opciones
            System.out.println("\n=== MENÚ DE ALGORITMOS ===");
            System.out.println("1. Diferencia de f(n) y g(n)");
            System.out.println("2. log(a) / log(b)");
            System.out.println("3. Comparador de funciones");
            System.out.println("4. Calcular el orden exacto de t(n)");
            System.out.println("5. Verificar número triangular");
            System.out.println("6. Escalado lineal para 3 horas");
            System.out.println("7. Programa 100 veces más rápido");
            System.out.println("8. Encontrar min/max en vector");
            System.out.println("9. Resolver recurrencia T(n) = 2T(n/4) + lg n");
            System.out.println("10. Resolver total(n) = total(n-1) + 2*parcial(n-1)");
            System.out.println("11. Búsqueda de subcadena");
            System.out.println("12. MultiMergeSort");
            System.out.println("13. Verificar palíndromo");
            System.out.println("14. Calcular T(n) = 2T(n/2) + 2n*log2(n)");
            System.out.println("15. Encontrar max/min con divide y conquista");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1: {
                    System.out.print("Ingrese valor para n: ");
                    int n = scanner.nextInt();
                    System.out.print("Coeficiente b para f(n) = b*n: ");
                    int coeficiente = scanner.nextInt();
                    System.out.print("Constante c para f(n) = b*n + c: ");
                    int constante = scanner.nextInt();

                    int fn = coeficiente * n + constante;
                    int diferencia = fn - n;

                    System.out.println("\nResultados:");
                    System.out.println("f(n) = " + coeficiente + "*n + " + constante + " = " + fn);
                    System.out.println("g(n) = n = " + n);
                    System.out.println("f(n) - g(n) = " + diferencia);

                    if (diferencia == 5) {
                        System.out.println("Diferencia constante (5), f(n) es O(n).");
                    } else if (diferencia == n || diferencia == coeficiente * n) {
                        System.out.println("Diferencia proporcional a n, f(n) es Θ(n).");
                    } else {
                        System.out.println("Comportamiento no estándar, analizar según b y c.");
                    }
                    break;
                }

                case 2: {
                    System.out.print("Ingrese valor a (>0): ");
                    double valor = scanner.nextDouble();
                    System.out.print("Ingrese base b (>1): ");
                    double base = scanner.nextDouble();

                    if (valor > 0 && base > 1) {
                        double resultado = Math.log(valor) / Math.log(base);
                        System.out.printf("log_%.0f(%.0f) = %.4f%n", base, valor, resultado);
                    } else {
                        System.out.println("Error: a debe ser > 0 y b > 1.");
                    }
                    break;
                }

                case 3: {
                    System.out.print("Ingrese valor n: ");
                    double n = scanner.nextDouble();
                    System.out.print("Ingrese base logarítmica: ");
                    double base = scanner.nextDouble();

                    double logN = Math.log(n) / Math.log(base);
                    System.out.println("\nComparación de funciones:");
                    System.out.println("Lineal (n): " + n);
                    System.out.println("Cuadrática (n²): " + (n * n));
                    System.out.println("Log lineal (log_" + (int)base + "(n)): " + logN);
                    System.out.println("Log cuadrático (log_" + (int)base + "(n²)): " + (2 * logN));
                    System.out.println("log_b(n²) = 2*log_b(n)  Mismo orden (log n)");
                    break;
                }

                case 4: {
                    System.out.print("Ingrese n: ");
                    int n = scanner.nextInt();
                    int[] contador = {0};

                    class ContadorRecursivo {
                        int contar(int x) {
                            for (int i = 1; i <= x; i++) {
                                for (int j = 1; j <= i; j++) {
                                    contador[0]++;
                                }
                            }

                            if (x > 1) {
                                for (int k = 0; k < 4; k++) {
                                    contador[0] += contar(x / 2);
                                }
                            }
                            return contador[0];
                        }
                    }

                    int total = new ContadorRecursivo().contar(n);
                    System.out.println("Total operaciones: " + total);
                    System.out.println("Aproximación teórica (8n²/3): " + (8.0 * n * n / 3));
                    break;
                }

                case 5: {
                    System.out.print("Ingrese un número (>=1): ");
                    int numero = scanner.nextInt();

                    if (numero < 1) {
                        System.out.println("El número debe ser >=1.");
                        break;
                    }

                    int suma = 0;
                    int k = 1;
                    while (suma < numero) {
                        suma += k++;
                    }

                    System.out.println(numero + (suma == numero ? " ES" : " NO es") + " triangular");
                    break;
                }

                case 6: {
                    System.out.print("Ingrese tamaño máximo para 1 hora (n): ");
                    int n = scanner.nextInt();
                    System.out.println("Tamaño para 3 horas: " + (3 * n));
                    break;
                }

                case 7: {
                    System.out.print("Ingrese tamaño actual (n): ");
                    int n = scanner.nextInt();

                    System.out.println("\nResultados para máquina 100x más rápida:");
                    System.out.println("(A) Lineal: " + (100 * n));
                    System.out.println("(B) Cuadrática: " + (10 * n));
                    System.out.println("(C) Exponencial: " + (n + 2));
                    break;
                }

                case 8: {
                    System.out.print("Ingrese números separados por espacios: ");
                    scanner.nextLine();
                    String[] numerosStr = scanner.nextLine().split(" ");
                    int[] numeros = new int[numerosStr.length];

                    try {
                        for (int i = 0; i < numerosStr.length; i++) {
                            numeros[i] = Integer.parseInt(numerosStr[i]);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: ingrese solo números válidos.");
                        break;
                    }

                    if (numeros.length == 0) {
                        System.out.println("No se ingresaron números.");
                        break;
                    }

                    int min = numeros[0];
                    int max = numeros[0];
                    int comparaciones = 0;

                    for (int i = 1; i < numeros.length; i++) {
                        comparaciones++;
                        if (numeros[i] < min) {
                            min = numeros[i];
                        } else {
                            comparaciones++;
                            if (numeros[i] > max) {
                                max = numeros[i];
                            }
                        }
                    }

                    System.out.println("\nResultados:");
                    System.out.println("Mínimo: " + min);
                    System.out.println("Máximo: " + max);
                    System.out.println("Comparaciones: " + comparaciones);
                    System.out.println("Límite teórico (3n/2): " + (1.5 * numeros.length));
                    break;
                }

                case 9: {
                    System.out.print("Ingrese n (>0): ");
                    int n = scanner.nextInt();

                    if (n <= 0) {
                        System.out.println("Error: n debe ser >0.");
                        break;
                    }

                    class Recurrencia {
                        double calcular(int x, double c) {
                            if (x <= 1) return c;
                            double logn = Math.log(x) / Math.log(2);
                            return 2 * calcular(x / 4, c) + logn;
                        }
                    }

                    double resultado = new Recurrencia().calcular(n, 1);
                    System.out.printf("T(%d) = %.2f%n", n, resultado);
                    System.out.println("Orden asintótico: Θ(√n)");
                    break;
                }

                case 10: {
                    System.out.print("Ingrese n (>0): ");
                    int n = scanner.nextInt();

                    if (n <= 0) {
                        System.out.println("Error: n debe ser >0.");
                        break;
                    }

                    class CalculoRecursivo {
                        int parcial(int m) {
                            if (m == 1) return 1;
                            return 2 * parcial(m - 1);
                        }

                        int total(int x) {
                            if (x == 1) return 1;
                            return total(x - 1) + 2 * parcial(x - 1);
                        }
                    }

                    int resultado = new CalculoRecursivo().total(n);
                    System.out.println("total(" + n + ") = " + resultado);
                    System.out.println("Orden asintótico: O(n²)");
                    break;
                }

                case 11: {
                    System.out.print("Ingrese cadena principal: ");
                    scanner.nextLine();
                    String cadena = scanner.nextLine();
                    System.out.print("Ingrese subcadena a buscar: ");
                    String subcadena = scanner.nextLine();

                    if (subcadena.length() > cadeia.length() || subcadena.isEmpty()) {
                        System.out.println("Subcadena no válida.");
                        break;
                    }

                    int comparaciones = 0;
                    int posicion = -1;

                    for (int i = 0; i <= cadena.length() - subcadena.length(); i++) {
                        boolean coincide = true;
                        for (int j = 0; j < subcadena.length(); j++) {
                            comparaciones++;
                            if (cadena.charAt(i + j) != subcadena.charAt(j)) {
                                coincide = false;
                                break;
                            }
                        }
                        if (coincide) {
                            posicion = i;
                            break;
                        }
                    }

                    if (posicion != -1) {
                        System.out.println("Subcadena encontrada en posición: " + posicion);
                    } else {
                        System.out.println("Subcadena no encontrada");
                    }
                    System.out.println("Comparaciones realizadas: " + comparaciones);
                    System.out.println("Complejidad: O(n*m) donde n = longitud cadena, m = longitud subcadena");
                    break;
                }

                case 12: {
                    System.out.print("Ingrese cantidad de elementos: ");
                    int tamaño = scanner.nextInt();

                    if (tamaño <= 0) {
                        System.out.println("Error: tamaño debe ser >0.");
                        break;
                    }

                    System.out.print("Ingrese " + tamaño + " números separados por espacios: ");
                    scanner.nextLine();
                    String[] elementos = scanner.nextLine().split(" ");

                    if (elementos.length != tamaño) {
                        System.out.println("Error: cantidad de números incorrecta.");
                        break;
                    }

                    int[] vector = new int[tamaño];
                    try {
                        for (int i = 0; i < tamaño; i++) {
                            vector[i] = Integer.parseInt(elementos[i]);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: ingrese solo números válidos.");
                        break;
                    }

                    System.out.println("Vector original: " + Arrays.toString(vector));

                    // Algoritmo MultiMergeSort
                    int comparaciones = 0;

                    // Paso 1: Ordenar pares
                    for (int i = 0; i < tamaño - 1; i += 2) {
                        comparaciones++;
                        if (vector[i] > vector[i + 1]) {
                            int temp = vector[i];
                            vector[i] = vector[i + 1];
                            vector[i + 1] = temp;
                        }
                    }

                    // Paso 2: Crear colas ordenadas
                    List<Queue<Integer>> colas = new ArrayList<>();
                    for (int i = 0; i < tamaño; i += 2) {
                        Queue<Integer> cola = new LinkedList<>();
                        cola.add(vector[i]);
                        if (i + 1 < tamaño) {
                            cola.add(vector[i + 1]);
                        }
                        colas.add(cola);
                    }

                    // Paso 3: Mezclar colas
                    for (int i = 0; i < tamaño; i++) {
                        int minValor = Integer.MAX_VALUE;
                        int minIndice = -1;

                        for (int j = 0; j < colas.size(); j++) {
                            if (!colas.get(j).isEmpty()) {
                                comparaciones++;
                                if (colas.get(j).peek() < minValor) {
                                    minValor = colas.get(j).peek();
                                    minIndice = j;
                                }
                            }
                        }

                        if (minIndice != -1) {
                            vector[i] = colas.get(minIndice).poll();
                            if (colas.get(minIndice).isEmpty()) {
                                colas.remove(minIndice);
                            }
                        }
                    }

                    System.out.println("Vector ordenado: " + Arrays.toString(vector));
                    System.out.println("Comparaciones realizadas: " + comparaciones);
                    System.out.println("Complejidad: O(n²)");
                    break;
                }

                case 13: {
                    System.out.print("Ingrese una cadena: ");
                    scanner.nextLine();
                    String cadena = scanner.nextLine().toLowerCase().replaceAll("[^a-z0-9]", "");

                    if (cadena.isEmpty()) {
                        System.out.println("Cadena no válida.");
                        break;
                    }

                    boolean esPalindromo = true;
                    int izquierda = 0;
                    int derecha = cadena.length() - 1;
                    int comparaciones = 0;

                    while (izquierda < derecha) {
                        comparaciones++;
                        if (cadena.charAt(izquierda) != cadena.charAt(derecha)) {
                            esPalindromo = false;
                            break;
                        }
                        izquierda++;
                        derecha--;
                    }

                    System.out.println("La cadena " + (esPalindromo ? "ES" : "NO es") + " palíndromo");
                    System.out.println("Comparaciones realizadas: " + comparaciones);
                    System.out.println("Complejidad: O(n)");
                    break;
                }

                case 14: {
                    System.out.print("Ingrese un número n (>0): ");
                    int n = scanner.nextInt();

                    if (n <= 0) {
                        System.out.println("Error: n debe ser >0.");
                        break;
                    }

                    // Aproximación para T(n) = 2T(n/2) + 2n*log2(n)
                    // La solución es Θ(n log n), usamos una estimación simple
                    double logN = Math.log(n) / Math.log(2);
                    double resultado = 2 * n * logN; // Aproximación dominante

                    System.out.printf("T(%d) ≈ %.2f (estimación)%n", n, resultado);
                    System.out.println("Orden asintótico: Θ(n log n)");
                    break;
                }

                case 15: {
                    System.out.print("Ingrese números separados por espacios: ");
                    scanner.nextLine();
                    String[] numerosStr = scanner.nextLine().split(" ");
                    int[] numeros = new int[numerosStr.length];

                    try {
                        for (int k = 0; k < numerosStr.length; k++) {
                            numeros[k] = Integer.parseInt(numerosStr[k]);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: ingrese solo números válidos.");
                        break;
                    }

                    if (numeros.length < 2) {
                        System.out.println("Error: ingrese al menos dos números.");
                        break;
                    }

                    // Encontrar max y min con un solo recorrido
                    int min = numeros[0];
                    int max = numeros[0];
                    int comparaciones = 0;

                    for (int i = 1; i < numeros.length; i++) {
                        comparaciones++;
                        if (numeros[i] < min) {
                            min = numeros[i];
                        } else {
                            comparaciones++;
                            if (numeros[i] > max) {
                                max = numeros[i];
                            }
                        }
                    }

                    System.out.println("\nResultados:");
                    System.out.println("Máximo: " + max);
                    System.out.println("Mínimo: " + min);
                    System.out.println("Comparaciones realizadas: " + comparaciones);
                    System.out.println("Comparaciones teóricas (3n/2 - 2): " + (3.0 * numeros.length / 2 - 2));
                    break;
                }

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
