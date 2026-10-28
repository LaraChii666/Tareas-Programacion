
import java.util.Scanner;

public class EstadisticasSecuencia {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        final int MINIMO = 1;

        int numero;
        int opcion;
        int repetir;
        int sumaDivisibles4;
        int cantidadMultiplos3;
        int cantidadAmbos;
        int cantidadPares;
        int cantidadImpares;
        int cantidadMultiplos5;

        do {
            sumaDivisibles4 = 0;
            cantidadMultiplos3 = 0;
            cantidadAmbos = 0;
            cantidadPares = 0;
            cantidadImpares = 0;
            cantidadMultiplos5 = 0;

            System.out.println("Ingrese un numero entero positivo:");
            numero = entrada.nextInt();

            while (numero < MINIMO) {
                System.out.println("Error. Ingrese un numero mayor que cero:");
                numero = entrada.nextInt();
            }

            for (int i = 1; i <= numero; i++) {
                if (i % 2 == 0) {
                    cantidadPares++;
                } else {
                    cantidadImpares++;
                }

                if (i % 4 == 0) {
                    sumaDivisibles4 += i;
                }

                if (i % 3 == 0) {
                    cantidadMultiplos3++;
                }

                if (i % 4 == 0 && i % 3 == 0) {
                    cantidadAmbos++;
                }

                if (i % 5 == 0) {
                    cantidadMultiplos5++;
                }
            }

            System.out.println("Suma de numeros divisibles entre 4: " + sumaDivisibles4);
            System.out.println("Cantidad de multiplos de 3: " + cantidadMultiplos3);
            System.out.println("Cantidad divisibles entre 3 y 4: " + cantidadAmbos);

            System.out.println("Estadisticas que desea visualizar:");
            System.out.println("1. Numeros pares");
            System.out.println("2. Numeros impares");
            System.out.println("3. Multiplos de 5");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Cantidad de numeros pares: " + cantidadPares);
                    break;
                case 2:
                    System.out.println("Cantidad de numeros impares: " + cantidadImpares);
                    break;
                case 3:
                    System.out.println("Cantidad de multiplos de 5: " + cantidadMultiplos5);
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }

            System.out.println("Desea realizar otro analisis? (1 = Si, 0 = No)");
            repetir = entrada.nextInt();

        } while (repetir == 1);

        System.out.println("Programa finalizado.");
        entrada.close();
    }
}
