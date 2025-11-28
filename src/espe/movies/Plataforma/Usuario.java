package espe.movies.Plataforma;

import espe.movies.Contenidos.Contenido;

import java.time.LocalDateTime;

public class Usuario {
    private String nombre;
    private String correo;
    private LocalDateTime fechaRegistro;

    public Usuario(String nombre, String correo) {
        this.nombre = nombre;
        this.correo=correo;
        this.fechaRegistro= LocalDateTime.now();
    }

    public void ver(Contenido video){
        System.out.println(nombre+ " esta viendo ...");
        System.out.println(video.obtenerFichaTecnica());
        video.reproducir();
    }

    /** GETTERS Y SETTERS */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
