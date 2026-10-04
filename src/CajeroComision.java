import java.util.Scanner;

public class CajeroComision {
    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);

        final double COMISION = 10;
        final double LIMITE_RETIRO = 5000;
        double saldo;
        double retiro;

        System.out.println("Ingresa el saldo disponible: $");
        saldo = entrada.nextDouble();
        System.out.println("Ingresa la cantidad a retirar: $");
        retiro = entrada.nextDouble();

        if (retiro > 0){
            if (retiro <= LIMITE_RETIRO){
                if (saldo >= retiro + COMISION) {
                    double saldoFinal = saldo - retiro - COMISION;
                    System.out.println("Retiro autorizado.");
                    System.out.println("Cantidad retirada: $" + retiro);
                    System.out.println("Comisión: $" + COMISION);
                    System.out.println("Saldo final: $" + saldoFinal);
                } else {
                    System.out.println("Saldo insuficiente para realizar el retiro y cubrir la comisión.");
                }

                } else {
                System.out.println("El retiro supera el limite permitido de $" + LIMITE_RETIRO);
            }
            } else {
            System.out.println("La cantidad a retirar debe ser mayor a $0");
        }

        }

}
