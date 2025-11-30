package espe.movies.Platform.Util;

import espe.movies.Contents.Genero;

import java.util.Scanner;

public class ScannerUtils {
    public static Scanner scanner = new Scanner(System.in);

    public static String capturarTexto(String mensaje){
        System.out.print(mensaje +": ");
        return  scanner.nextLine();
    }

    public static boolean capturarBooleano(String mensaje){
        System.out.print(mensaje+": ");
        boolean entrada = scanner.nextBoolean();
        scanner.nextLine();
        return entrada;
    }

    public static char capturarChar(String mensaje){
        System.out.print(mensaje+": ");
        char entrada = scanner.next().charAt(0);
        scanner.nextLine();
        return entrada;
    }
    public static int capturarNumero(String mensaje){
        System.out.print(mensaje+": ");
        int entrada = scanner.nextInt();
        scanner.nextLine();
        return entrada;
    }

    public static double capturarDecimal(String mensaje){
        System.out.print(mensaje+": ");
        double entrada = scanner.nextDouble();
        scanner.nextLine();
        return entrada;
    }

    public static Genero capturarGenero(String mensaje){
        System.out.println(mensaje+": ");

        System.out.println("----Opciones-----");
        for(Genero genero : Genero.values()){
            System.out.print(genero +" | ");
        }
        System.out.println();

        while (true){
            System.out.print("Eliga una opcion: ");
            String entrada = scanner.nextLine().toUpperCase().trim();

            try {
                return Genero.valueOf(entrada);
            }catch(IllegalArgumentException e){
                System.out.println("❌ Opcion no valida. Intente de nuevo (ej. DRAMA)");
            }
        }
    }
}
