
import java.util.Scanner;

public class CompetenciaResistencia {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        final int RONDAS = 5;
        final double DISTANCIA_BAJA = 2;
        final double DISTANCIA_ALTA = 4;

        int participantes;
        int repetir;
        int opcion;
        int rondasBajas;
        int rondasMedias;
        int rondasAltas;
        int mejorParticipante;
        int numeroParticipante;
        double distancia;
        double distanciaTotal;
        double promedio;
        double mayorDistancia;
        double totalCompetencia;
        double totalPromedios;

        do {
            System.out.println("Ingrese la cantidad de participantes:");
            participantes = entrada.nextInt();

            while (participantes <= 0) {
                System.out.println("Error. Ingrese una cantidad mayor que cero:");
                participantes = entrada.nextInt();
            }

            rondasBajas = 0;
            rondasMedias = 0;
            rondasAltas = 0;
            mayorDistancia = -1;
            mejorParticipante = 0;
            totalCompetencia = 0;
            totalPromedios = 0;

            for (int participante = 1; participante <= participantes; participante++) {
                distanciaTotal = 0;

                System.out.println("Participante " + participante);

                for (int ronda = 1; ronda <= RONDAS; ronda++) {
                    System.out.println("Ingrese la distancia recorrida en la ronda " + ronda + " (km):");
                    distancia = entrada.nextDouble();

                    while (distancia < 0) {
                        System.out.println("Error. La distancia no puede ser negativa:");
                        distancia = entrada.nextDouble();
                    }

                    distanciaTotal += distancia;

                    if (distancia < DISTANCIA_BAJA) {
                        rondasBajas++;
                        System.out.println("Rendimiento bajo.");
                    } else if (distancia <= DISTANCIA_ALTA) {
                        rondasMedias++;
                        System.out.println("Rendimiento medio.");
                    } else {
                        rondasAltas++;
                        System.out.println("Rendimiento alto.");
                    }
                }

                promedio = distanciaTotal / RONDAS;
                totalCompetencia += distanciaTotal;
                totalPromedios += promedio;

                System.out.printf("Distancia total del participante %d: %.2f km%n",
                        participante, distanciaTotal);
                System.out.printf("Promedio por ronda: %.2f km%n", promedio);

                if (distanciaTotal > mayorDistancia) {
                    mayorDistancia = distanciaTotal;
                    mejorParticipante = participante;
                }
            }

            System.out.println("===== ESTADISTICAS GENERALES =====");
            System.out.println("1. Mostrar cantidad de rondas por rendimiento");
            System.out.println("2. Mostrar distancia total de la competencia");
            System.out.println("3. Mostrar participante con mayor distancia");
            System.out.println("4. Mostrar todas las estadisticas");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Rondas con rendimiento bajo: " + rondasBajas);
                    System.out.println("Rondas con rendimiento medio: " + rondasMedias);
                    System.out.println("Rondas con rendimiento alto: " + rondasAltas);
                    break;

                case 2:
                    System.out.printf("Distancia total de la competencia: %.2f km%n",
                            totalCompetencia);
                    break;

                case 3:
                    System.out.println("Participante con mayor distancia: " + mejorParticipante);
                    System.out.printf("Distancia acumulada: %.2f km%n", mayorDistancia);
                    break;

                case 4:
                    System.out.println("Rondas con rendimiento bajo: " + rondasBajas);
                    System.out.println("Rondas con rendimiento medio: " + rondasMedias);
                    System.out.println("Rondas con rendimiento alto: " + rondasAltas);
                    System.out.printf("Distancia total de la competencia: %.2f km%n",
                            totalCompetencia);
                    System.out.println("Participante con mayor distancia: " + mejorParticipante);
                    System.out.printf("Mayor distancia acumulada: %.2f km%n", mayorDistancia);
                    System.out.printf("Promedio de distancia por participante: %.2f km%n",
                            totalPromedios / participantes);
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

            System.out.println("Desea registrar otra competencia? (1 = Si, 0 = No)");
            repetir = entrada.nextInt();

        } while (repetir == 1);

        System.out.println("Programa finalizado.");
        entrada.close();
    }
}
