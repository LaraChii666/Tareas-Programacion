import java.util.Scanner;

public class TiendaDescuentos {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String nombre;
        double compra;
        int tipoCliente;
        double descuento = 0;
        double montoDescuento;
        double totalPagar;
        final double CLIENTE_NORMAL = 0.0;
        final double CLIENTE_FRECUENTE = 0.10;
        final double CLIENTE_VIP = 0.20;
        final double DESCUENTO_ADICIONAL = 0.05;

        System.out.println("Ingrese nombre del cliente: ");
        nombre = entrada.nextLine();
        System.out.println("Ingrese monto de compra: $");
        compra = entrada.nextDouble();
        System.out.println("Ingrese tipo de cliente");
        tipoCliente = entrada.nextInt();

        if (tipoCliente == 1) {
            descuento = CLIENTE_NORMAL;
        }
        if (tipoCliente == 2) {
            descuento = CLIENTE_FRECUENTE;
        }
        if (tipoCliente == 3) {
            descuento = CLIENTE_VIP;
        }
        if (compra > 2000){
            descuento = descuento + DESCUENTO_ADICIONAL;
        }
        montoDescuento = compra * descuento;
        totalPagar = compra - montoDescuento;
        System.out.println("Cliente: " + nombre);
        System.out.println("Monto original: $" + compra);
        System.out.println("Descuento aplicado: " + (descuento * 100) + "%");
        System.out.println("Monto descontado: $" + montoDescuento);
        System.out.println("Total a pagar: $" + totalPagar);

    }
}
