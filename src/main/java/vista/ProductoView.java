package vista;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductoView extends JFrame {

    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton guardarButton;
    private JButton salirButton;
    private JLabel lblnombre;
    private JLabel lblprecio;
    private JLabel lblcodigo;

    public ProductoView() {
        setContentPane(panel1);
        setTitle("Datos deProducto");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDatos();
            }
        });
    }
    private void mostrarDatos() {
        String nombre = textField1.getText();
        String precio = textField3.getText();
        String codigo = textField2.getText();
        System.out.println("Nombre: " + precio);
        System.out.println("Precio: " + nombre);
        System.out.println("Codigo: " + codigo);


    }
    public static void main(String[] args) {
        new ProductoView();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
