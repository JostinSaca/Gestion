public class Pelicula {
    private int codigo;
    private String titulo;
    private String genero;
    private double calificacion;

    public Pelicula(int codigo, String titulo, String genero, double calificacion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.genero = genero;
        this.calificacion = calificacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

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

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return codigo + " - " + titulo + " (" + genero + ") - " + calificacion;
    }
}
