
import java.util.Scanner;

public class SimuladorAhorro {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        final double TASA_INTERES = 0.01;
        final int MINIMO = 1;

        double dineroInicial;
        double metaAhorro;
        double ahorroMensual;
        double saldo;
        double interesesGenerados;
        double interesMensual;

        int opcionPlazo;
        int mesesSimulacion;
        int mesesNecesarios;
        int repetir;

        do {
            System.out.println("Ingrese la cantidad inicial de dinero:");
            dineroInicial = entrada.nextDouble();

            while (dineroInicial < MINIMO) {
                System.out.println("Error. Ingrese una cantidad positiva:");
                dineroInicial = entrada.nextDouble();
            }

            System.out.println("Ingrese la meta de ahorro:");
            metaAhorro = entrada.nextDouble();

            while (metaAhorro < MINIMO) {
                System.out.println("Error. Ingrese una meta positiva:");
                metaAhorro = entrada.nextDouble();
            }

            System.out.println("Ingrese el ahorro mensual fijo:");
            ahorroMensual = entrada.nextDouble();

            while (ahorroMensual < MINIMO) {
                System.out.println("Error. Ingrese un ahorro mensual positivo:");
                ahorroMensual = entrada.nextDouble();
            }

            mesesSimulacion = 0;

            while (mesesSimulacion == 0) {
                System.out.println("Seleccione el plazo de simulacion:");
                System.out.println("1. 6 meses");
                System.out.println("2. 12 meses");
                System.out.println("3. 24 meses");
                opcionPlazo = entrada.nextInt();

                switch (opcionPlazo) {
                    case 1:
                        mesesSimulacion = 6;
                        break;
                    case 2:
                        mesesSimulacion = 12;
                        break;
                    case 3:
                        mesesSimulacion = 24;
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                }
            }

            saldo = dineroInicial;
            interesesGenerados = 0;
            mesesNecesarios = -1;

            if (saldo >= metaAhorro) {
                mesesNecesarios = 0;
            }

            for (int mes = 1; mes <= mesesSimulacion; mes++) {
                saldo = saldo + ahorroMensual;
                interesMensual = saldo * TASA_INTERES;
                saldo = saldo + interesMensual;
                interesesGenerados = interesesGenerados + interesMensual;

                if (saldo >= metaAhorro && mesesNecesarios == -1) {
                    mesesNecesarios = mes;
                }
            }

            System.out.printf("Saldo final: $%.2f%n", saldo);
            System.out.printf("Intereses generados: $%.2f%n", interesesGenerados);

            if (mesesNecesarios != -1) {
                System.out.println("Meta alcanzada en el mes: " + mesesNecesarios);
            } else {
                System.out.println("No se alcanzo la meta durante el plazo seleccionado.");
            }

            System.out.println("Desea realizar otra simulacion? (1 = Si, 0 = No)");
            repetir = entrada.nextInt();

        } while (repetir == 1);

        System.out.println("Programa finalizado.");
        entrada.close();
    }
}
