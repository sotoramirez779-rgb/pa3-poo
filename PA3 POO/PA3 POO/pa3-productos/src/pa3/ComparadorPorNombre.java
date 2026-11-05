package pa3;

import java.util.Comparator;

/**
 * Comparador alterno: ordena los productos alfabeticamente por nombre,
 * sin distinguir mayusculas de minusculas.
 */
public class ComparadorPorNombre implements Comparator<Producto> {

    @Override
    public int compare(Producto a, Producto b) {
        return a.getNombre().compareToIgnoreCase(b.getNombre());
    }
}
