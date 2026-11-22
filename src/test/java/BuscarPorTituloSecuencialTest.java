import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BuscarPorTituloSecuencialTest {
    @Test
    void buscaTituloIgnorandoMayusculas() {
        GestionPeliculas gestion = new GestionPeliculas();
        Pelicula pelicula = gestion.buscarPorTituloSecuencial("interstellar");
        assertNotNull(pelicula);
        assertEquals(101, pelicula.getCodigo());
        assertNull(gestion.buscarPorTituloSecuencial("No Existe"));
    }
}
