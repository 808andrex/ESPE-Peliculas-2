package espe.movies;

import espe.movies.Contenidos.Peliculas;
import espe.movies.Contenidos.Serie;
import espe.movies.Plataforma.Plataforma;
import espe.movies.Plataforma.Util.ScannerUtils;


public class Main {
    public static final String VERSION = "1.0.0";
    public static final String NOMBRE_PLATAFORMA = "ESPE Movies \uD83C\uDFAC";
    public static void main(String[] args) {

        Plataforma netflixESPE = new Plataforma("ESPE movies");
        System.out.println(NOMBRE_PLATAFORMA+" v"+VERSION);
        char otro;
        do{
            String titulo = ScannerUtils.capturarTexto("Nombre");
            String genero = ScannerUtils.capturarTexto("Genero");
            double calificacion = ScannerUtils.capturarDecimal("Calificaciones (0-5)");
            int duracion = ScannerUtils.capturarNumero("Duracion (min)");
            boolean esPelicula = ScannerUtils.capturarBooleano("¿Es pelicula? (true/false)");

            if(esPelicula){
                boolean ganoOscar = ScannerUtils.capturarBooleano("Gano un oscar? (True/false)");
                Peliculas movie = new Peliculas(titulo,genero,duracion, calificacion,ganoOscar);
                netflixESPE.agregarContenido(movie);
            }else{
                int temporadas = ScannerUtils.capturarNumero("Num temporadas");
                Serie serie = new Serie(titulo,genero,duracion,calificacion,temporadas);
                netflixESPE.agregarContenido(serie);
            }

            otro = ScannerUtils.capturarChar("¿Deseas agregar otro contenido? (s/n)");
        }while (otro == 's'|| otro == 'S'||otro == 'y' || otro == 'Y');

        netflixESPE.mostrarCatalogo();
        netflixESPE.sugerirPopular();
        netflixESPE.guardarJSON();

        System.out.println("¡Gracias por usar ESPE Movies! \uD83D\uDC4B");


//        long duracionLong = movie.duraciom;
//        System.out.println("Duracion long "+duracionLong);x
//        int calificacion = (int)movie.calificacion;
//        System.out.println("Calificacion int: "+calificacion);
//        long numeroDePremios = Long.parseLong("14");

/*        String nombre = ScannerUtils.capturarTexto("Nombre de Usuario");
        String correo = ScannerUtils.capturarTexto("Correo de Usuario");

        Usuario user = new Usuario(nombre,correo);
        user.ver(movie);*/

/*      Scanner scanner = new Scanner(System.in);
        System.out.print("Cual es tu nombre?: ");
        String nombre = scanner.nextLine();
        System.out.println("Hola "+nombre+", esto es una prueba");
        System.out.print("Ingresa tu edad: ");
        int edad = scanner.nextInt();

        System.out.println("Tu edad es "+edad);*/
    }
}
