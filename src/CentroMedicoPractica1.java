import java.util.Scanner;

public class CentroMedicoPractica1 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        final double DESCUENTO_ADULTO_MAYOR = 0.15;

        int edad;
        int ninos = 0;
        int adolescentes = 0;
        int adultos = 0;
        int adultosMayores = 0;
        int totalPacientes = 0;
        int opcion;

        double costoConsulta;
        double descuento;
        double totalPagar;
        double totalRecaudado = 0;
        double totalDescuentos = 0;
        double promedioPagado;

        do {
            System.out.println("===== CENTRO MEDICO =====");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Finalizar y mostrar resumen");
            System.out.print("Seleccione una opcion: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la edad del paciente: ");
                    edad = entrada.nextInt();

                    if (edad >= 0) {
                        System.out.print("Ingrese el costo de la consulta: $");
                        costoConsulta = entrada.nextDouble();

                        if (costoConsulta >= 0) {
                            descuento = 0;

                            if (edad < 12) {
                                ninos++;
                                System.out.println("Categoria: Niño");
                            } else if (edad <= 17) {
                                adolescentes++;
                                System.out.println("Categoria: Adolescente");
                            } else if (edad <= 59) {
                                adultos++;
                                System.out.println("Categoria: Adulto");
                            } else {
                                adultosMayores++;
                                descuento = costoConsulta * DESCUENTO_ADULTO_MAYOR;
                                System.out.println("Categoria: Adulto mayor");
                            }

                            totalPagar = costoConsulta - descuento;
                            totalRecaudado += totalPagar;
                            totalDescuentos += descuento;
                            totalPacientes++;

                            System.out.println("Costo de consulta: $" + costoConsulta);
                            System.out.println("Descuento aplicado: $" + descuento);
                            System.out.println("Total a pagar: $" + totalPagar);
                        } else {
                            System.out.println("El costo de la consulta no es valido.");
                        }
                    } else {
                        System.out.println("La edad no puede ser negativa.");
                    }
                    break;

                case 2:
                    if (totalPacientes > 0) {
                        promedioPagado = totalRecaudado / totalPacientes;

                        System.out.println("===== RESUMEN DEL DIA =====");
                        System.out.println("Total de pacientes: " + totalPacientes);
                        System.out.println("Niños: " + ninos);
                        System.out.println("Adolescentes: " + adolescentes);
                        System.out.println("Adultos: " + adultos);
                        System.out.println("Adultos mayores: " + adultosMayores);
                        System.out.println("Dinero recaudado: $" + totalRecaudado);
                        System.out.println("Descuentos aplicados: $" + totalDescuentos);
                        System.out.println("Promedio pagado por paciente: $" + promedioPagado);
                    } else {
                        System.out.println("No se registraron pacientes.");
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
