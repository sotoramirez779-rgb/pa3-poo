package pa3;

/**
 * PA3 - Programacion Orientada a Objetos (30626) - ISIL.
 * Punto de entrada: gestion de productos en memoria con colecciones.
 */
public class Main {

    public static void main(String[] args) {
        GestorProductos gestor = new GestorProductos();
        gestor.cargarDatosIniciales();

        Menu menu = new Menu(gestor);
        menu.iniciar();
    }
}
