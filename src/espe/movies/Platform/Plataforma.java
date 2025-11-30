package espe.movies.Platform;

import espe.movies.Contents.Alquilable;
import espe.movies.Contents.Contenido;
import espe.movies.Exception.RecursoNoEncontradoException;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Plataforma {
    private String nombre;
    private ArrayList<Contenido> catalogo;

    public Plataforma(String nombre){
        this.nombre = nombre;
        this.catalogo = new ArrayList<>();
    }

    public void agregarContenido(Contenido video){
        this.catalogo.add(video);
        System.out.println("✅ Se agrego "+video.getTitulo()+" al catalogo.");
    }

    public void eliminarContenido(Contenido video){
        this.catalogo.remove(video);
        System.out.println("❌ Se elimino "+video.getTitulo()+" al catalogo");
    }

    public void mostrarCatalogo(){
        System.out.println("\n---- CATALOGO DE "+this.nombre+" ----");

        if(catalogo.isEmpty()){
            System.out.println("El catalogo esta vacio");
        }else{
            for(Contenido video: catalogo){
                System.out.println(video.obtenerFichaTecnica());
            }
        }
    }

    /** sirve para encontrar una pelicula*/
    public Contenido encontrarCotenido(String tituloParaBuscar) throws RecursoNoEncontradoException {
        for(Contenido video: catalogo){
            if(video.getTitulo().equalsIgnoreCase(tituloParaBuscar)){
                return video;
            }
        }
        throw new RecursoNoEncontradoException(tituloParaBuscar);
    }

    public void sugerirPopular(){
        System.out.println("\n----- SUGERENCIA POPULARES --------");
        for(Contenido video: catalogo){
            if(video.isPopular()){
                System.out.println("\uD83D\uDD25 "+video.getTitulo());
            }
        }
    }

    public void mostrarPelículasDisponibles(){
        System.out.println("\n-------- Peliculas disponibles para alquilar --------");
        boolean esPelicula = false;

        for(Contenido video : catalogo){
            if(video instanceof Alquilable && video.isDisponible()){
                System.out.println("\uD83C\uDFAC "+video.getTitulo());
                esPelicula = true;
            }
        }

        if(!esPelicula){
            System.out.println("(No hay películas disponibles en este momento)");
        }
    }
    public void guardarJSON(){
        try(PrintWriter escribir = new PrintWriter(new FileWriter("datos.json"))){
            escribir.println("[");

            for(int i = 0; i<this.catalogo.size(); i++){
                Contenido video = this.catalogo.get(i);

                escribir.print(video.toJSON());

                if(i< catalogo.size()-1){
                    escribir.println(",");
                }else{
                    escribir.println();
                }
            }
            escribir.println("]");
            System.out.println("!JSON guardado exitosamente en 'datos.json'¡");
        }catch(IOException e){
            System.out.println("❌ Error al guardar el JSON "+e.getMessage());
        }
    }
}
