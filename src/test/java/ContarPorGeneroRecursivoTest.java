import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContarPorGeneroRecursivoTest {
    @Test
    void cuentaPorGeneroRecursivamente() {
        GestionPeliculas gestion = new GestionPeliculas();
        gestion.agregarPelicula(new Pelicula(200, "Dune", "Ciencia ficción", 9.1));
        assertEquals(3, gestion.contarPorGeneroRecursivo("Ciencia ficción", 0));
        assertEquals(1, gestion.contarPorGeneroRecursivo("Animación", 0));
        assertEquals(0, gestion.contarPorGeneroRecursivo("Musical", 0));
    }
}
