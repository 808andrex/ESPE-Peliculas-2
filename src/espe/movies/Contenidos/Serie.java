package espe.movies.Contenidos;

public class Serie extends Contenido{
    private int numTemporadas;

    public Serie(String titulo, String genero, int duracion, double calificacion, int numTemporadas) {
        super(titulo, genero, duracion, calificacion);
        this.numTemporadas = numTemporadas;
    }

    @Override
    public String obtenerFichaTecnica() {
        String fichaPadre = super.obtenerFichaTecnica();
        return fichaPadre+" | Temporadas: "+this.numTemporadas;
    }

    public int getNumTemporadas() {
        return numTemporadas;
    }

    public void setNumTemporadas(int numTemporadas) {
        this.numTemporadas = numTemporadas;
    }

    @Override
    public String toJSON() {
        return "{\n"+
                " \"tipo\": \"Serie\",\n"+
                " \"titulo\": \""+getTitulo()+"\",\n"+
                " \"genero\": \""+getGenero()+"\",\n"+
                " \"duracion\": "+getDuracion() +",\n"+
                " \"calificacion\": "+getCalificacion() +",\n"+
                " \"numTemporadas\": "+this.numTemporadas + "\n"+
                "}";
    }
}
