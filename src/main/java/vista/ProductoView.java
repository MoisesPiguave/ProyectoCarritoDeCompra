    package vista;

    import modelo.Producto;

    import javax.swing.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.util.ArrayList;
    import java.util.List;

    public class ProductoView extends JFrame {

        private JPanel panel1;
        private JTextField txtCodigo;
        private JTextField txtNombre;
        private JTextField txtPrecio;
        private JButton btnAceptar;
        private JButton btnLimpiar;
        private JButton btnSalir;
        private JButton btnGuardar;
        private JLabel lblCodigo;
        private JLabel lblNombre;
        private JLabel lblPrecio;

        private final List<Producto> productosGuardados = new ArrayList<>();

        public ProductoView() {
            setContentPane(panel1);
            setTitle("Datos del Producto");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(500, 500);
            setLocationRelativeTo(null);
            setVisible(true);

            btnGuardar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int codigo = Integer.parseInt(txtCodigo.getText());
                    String nombre = txtNombre.getText().trim();
                    double precio = Double.parseDouble(txtPrecio.getText());
                    Producto producto = new Producto(codigo, nombre, precio);
                    productosGuardados.add(producto);
                    mostrarProductos(productosGuardados);
                    limpiarCampos();
                }
            });

            btnLimpiar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    limpiarCampos();
                }
            });

            btnSalir.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
        }

        public JTextField getTxtCodigo() {
            return txtCodigo;
        }

        public JTextField getTxtNombre() {
            return txtNombre;
        }

        public JTextField getTxtPrecio() {
            return txtPrecio;
        }

        public JButton getBtnAceptar() {
            return btnAceptar;
        }

        public JButton getBtnLimpiar() {
            return btnLimpiar;
        }


        public void limpiarCampos() {
            txtCodigo.setText("");
            txtNombre.setText("");
            txtPrecio.setText("");
        }

        public void mostrarProductos(List<Producto> productos) {
            System.out.println(" Productos guardados ");
            for (Producto p : productos) {
                System.out.println(p);
            }
        }

        public static void main(String[] args) {
            new ProductoView();
        }
    }
