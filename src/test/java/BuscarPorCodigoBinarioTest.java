import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BuscarPorCodigoBinarioTest {
    @Test
    void buscaPorCodigoAunqueListaNoEsteOrdenada() {
        GestionPeliculas gestion = new GestionPeliculas();
        gestion.agregarPelicula(new Pelicula(99, "Antes", "Drama", 7.0));
        gestion.agregarPelicula(new Pelicula(250, "Despues", "Acción", 7.5));
        assertEquals("Antes", gestion.buscarPorCodigoBinario(99).getTitulo());
        assertEquals("Despues", gestion.buscarPorCodigoBinario(250).getTitulo());
        assertNull(gestion.buscarPorCodigoBinario(999));
    }
}
