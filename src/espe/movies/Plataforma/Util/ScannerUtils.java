package espe.movies.Plataforma.Util;

import java.util.Scanner;

public class ScannerUtils {
    public static Scanner scanner = new Scanner(System.in);
    public static String capturarTexto(String mensaje){
        System.out.print(mensaje+": ");
        return  scanner.nextLine();
    }

    public static boolean capturarBooleano(String mensaje){
        System.out.print(mensaje+": ");
        boolean dato = scanner.nextBoolean();
        scanner.nextLine();
        return dato;
    }

    public static char capturarChar(String mensaje){
        System.out.print(mensaje+": ");
        char dato = scanner.next().charAt(0);
        scanner.nextLine();
        return dato;
    }
    public static int capturarNumero(String mensaje){
        System.out.print(mensaje+": ");
        int dato = scanner.nextInt();
        scanner.nextLine();
        return dato;
    }

    public static double capturarDecimal(String mensaje){
        System.out.print(mensaje+": ");
        double dato = scanner.nextDouble();
        scanner.nextLine();
        return dato;
    }
}
