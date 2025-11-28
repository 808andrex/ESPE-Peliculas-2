package espe.movies.Contenidos;

import java.time.LocalDate;

public abstract class Contenido {
    public static final double CALIFICACION_MINIMA = 0.0;
    public static final double CALIFICACION_MAXIMA = 5.0;
    public static final double CALIFICACION_PARA_SER_POPULAR = 4.0;

    private   String titulo;
    private  String genero;
    private  int duracion;
    private LocalDate fechaEstreno;
    private  double calificacion;
    private  boolean disponible;
    private  String descripcion;

    public Contenido(String titulo, String genero, int duracion, double calificacion){
        this.titulo=titulo;
        this.genero=genero;
        this.duracion=duracion;
        this.disponible=true;
        this.fechaEstreno= LocalDate.now();
        setCalificacion(calificacion);
    }

    public void reproducir(){
        System.out.println("Reproduciendo: "+this.titulo);
    }


    public boolean esPopular(){
        return getCalificacion()>=CALIFICACION_PARA_SER_POPULAR;
    }

    public String obtenerFichaTecnica(){
        return this.titulo + " ("+this.fechaEstreno+") - "+this.genero+", Duracion: "+this.duracion;
    }

    /** GETTERS Y SETTERS*/
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public double getCalificacion() {

        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        if(calificacion>= CALIFICACION_MINIMA && calificacion <= CALIFICACION_MAXIMA){
            this.calificacion=calificacion;
        }else{
            System.out.println("Error: La calificacion debe estar entre "+CALIFICACION_MINIMA+"y "+CALIFICACION_MAXIMA);
        }
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public abstract String toJSON();
}
