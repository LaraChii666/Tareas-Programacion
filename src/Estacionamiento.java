import java.util.Scanner;

public class Estacionamiento {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        final double TARIFA_MOTOCICLETA = 10;
        final double TARIFA_AUTOMOVIL = 20;
        final double TARIFA_CAMIONETA = 30;
        final double DESCUENTO_5_HORAS = 0.10;
        final double DESCUENTO_10_HORAS = 0.20;

        int tipoVehiculo;
        double horas;
        double tarifa = 0;
        double subtotal;
        double descuento = 0;
        double total;

        System.out.println("Ingresa el tipo de vehiculo");
        System.out.println("1. Motocicleta");
        System.out.println("2. Automovil");
        System.out.println("3. Camioneta");
        tipoVehiculo = entrada.nextInt();

        System.out.println("Ingresa el número de horas:");
        horas = entrada.nextDouble();

        if (horas <= 0) {
            System.out.println("La cantidad de horas no es válida.");
        } else {
            if (tipoVehiculo == 1) {
                tarifa = TARIFA_MOTOCICLETA;
            } else if (tipoVehiculo == 2) {
                tarifa = TARIFA_AUTOMOVIL;
            } else if (tipoVehiculo == 3) {
                tarifa = TARIFA_CAMIONETA;
            }

            subtotal = tarifa * horas;

            if (horas > 10) {
                descuento = DESCUENTO_10_HORAS;
            } else if (horas > 5) {
                descuento = DESCUENTO_5_HORAS;
            }

            total = subtotal - (subtotal * descuento);

            System.out.println("Tipo de vehículo: " + tipoVehiculo);
            System.out.println("Horas: " + horas);
            System.out.println("Tarifa por hora: $" + tarifa);
            System.out.println("Subtotal: $" + subtotal);
            System.out.println("Descuento: $" + descuento * 100);
            System.out.println("Total a pagar: $" + total);


        }
    }
}
