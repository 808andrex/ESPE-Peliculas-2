package espe.movies.Plataforma;

import espe.movies.Contenidos.Contenido;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Plataforma {
    private String nombre;
    private ArrayList<Contenido> catalogo;

    public Plataforma(String nombre){
        this.nombre=nombre;
        this.catalogo = new ArrayList<>();
    }

    public void agregarContenido(Contenido video){
        this.catalogo.add(video);
        System.out.println("Se agrego "+video.getTitulo()+" al catalogo.");
    }

    public void mostrarCatalogo(){
        System.out.println("\n---- CATALOGO DE "+this.nombre+" ----");

        if(catalogo.isEmpty()){
            System.out.println("El catalogo esta vacio");
        }else{
            for(Contenido video:catalogo){
                System.out.println(video.obtenerFichaTecnica());
            }
        }
    }

    public void sugerirPopular(){
        System.out.println("\n----- SUGERENCIA POPULARES --------");
        for(Contenido video: catalogo){
            if(video.esPopular()){
                System.out.println("\uD83D\uDD25 "+video.getTitulo());
            }
        }
    }

    public void guardarJSON(){
        try(PrintWriter writer = new PrintWriter(new FileWriter("datos.json"))){
            writer.println("[");
            for(int i = 0; i<this.catalogo.size();i++){
                Contenido video = this.catalogo.get(i);
                writer.print(video.toJSON());

                if(i<catalogo.size()-1){
                    writer.println(",");
                }else {
                    writer.println();
                }
            }
            writer.println("]");
            System.out.println("\uD83D\uDCBE ¡JSON generado exitosamente en 'datos.json'!");
        }catch (IOException e){
            System.out.println("❌ Error al guardar JSON: " + e.getMessage());
        }
    }
}
