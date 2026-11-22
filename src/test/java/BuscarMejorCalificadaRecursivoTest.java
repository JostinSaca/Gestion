import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BuscarMejorCalificadaRecursivoTest {
    @Test
    void encuentraMejorCalificadaRecursivamente() {
        GestionPeliculas gestion = new GestionPeliculas();
        gestion.agregarPelicula(new Pelicula(200, "Obra Maestra", "Drama", 9.9));
        Pelicula mejor = gestion.buscarMejorCalificadaRecursivo(0);
        assertNotNull(mejor);
        assertEquals("Obra Maestra", mejor.getTitulo());
        assertEquals(9.9, mejor.getCalificacion(), 0.001);
    }
}
