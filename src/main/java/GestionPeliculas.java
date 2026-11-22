import java.util.ArrayList;

public class GestionPeliculas {
    private ArrayList<Pelicula> peliculas;

    public GestionPeliculas() {
        peliculas = new ArrayList<>();
        precargarPeliculas();
    }

    private void precargarPeliculas() {
        peliculas.add(new Pelicula(101, "Interstellar", "Ciencia ficción", 9.5));
        peliculas.add(new Pelicula(102, "Coco", "Animación", 8.9));
        peliculas.add(new Pelicula(103, "Titanic", "Drama", 8.0));
        peliculas.add(new Pelicula(104, "Inception", "Acción", 9.2));
        peliculas.add(new Pelicula(105, "Avatar", "Ciencia ficción", 8.7));
    }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    // 1. Agregar película (búsqueda secuencial para validar código único)
    public boolean agregarPelicula(Pelicula pelicula) {
        for (int i = 0; i < peliculas.size(); i++) {
            if (peliculas.get(i).getCodigo() == pelicula.getCodigo()) {
                return false;
            }
        }
        peliculas.add(pelicula);
        return true;
    }

    // 2. Búsqueda secuencial por título (sin distinguir mayúsculas)
    public Pelicula buscarPorTituloSecuencial(String titulo) {
        for (int i = 0; i < peliculas.size(); i++) {
            if (peliculas.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                return peliculas.get(i);
            }
        }
        return null;
    }

    // 3. Ordenamiento por calificación descendente (inserción directa, sobre una copia)
    public ArrayList<Pelicula> ordenarPorCalificacionDescendente() {
        ArrayList<Pelicula> copia = new ArrayList<>(peliculas);
        for (int i = 1; i < copia.size(); i++) {
            Pelicula actual = copia.get(i);
            int j = i - 1;
            while (j >= 0 && copia.get(j).getCalificacion() < actual.getCalificacion()) {
                copia.set(j + 1, copia.get(j));
                j--;
            }
            copia.set(j + 1, actual);
        }
        return copia;
    }

    // 4. Búsqueda binaria por código (primero ordena una copia por código)
    public Pelicula buscarPorCodigoBinario(int codigo) {
        ArrayList<Pelicula> ordenadas = ordenarPorCodigo();
        int inicio = 0;
        int fin = ordenadas.size() - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            int codigoMedio = ordenadas.get(medio).getCodigo();
            if (codigoMedio == codigo) {
                return ordenadas.get(medio);
            } else if (codigoMedio < codigo) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return null;
    }

    // Auxiliar: ordenamiento por código ascendente (inserción directa, sobre una copia)
    private ArrayList<Pelicula> ordenarPorCodigo() {
        ArrayList<Pelicula> copia = new ArrayList<>(peliculas);
        for (int i = 1; i < copia.size(); i++) {
            Pelicula actual = copia.get(i);
            int j = i - 1;
            while (j >= 0 && copia.get(j).getCodigo() > actual.getCodigo()) {
                copia.set(j + 1, copia.get(j));
                j--;
            }
            copia.set(j + 1, actual);
        }
        return copia;
    }

    // 5. Película mejor calificada (recursivo, sin ciclos)
    public Pelicula buscarMejorCalificadaRecursivo(int indice) {
        if (indice < 0 || indice >= peliculas.size()) {
            return null;
        }
        Pelicula actual = peliculas.get(indice);
        if (indice == peliculas.size() - 1) {
            return actual;
        }
        Pelicula mejorResto = buscarMejorCalificadaRecursivo(indice + 1);
        return actual.getCalificacion() >= mejorResto.getCalificacion() ? actual : mejorResto;
    }

    // 6. Contar películas por género (recursivo, sin ciclos)
    public int contarPorGeneroRecursivo(String genero, int indice) {
        if (indice >= peliculas.size()) {
            return 0;
        }
        int aporte = peliculas.get(indice).getGenero().equalsIgnoreCase(genero) ? 1 : 0;
        return aporte + contarPorGeneroRecursivo(genero, indice + 1);
    }

    // 7. Sumar calificaciones por género (recursivo, sin ciclos)
    public double sumaCalificacionesPorGeneroRecursiva(String genero, int indice) {
        if (indice >= peliculas.size()) {
            return 0.0;
        }
        Pelicula actual = peliculas.get(indice);
        double aporte = actual.getGenero().equalsIgnoreCase(genero) ? actual.getCalificacion() : 0.0;
        return aporte + sumaCalificacionesPorGeneroRecursiva(genero, indice + 1);
    }
}