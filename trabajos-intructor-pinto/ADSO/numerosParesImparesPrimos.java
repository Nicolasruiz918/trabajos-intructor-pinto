package com.mycompany.mavenproject1;
import java.util.Scanner;
import java.lang.Math;

public class Mavenproject1 {

    public static void main(String[] args) {
        int opcion;     
        int limite = 0;
        do {
            Scanner teclado = new Scanner(System.in);
            
            System.out.println("Digite el limite maximo para la serie numérica:");
            limite = teclado.nextInt();
            
            
            while (limite > 500) {
                System.out.println("No puede pasar de 500.");
                System.out.println("Por favor, digite otro valor en el rango permitido:");
                limite = teclado.nextInt();
            }
            
            System.out.println("Que tipo de numeros desea imprimir");
            System.out.println("1. Pares");
            System.out.println("2. Impares");
            System.out.println("3. Primos");
            System.out.print("Seleccione una opción (1-3): ");
            opcion = teclado.nextInt();
            
            System.out.println("Resultado:");
            switch (opcion) {
                case 1: 
                    for (int contador = 1; contador <= limite; contador++) {
                        if (contador % 2 == 0) {
                            System.out.println("Número par: " + contador);
                        }
                    }
                    break;
                    
                case 2: 
                    for (int contador = 1; contador <= limite; contador++) {
                        if (contador % 2 != 0) {
                            System.out.println("Número impar: " + contador);
                        }
                    }
                    break;
                    
                case 3:
                    for (int contador = 2; contador <= limite; contador++) {
                        int divisores = 0;
                        int maxDivisor = (int) Math.sqrt(contador) + 1;
                        for (int divisor = 2; divisor <= maxDivisor; divisor++) {
                            if (contador % divisor == 0 && contador != divisor) {
                                divisores++;
                                break; 
                            }
                        }
                        
                        if (divisores == 0) {
                            System.out.println("Número primo: " + contador);
                        }
                    }
                    break;
                    
                default: 
                    System.out.println("Opción no válida. Debe ser 1, 2 o 3.");
            }
            
            if (opcion != 0) {
                System.out.println("Presione Enter para continuar");
                teclado.nextLine(); 
                teclado.nextLine(); 
            }
            
        } while (opcion != 0);
    }
}
