
import java.util.Scanner;

public class MenuOperaciones {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int opcion;
        int numero;
        int suma;
        int repetir;
        long resultado;

        do {
            System.out.println("===== MENU DE OPERACIONES MATEMATICAS =====");
            System.out.println("1. Calcular el cuadrado de un numero");
            System.out.println("2. Calcular el cubo de un numero");
            System.out.println("3. Determinar si un numero es par o impar");
            System.out.println("4. Sumar los numeros desde 1 hasta un numero");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese un numero:");
                    numero = entrada.nextInt();

                    if (numero > 0) {
                        resultado = (long) numero * numero;
                        System.out.println("El cuadrado es: " + resultado);
                    } else {
                        System.out.println("Error. El numero debe ser positivo.");
                    }
                    break;

                case 2:
                    System.out.println("Ingrese un numero:");
                    numero = entrada.nextInt();

                    if (numero > 0) {
                        resultado = (long) numero * numero * numero;
                        System.out.println("El cubo es: " + resultado);
                    } else {
                        System.out.println("Error. El numero debe ser positivo.");
                    }
                    break;

                case 3:
                    System.out.println("Ingrese un numero entero:");
                    numero = entrada.nextInt();

                    if (numero % 2 == 0) {
                        System.out.println("El numero es par.");
                    } else {
                        System.out.println("El numero es impar.");
                    }
                    break;

                case 4:
                    System.out.println("Ingrese un numero entero positivo:");
                    numero = entrada.nextInt();

                    while (numero <= 0) {
                        System.out.println("Error. Ingrese un numero mayor que cero:");
                        numero = entrada.nextInt();
                    }

                    suma = 0;

                    for (int i = 1; i <= numero; i++) {
                        suma += i;
                    }

                    System.out.println("La suma desde 1 hasta " + numero + " es: " + suma);
                    break;

                case 5:
                    System.out.println("Gracias por utilizar el programa. Hasta pronto.");
                    break;

                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
            }

        } while (opcion != 5);

        entrada.close();
    }
}
