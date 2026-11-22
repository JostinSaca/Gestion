import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SumaCalificacionesPorGeneroRecursivaTest {
    @Test
    void sumaCalificacionesPorGeneroRecursivamente() {
        GestionPeliculas gestion = new GestionPeliculas();
        gestion.agregarPelicula(new Pelicula(200, "Dune", "Ciencia ficción", 9.1));
        double esperado = 9.5 + 8.7 + 9.1;
        assertEquals(esperado, gestion.sumaCalificacionesPorGeneroRecursiva("Ciencia ficción", 0), 0.001);
        assertEquals(0.0, gestion.sumaCalificacionesPorGeneroRecursiva("Musical", 0), 0.001);
    }
}
