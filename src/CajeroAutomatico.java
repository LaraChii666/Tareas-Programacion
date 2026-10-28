import java.util.Scanner;

public class CajeroAutomatico {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        double saldo;
        double retiro;
        double saldoRestante;

        final double LIMITE_RETIRO = 5000;

        System.out.println("Ingrese el saldo disponible: $");
        saldo = entrada.nextDouble();
        System.out.println("Ingresa la cantidad a retirar: $");
        retiro = entrada.nextDouble();

        if (retiro > 0){
            if (retiro <= LIMITE_RETIRO){
                if (retiro <= saldo){
                    saldoRestante = saldo - retiro;

                    System.out.println("Retiro Autorizado.");
                    System.out.println("Efectivo entregado: $" + retiro);
                    System.out.println("Saldo restante: $" + saldoRestante);

                    if (saldoRestante < 500){
                        System.out.println("Advertencia: Tu saldo restante es menor a $500 ");
                    }
                } else System.out.println("Su monto de retiro excede el saldo disponible");
            } else System.out.println("Su retiro supera el limite diario");
        } else System.out.println("Ingrese una cantidad válida.");





    }
}
