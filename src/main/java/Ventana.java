import javax.swing.*;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Ventana {
    private JPanel principal;
    private JTabbedPane tabbedPane1;
    private JSpinner spiCodigo;
    private JTextField txtTitulo;
    private JComboBox cboGenero;
    private JTextField txtCalificacion;
    private JButton btnAgregar;
    private JList lstPeliculas;
    private JTextField txtBuscarTitulo;
    private JButton btnBuscarTitulo;
    private JSpinner spiBuscarCodigo;
    private JButton btnBuscarCodigo;
    private JButton btnOrdenar;
    private JTextArea txtResultados;
    private JButton btnMejor;
    private JComboBox cboGeneroRecursivo;
    private JButton btnContar;
    private JButton btnSumar;
    private JTextArea txtResultadoRecursivo;

    private GestionPeliculas gestion = new GestionPeliculas();

    public Ventana() {
        // Parámetros de SpinnerNumberModel: (valorInicial, minimo, maximo, step)
        spiCodigo.setModel(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
        spiBuscarCodigo.setModel(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Pelicula nueva = new Pelicula(
                            Integer.parseInt(spiCodigo.getValue().toString()),
                            txtTitulo.getText(),
                            cboGenero.getSelectedItem().toString(),
                            Double.parseDouble(txtCalificacion.getText()));
                    if (gestion.agregarPelicula(nueva)) {
                        JOptionPane.showMessageDialog(null, "Película agregada correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "El código ya existe");
                    }
                    lstPeliculas.setListData(gestion.getPeliculas().toArray());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        btnBuscarTitulo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Pelicula encontrada = gestion.buscarPorTituloSecuencial(txtBuscarTitulo.getText());
                    if (encontrada != null) {
                        txtResultados.setText("Encontrada: " + encontrada);
                    } else {
                        txtResultados.setText("No existe una película con ese título");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        btnBuscarCodigo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int codigo = Integer.parseInt(spiBuscarCodigo.getValue().toString());
                    Pelicula encontrada = gestion.buscarPorCodigoBinario(codigo);
                    if (encontrada != null) {
                        txtResultados.setText("Encontrada: " + encontrada);
                    } else {
                        txtResultados.setText("No existe una película con ese código");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        btnOrdenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<Pelicula> ordenadas = gestion.ordenarPorCalificacionDescendente();
                    StringBuilder sb = new StringBuilder();
                    for (Pelicula p : ordenadas) {
                        sb.append(p).append("\n");
                    }
                    txtResultados.setText(sb.toString());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        btnMejor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Pelicula mejor = gestion.buscarMejorCalificadaRecursivo(0);
                    if (mejor != null) {
                        txtResultadoRecursivo.setText("Mejor calificada: " + mejor);
                    } else {
                        txtResultadoRecursivo.setText("No hay películas registradas");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        btnContar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String genero = cboGeneroRecursivo.getSelectedItem().toString();
                    int cantidad = gestion.contarPorGeneroRecursivo(genero, 0);
                    txtResultadoRecursivo.setText("Cantidad de películas de " + genero + ": " + cantidad);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        btnSumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String genero = cboGeneroRecursivo.getSelectedItem().toString();
                    double suma = gestion.sumaCalificacionesPorGeneroRecursiva(genero, 0);
                    txtResultadoRecursivo.setText("Suma de calificaciones de " + genero + ": " + suma);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema de Gestión de Películas");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}