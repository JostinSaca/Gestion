import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AgregarPeliculaTest {
    @Test
    void agregaPeliculaConCodigoNuevoYRechazaDuplicado() {
        GestionPeliculas gestion = new GestionPeliculas();
        int inicial = gestion.getPeliculas().size();
        assertTrue(gestion.agregarPelicula(new Pelicula(200, "Matrix", "Ciencia ficción", 9.0)));
        assertEquals(inicial + 1, gestion.getPeliculas().size());
        assertFalse(gestion.agregarPelicula(new Pelicula(200, "Matrix Reloaded", "Ciencia ficción", 8.0)));
        assertEquals(inicial + 1, gestion.getPeliculas().size());
    }
}
