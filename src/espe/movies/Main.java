package espe.movies;

import espe.movies.Contents.Genero;
import espe.movies.Contents.Pelicula;
import espe.movies.Contents.Alquilable;
import espe.movies.Contents.Serie;
import espe.movies.Exception.RecursoNoEncontradoException;
import espe.movies.Platform.Plataforma;
import espe.movies.Platform.Util.ScannerUtils;


public class Main {
    public static final String VERSION = "1.0.0";
    public static final String NOMBRE_PLATAFORMA  = "ESPE Movies \uD83C\uDFAC";
    public static void main(String[] args) {

        Plataforma netflixESPE = new Plataforma("ESPE movies");
        System.out.println(NOMBRE_PLATAFORMA +" v"+VERSION);
        char otro;
        do{
            String titulo = ScannerUtils.capturarTexto("Nombre");
            Genero genero = ScannerUtils.capturarGenero("Selecciona el Genero");
            double calificacion = ScannerUtils.capturarDecimal("Calificaciones (0-5)");
            int duracion = ScannerUtils.capturarNumero("Duracion (min)");
            boolean esPelicula = ScannerUtils.capturarBooleano("¿Es pelicula? (true/false)");

            if(esPelicula){
                boolean ganoOscar = ScannerUtils.capturarBooleano("Gano un oscar? (True/false)");
                Pelicula movies = new Pelicula(titulo, genero, duracion, calificacion, ganoOscar);
                netflixESPE.agregarContenido(movies);
            }else{
                int numTemporadas = ScannerUtils.capturarNumero("Num temporadas");
                Serie serie = new Serie(titulo, genero, duracion, calificacion, numTemporadas);
                netflixESPE.agregarContenido(serie);
            }

            otro = ScannerUtils.capturarChar("¿Deseas agregar otro contenido? (s/n)");
        }while (otro == 's'|| otro == 'S'|| otro == 'y' || otro == 'Y');

        netflixESPE.mostrarCatalogo();
        netflixESPE.sugerirPopular();
        netflixESPE.guardarJSON();

        char opcionAlquilar = ScannerUtils.capturarChar("\nDeseas alquilar una pelicula?(s/n)");

        while(opcionAlquilar == 's' || opcionAlquilar == 'S'){
            netflixESPE.mostrarPelículasDisponibles();

            String tituloRentado = ScannerUtils.capturarTexto("¿Cual titulo quiere alquilar?");

            try{
                var contenidoEncontrado = netflixESPE.encontrarCotenido(tituloRentado);
                if(contenidoEncontrado != null){
                    if(contenidoEncontrado instanceof Alquilable){
                        ((Alquilable)contenidoEncontrado).alquilar();
                    }else{
                        System.out.println("⚠️ '" + contenidoEncontrado.getTitulo() + "' es una Serie (Solo suscripcion).");
                    }
                }else{
                    System.out.println("❌ No encontramos nada con el nombre: " + tituloRentado);
                }
            }catch(RecursoNoEncontradoException e){
                System.out.println(e.getMessage());
                System.out.println("Sugerencia: Revisa si escribiste bien el nombre.");
            }
            opcionAlquilar = ScannerUtils.capturarChar("\n¿Deseas alquilar otra pelicula?(s/n)");
        }
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
