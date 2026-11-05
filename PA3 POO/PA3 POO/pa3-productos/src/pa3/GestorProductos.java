package pa3;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Gestiona en memoria el inventario de productos.
 * <p>
 * Almacena los datos en un {@link ArrayList} y aplica operaciones
 * de la clase {@link Collections}. Esta clase no imprime nada:
 * solo maneja los datos. La interaccion con el usuario esta en {@link Menu}.
 */
public class GestorProductos {

    private final ArrayList<Producto> productos = new ArrayList<>();

    /** Carga productos de ejemplo al iniciar el programa. */
    public void cargarDatosIniciales() {
        productos.add(new Producto(1, "Laptop Lenovo", "Tecnologia", 2499.90, 8));
        productos.add(new Producto(2, "Mouse inalambrico", "Tecnologia", 45.50, 40));
        productos.add(new Producto(3, "Teclado mecanico", "Tecnologia", 189.00, 15));
        productos.add(new Producto(4, "Cuaderno A4", "Utiles", 8.50, 120));
        productos.add(new Producto(5, "Lapicero azul", "Utiles", 1.50, 300));
        productos.add(new Producto(6, "Mochila escolar", "Accesorios", 89.90, 25));
    }

    // ---------- Metodos de ArrayList: add, get, remove, size, isEmpty ----------

    public void agregar(Producto producto) {
        productos.add(producto);
    }

    public Producto buscarPorId(int id) {
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public boolean existeId(int id) {
        return buscarPorId(id) != null;
    }

    public ArrayList<Producto> buscarPorNombre(String texto) {
        ArrayList<Producto> resultado = new ArrayList<>();
        String buscado = texto.toLowerCase();
        for (Producto p : productos) {
            if (p.getNombre().toLowerCase().contains(buscado)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public boolean eliminarPorId(int id) {
        Producto p = buscarPorId(id);
        if (p == null) {
            return false;
        }
        productos.remove(p);
        return true;
    }

    public int cantidad() {
        return productos.size();
    }

    public boolean estaVacia() {
        return productos.isEmpty();
    }

    /** Devuelve una copia de la lista actual (respeta el orden vigente). */
    public ArrayList<Producto> obtenerTodos() {
        return new ArrayList<>(productos);
    }

    // ---------- Operaciones de la clase Collections ----------

    /** Ordena por precio de menor a mayor (usa Comparable). */
    public void ordenarPorPrecio() {
        Collections.sort(productos);
    }

    /** Ordena por nombre de A a Z (usa un Comparator). */
    public void ordenarPorNombre() {
        Collections.sort(productos, new ComparadorPorNombre());
    }

    /** Invierte el orden actual de la lista. */
    public void invertirOrden() {
        Collections.reverse(productos);
    }

    /** Producto de mayor precio, o null si no hay productos. */
    public Producto masCaro() {
        return productos.isEmpty() ? null : Collections.max(productos);
    }

    /** Producto de menor precio, o null si no hay productos. */
    public Producto masBarato() {
        return productos.isEmpty() ? null : Collections.min(productos);
    }
}
