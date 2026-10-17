import java.util.Scanner;

public class Gasolineria {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        final double DESCUENTO = 0.05;
        final double LITROS_MINIMOS = 40;

        int opcion;
        int cargasRegistradas = 0;
        int cargasConDescuento = 0;

        double litros;
        double precioLitro;
        double importe;
        double descuento;
        double totalPagar;

        double totalLitros = 0;
        double importeAcumulado = 0;
        double totalCobrado = 0;
        double promedio;

        do {
            System.out.println("===== GASOLINERA =====");
            System.out.println("1. Registrar carga");
            System.out.println("2. Finalizar");
            System.out.print("Seleccione una opcion: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese los litros cargados: ");
                    litros = entrada.nextDouble();

                    System.out.print("Ingrese el precio por litro: $");
                    precioLitro = entrada.nextDouble();

                    if (litros > 0 && precioLitro > 0) {
                        importe = litros * precioLitro;
                        descuento = 0;

                        if (litros >= LITROS_MINIMOS) {
                            descuento = importe * DESCUENTO;
                            cargasConDescuento++;
                        }

                        totalPagar = importe - descuento;

                        cargasRegistradas++;
                        totalLitros += litros;
                        importeAcumulado += importe;
                        totalCobrado += totalPagar;

                        System.out.println("Litros cargados: " + litros);
                        System.out.println("Precio por litro: $" + precioLitro);
                        System.out.println("Importe antes del descuento: $" + importe);
                        System.out.println("Descuento aplicado: $" + descuento);
                        System.out.println("Total a pagar: $" + totalPagar);

                    } else {
                        System.out.println("Los litros y el precio deben ser mayores que cero.");
                    }
                    break;

                case 2:
                    System.out.println("===== RESUMEN DEL DIA =====");
                    System.out.println("Cargas registradas: " + cargasRegistradas);
                    System.out.println("Cargas con descuento: " + cargasConDescuento);
                    System.out.println("Total de litros vendidos: " + totalLitros);
                    System.out.println("Importe antes de descuentos: $" + importeAcumulado);
                    System.out.println("Total cobrado: $" + totalCobrado);

                    if (cargasRegistradas > 0) {
                        promedio = totalCobrado / cargasRegistradas;
                        System.out.println("Importe promedio por carga: $" + promedio);
                    } else {
                        System.out.println("No se registraron cargas.");
                    }

                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 2);

        entrada.close();
    }
}