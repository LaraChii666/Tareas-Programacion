import java.util.Scanner;

public class SistCalificaciones {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        final double MINIMO_APROBATORIO = 70;
        final double MINIMO_UNIDAD = 60;
        double c1, c2, c3;
        double promedio;

        System.out.println("Ingrese su primera calificación: ");
        c1 = entrada.nextDouble();
        System.out.println("Ingrese su segunda calificación: ");
        c2 = entrada.nextDouble();
        System.out.println("Ingrese una tercera calificación: ");
        c3 = entrada.nextDouble();
        promedio = (c1 + c2 + c3) / 3;

        if (c1 < MINIMO_UNIDAD) {
            System.out.println("Debe presentar recuperación en la unidad 1.");
        }
        if (c2 < MINIMO_UNIDAD) {
            System.out.println("Debe presentar recuperación en la unidad 2.");
        }
        if (c3 < MINIMO_UNIDAD) {
            System.out.println("Debe presentar recuperación en la unidad 3.");
        }
        if (promedio >= MINIMO_APROBATORIO) {
            System.out.println("Calificación 1: " + c1);
            System.out.println("Calificación 2: " + c2);
            System.out.println("Calificación 3: " + c3);
            System.out.println("calificación Final: " + promedio);
            System.out.println("Usted ha aprobado");


        } else {
            System.out.println("Calificación Final:" + promedio);
            System.out.println("Usted ha reprobado");

        }
    }
}

