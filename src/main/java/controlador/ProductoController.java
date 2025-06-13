package controlador;

import dao.ProductoDao;
import modelo.Producto;
import vista.ProductoView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductoController {
    private final ProductoView productoView;
    private final ProductoDao productoDao;

    public ProductoController(ProductoDao productoDao, ProductoView productoView) {
        this.productoDao = productoDao;
        this.productoView = productoView;
        configurarEventos();
    }

    private void configurarEventos() {
        productoView.getBtnAceptar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarProducto();
            }
        });
    }

    private void guardarProducto() {
        int codigo = Integer.parseInt(productoView.getTxtCodigo().getText());
        String nombre = productoView.getTxtNombre().getText();
        double precio = Double.parseDouble(productoView.getTxtPrecio().getText());

        productoDao.crear(new Producto(codigo, nombre, precio));
        productoView.limpiarCampos();
        productoView.mostrarProductos(productoDao.listarTodos());
    }
}
