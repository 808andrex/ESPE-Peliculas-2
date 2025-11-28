package espe.movies.Contenidos;

public class Peliculas extends Contenido{
    private boolean ganoOscar;

    public Peliculas(String titulo, String genero, int duracion, double calificacion, boolean ganoOscar) {
        super(titulo, genero, duracion, calificacion);
        this.ganoOscar = ganoOscar;
    }

    @Override
    public String obtenerFichaTecnica() {
        String infoExtra = this.ganoOscar ? " Ganadora del oscar":"";
        return super.obtenerFichaTecnica()+infoExtra;
    }

    public boolean isGanoOscar() {
        return ganoOscar;
    }

    public void setGanoOscar(boolean ganoOscar) {
        this.ganoOscar = ganoOscar;
    }

    @Override
    public String toJSON() {
        return "{\n"+
                " \"tipo\": \"Pelicula\",\n"+
                " \"titulo\": \""+getTitulo()+"\",\n"+
                " \"genero\": \""+getGenero()+"\",\n"+
                " \"duracion\": "+getDuracion() +",\n"+
                " \"calificacion\": "+getCalificacion() +",\n"+
                " \"ganoOscar\": "+this.ganoOscar +"\n"+
                "}";
    }
}
