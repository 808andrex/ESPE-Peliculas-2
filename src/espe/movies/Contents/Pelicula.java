package espe.movies.Contents;

public class Pelicula extends Contenido implements Alquilable {
    private boolean ganoOscar;

    public Pelicula(String titulo, Genero genero, int duracion, double calificacion, boolean ganoOscar) {
        super(titulo, genero, duracion, calificacion);
        this.ganoOscar = ganoOscar;
    }

    @Override
    public String obtenerFichaTecnica() {
        String infoExtra = this.ganoOscar ? " Ganadora del oscar":"";
        return super.obtenerFichaTecnica()+infoExtra;
    }

    @Override
    public String toJSON() {
        return "{\n"+
                "\"tipo\": \"Serie\", \n"+
                "\"titulo\": \""+ getTitulo()+"\",\n"+
                "\"genero\": \""+ getGenero()+"\", \n"+
                "\"duration\": "+ getDuracion()+",\n"+
                "\"calificacion\": "+ getCalificacion()+",\n"+
                "\"Gano Oscar\": "+ ganoOscar +",\n"+
                "}";
    }

    @Override
    public void alquilar() {
        if (isDisponible()){
            setDisponible(false);
            System.out.println("Alquilaste "+ getTitulo()+" por $"+ PRECIO_ALQUILER);
        }else{
            System.out.println("❌ Lo sentimos, "+ getTitulo()+" ya se alquilada.");
        }
    }

    @Override
    public void devolver() {
        setDisponible(true);
        System.out.println("Has devuelto "+ getTitulo()+" ,Gracias");
    }

    /** GETTERS Y SETTERS*/
    public boolean isGanoOscar() {
        return ganoOscar;
    }

    public void setGanoOscar(boolean ganoOscar) {
        this.ganoOscar = ganoOscar;
    }
}