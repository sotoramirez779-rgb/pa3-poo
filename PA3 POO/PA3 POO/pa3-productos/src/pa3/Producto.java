package pa3;

/**
 * Representa un producto del inventario.
 * <p>
 * Implementa {@link Comparable} para que {@code Collections.sort()}
 * pueda ordenar los productos por precio (orden natural).
 */
public class Producto implements Comparable<Producto> {

    private final int id;
    private final String nombre;
    private final String categoria;
    private final double precio;
    private final int stock;

    public Producto(int id, String nombre, String categoria, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    /** Orden natural: por precio, de menor a mayor. */
    @Override
    public int compareTo(Producto otro) {
        return Double.compare(this.precio, otro.precio);
    }

    @Override
    public String toString() {
        return String.format("| %-4d | %-22s | %-14s | S/ %8.2f | %6d |",
                id, nombre, categoria, precio, stock);
    }
}
