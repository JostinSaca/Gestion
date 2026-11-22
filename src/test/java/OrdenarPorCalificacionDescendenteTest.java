import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class OrdenarPorCalificacionDescendenteTest {
    @Test
    void ordenaDeMayorAMenor() {
        GestionPeliculas gestion = new GestionPeliculas();
        gestion.agregarPelicula(new Pelicula(200, "Baja", "Drama", 5.0));
        gestion.agregarPelicula(new Pelicula(201, "Alta", "Drama", 9.9));
        ArrayList<Pelicula> ordenadas = gestion.ordenarPorCalificacionDescendente();
        for (int i = 0; i < ordenadas.size() - 1; i++) {
            assertTrue(ordenadas.get(i).getCalificacion() >= ordenadas.get(i + 1).getCalificacion());
        }
        assertEquals("Alta", ordenadas.get(0).getTitulo());
    }
}
