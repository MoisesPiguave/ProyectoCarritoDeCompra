package servicio;
import modelo.Producto;
import modelo.ItemCarrito;
import java.util.List;

public interface CarritoService {
    void agregarProducto(Producto producto, int cantidad);

    void eliminarProducto(int codigoProducto);

    void vaciarCarrito();

    double calcularTotal();

    List<ItemCarrito> obtenerItems();

    boolean estaVacio();

}
