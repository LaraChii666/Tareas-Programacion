
import java.util.Scanner;

public class AnalisisNumerosAmigos {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        final int MINIMO = 1;

        int numero1;
        int numero2;
        int opcion;
        int repetir;
        int contadorDivisores1;
        int contadorDivisores2;
        int sumaDivisores1;
        int sumaDivisores2;

        do {
            System.out.println("Ingrese el primer numero entero positivo:");
            numero1 = entrada.nextInt();

            while (numero1 < MINIMO) {
                System.out.println("Error. Ingrese un numero mayor que cero:");
                numero1 = entrada.nextInt();
            }

            System.out.println("Ingrese el segundo numero entero positivo:");
            numero2 = entrada.nextInt();

            while (numero2 < MINIMO) {
                System.out.println("Error. Ingrese un numero mayor que cero:");
                numero2 = entrada.nextInt();
            }

            sumaDivisores1 = 0;
            sumaDivisores2 = 0;
            contadorDivisores1 = 0;
            contadorDivisores2 = 0;

            for (int i = 1; i < numero1; i++) {
                if (numero1 % i == 0) {
                    sumaDivisores1 += i;
                    contadorDivisores1++;
                }
            }

            for (int i = 1; i < numero2; i++) {
                if (numero2 % i == 0) {
                    sumaDivisores2 += i;
                    contadorDivisores2++;
                }
            }

            System.out.println("Seleccione la informacion que desea mostrar:");
            System.out.println("1. Mostrar las sumas de los divisores");
            System.out.println("2. Mostrar solamente el resultado");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Suma de divisores de " + numero1 + ": " + sumaDivisores1);
                    System.out.println("Cantidad de divisores propios de " + numero1 + ": " + contadorDivisores1);
                    System.out.println("Suma de divisores de " + numero2 + ": " + sumaDivisores2);
                    System.out.println("Cantidad de divisores propios de " + numero2 + ": " + contadorDivisores2);

                    if (sumaDivisores1 == numero2 && sumaDivisores2 == numero1) {
                        System.out.println("Los numeros son amigos.");
                    } else {
                        System.out.println("Los numeros no son amigos.");
                    }
                    break;

                case 2:
                    if (sumaDivisores1 == numero2 && sumaDivisores2 == numero1) {
                        System.out.println("Los numeros son amigos.");
                    } else {
                        System.out.println("Los numeros no son amigos.");
                    }
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    System.out.println("Los numeros no fueron clasificados.");
            }

            System.out.println("Desea analizar otra pareja? (1 = Si, 0 = No)");
            repetir = entrada.nextInt();

        } while (repetir == 1);

        System.out.println("Programa finalizado.");
        entrada.close();
    }
}
