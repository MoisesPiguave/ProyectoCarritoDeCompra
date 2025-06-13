package vista;

import modelo.Producto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class CarritoView extends JFrame {
    private JPanel panel1;
    private JButton btnAgregar;
    private JLabel lblCarrito;
    private JButton btnEliminar;
    private JButton btnSalir;
    private JButton btnDescuento;
    private JTextArea txtProductos;

    private final List<Producto> carrito = new ArrayList<>();
    private final List<Producto> productosDisponibles;

    public CarritoView(List<Producto> productosDisponibles) {
        this.productosDisponibles = productosDisponibles;

        setTitle("Carrito de Compras");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!productosDisponibles.isEmpty()) {
                    Producto p = productosDisponibles.get(productosDisponibles.size() - 1);
                    carrito.add(new Producto(p.getCodigo(), p.getNombre(), p.getPrecio()));
                    actualizarTexto();
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!carrito.isEmpty()) {
                    carrito.remove(carrito.size() - 1);
                    actualizarTexto();
                }
            }
        });

        btnDescuento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Producto p : carrito) {
                    p.setPrecio(p.getPrecio() - 10);
                }
                actualizarTexto();
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void actualizarTexto() {
        txtProductos.setText("");
        for (Producto p : carrito) {
            txtProductos.append(p.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, "Camisa", 30.0));
        productos.add(new Producto(2, "Pantalón", 50.0));
        productos.add(new Producto(3, "Zapatos", 70.0));

        CarritoView carritoView = new CarritoView(productos);
        carritoView.setContentPane(carritoView.panel1);
        carritoView.setVisible(true);
    }
}
