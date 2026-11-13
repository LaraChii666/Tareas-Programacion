import java.util.Scanner;

public class GeneradorCURP {

    static Scanner entrada = new Scanner(System.in);

    static String nombre, paterno, materno;
    static String fecha, sexo, estado;
    static String curp = "";

    static String primeraLetra;
    static String primeraVocal;
    static String letraMaterno;
    static String letraNombre;

    static String año, mes, dia;
    static String claveEstado;

    static String consonantePaterno;
    static String consonanteMaterno;
    static String consonanteNombre;

    public static void main(String[] args) {

        System.out.println("===== GENERADOR DE CURP =====");

        System.out.println("Ingrese su nombre:");
        nombre = entrada.nextLine().toUpperCase();

        System.out.println("Ingrese su apellido paterno:");
        paterno = entrada.nextLine().toUpperCase();

        System.out.println("Ingrese su apellido materno:");
        materno = entrada.nextLine().toUpperCase();

        System.out.println("Ingrese su fecha de nacimiento (DD/MM/AAAA):");
        fecha = entrada.nextLine();

        System.out.println("Ingrese su sexo (H/M):");
        sexo = entrada.nextLine().toUpperCase();

        System.out.println("Ingrese su entidad federativa:");
        estado = entrada.nextLine().toUpperCase();

        obtenerPrimeraLetra();
        obtenerPrimeraVocal();
        obtenerPrimeraConsonante();
        obtenerFecha();
        obtenerClaveEstado();
        generarCURP();

        System.out.println("============================");
        System.out.println("Nombre: " + nombre + " " + paterno + " " + materno);
        System.out.println("CURP: " + curp);
        System.out.println("============================");

        entrada.close();
    }

    public static void obtenerPrimeraLetra() {

        primeraLetra = paterno.charAt(0) + "";
        letraMaterno = materno.charAt(0) + "";

        String[] nombres = nombre.split(" ");
        int posicion = 0;

        if (nombres.length > 1 &&
                (nombres[0].equals("MARIA") || nombres[0].equals("JOSE"))) {
            posicion = 1;
        }

        letraNombre = nombres[posicion].charAt(0) + "";
    }

    public static void obtenerPrimeraVocal() {

        primeraVocal = "X";

        for (int i = 1; i < paterno.length(); i++) {

            char letra = paterno.charAt(i);

            if (letra == 'A' || letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U') {
                primeraVocal = letra + "";
                break;
            }
        }
    }

    public static void obtenerPrimeraConsonante() {

        consonantePaterno = "X";
        consonanteMaterno = "X";
        consonanteNombre = "X";

        for (int i = 1; i < paterno.length(); i++) {

            char letra = paterno.charAt(i);

            if (letra >= 'A' && letra <= 'Z' && letra != 'A' && letra != 'E' && letra != 'I' && letra != 'O' && letra != 'U') {
                consonantePaterno = letra + "";
                break;
            }
        }

        for (int i = 1; i < materno.length(); i++) {

            char letra = materno.charAt(i);

            if (letra >= 'A' && letra <= 'Z' && letra != 'A' && letra != 'E' && letra != 'I' && letra != 'O' && letra != 'U') {
                consonanteMaterno = letra + "";
                break;
            }
        }

        String[] nombres = nombre.split(" ");
        int posicion = 0;

        if (nombres.length > 1 &&
                (nombres[0].equals("MARIA") || nombres[0].equals("JOSE"))) {
            posicion = 1;
        }

        for (int i = 1; i < nombres[posicion].length(); i++) {

            char letra = nombres[posicion].charAt(i);

            if (letra >= 'A' && letra <= 'Z' &&
                    letra != 'A' && letra != 'E' && letra != 'I' &&
                    letra != 'O' && letra != 'U') {

                consonanteNombre = letra + "";
                break;
            }
        }
    }

    public static void obtenerFecha() {

        dia = fecha.substring(0, 2);
        mes = fecha.substring(3, 5);
        año = fecha.substring(8, 10);
    }

    public static void obtenerClaveEstado() {

        switch (estado) {

            case "HIDALGO":
                claveEstado = "HG";
                break;

            case "CIUDAD DE MEXICO":
                claveEstado = "DF";
                break;

            case "ESTADO DE MEXICO":
                claveEstado = "MC";
                break;

            case "PUEBLA":
                claveEstado = "PL";
                break;

            case "VERACRUZ":
                claveEstado = "VZ";
                break;

            case "JALISCO":
                claveEstado = "JC";
                break;

            case "GUANAJUATO":
                claveEstado = "GT";
                break;

            case "QUERETARO":
                claveEstado = "QT";
                break;

            default:
                claveEstado = "XX";
                break;
        }
    }

    public static void generarCURP() {

        int aleatorio1 = (int)(Math.random() * 10);
        int aleatorio2 = (int)(Math.random() * 10);

        curp = primeraLetra + primeraVocal + letraMaterno + letraNombre + año + mes + dia + sexo + claveEstado + consonantePaterno + consonanteMaterno + consonanteNombre + aleatorio1 + aleatorio2;
    }
}