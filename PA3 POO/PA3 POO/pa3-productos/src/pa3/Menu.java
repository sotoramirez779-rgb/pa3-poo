package pa3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Interfaz de consola: muestra el menu, lee los datos del usuario
 * y delega el trabajo en {@link GestorProductos}.
 */
public class Menu {

    private static final String LINEA =
            "+------+------------------------+----------------+-------------+--------+";
    private static final String ENCABEZADO =
            "| ID   | Nombre                 | Categoria      | Precio      | Stock  |";

    private final GestorProductos gestor;
    private final Scanner sc = new Scanner(System.in);

    public Menu(GestorProductos gestor) {
        this.gestor = gestor;
    }

    /** Ciclo principal del programa. */
    public void iniciar() {
        int opcion;
        do {
            mostrarOpciones();
            opcion = leerEntero("Elige una opcion: ");
            System.out.println();
            ejecutar(opcion);
            System.out.println();
        } while (opcion != 0);
    }

    private void mostrarOpciones() {
        System.out.println("========== GESTION DE PRODUCTOS ==========");
        System.out.println(" 1. Listar productos");
        System.out.println(" 2. Agregar producto");
        System.out.println(" 3. Buscar por ID");
        System.out.println(" 4. Buscar por nombre");
        System.out.println(" 5. Eliminar por ID");
        System.out.println(" 6. Ordenar por precio");
        System.out.println(" 7. Ordenar por nombre");
        System.out.println(" 8. Invertir orden actual");
        System.out.println(" 9. Producto mas caro y mas barato");
        System.out.println(" 0. Salir");
        System.out.println("==========================================");
    }

    private void ejecutar(int opcion) {
        switch (opcion) {
            case 1:
                listarProductos();
                break;
            case 2:
                agregarProducto();
                break;
            case 3:
                buscarPorId();
                break;
            case 4:
                buscarPorNombre();
                break;
            case 5:
                eliminarProducto();
                break;
            case 6:
                gestor.ordenarPorPrecio();
                System.out.println("Productos ordenados por precio (menor a mayor).");
                listarProductos();
                break;
            case 7:
                gestor.ordenarPorNombre();
                System.out.println("Productos ordenados por nombre (A-Z).");
                listarProductos();
                break;
            case 8:
                gestor.invertirOrden();
                System.out.println("Orden invertido.");
                listarProductos();
                break;
            case 9:
                mostrarExtremos();
                break;
            case 0:
                System.out.println("Programa finalizado. Hasta luego.");
                break;
            default:
                System.out.println("Opcion no valida. Intenta de nuevo.");
        }
    }

    // ---------- Acciones del menu ----------

    private void listarProductos() {
        imprimirTabla(gestor.obtenerTodos());
    }

    private void agregarProducto() {
        int id = leerEntero("ID: ");
        if (gestor.existeId(id)) {
            System.out.println("Ya existe un producto con ese ID.");
            return;
        }
        String nombre = leerTexto("Nombre: ");
        String categoria = leerTexto("Categoria: ");
        double precio = leerDecimal("Precio: ");
        int stock = leerEntero("Stock: ");

        if (nombre.isEmpty() || categoria.isEmpty() || precio < 0 || stock < 0) {
            System.out.println("Datos invalidos. No se agrego el producto.");
            return;
        }
        gestor.agregar(new Producto(id, nombre, categoria, precio, stock));
        System.out.println("Producto agregado correctamente.");
    }

    private void buscarPorId() {
        int id = leerEntero("ID a buscar: ");
        Producto p = gestor.buscarPorId(id);
        if (p == null) {
            System.out.println("No se encontro un producto con ese ID.");
            return;
        }
        ArrayList<Producto> unico = new ArrayList<>();
        unico.add(p);
        imprimirTabla(unico);
    }

    private void buscarPorNombre() {
        String texto = leerTexto("Texto a buscar: ");
        ArrayList<Producto> resultado = gestor.buscarPorNombre(texto);
        if (resultado.isEmpty()) {
            System.out.println("Sin coincidencias.");
        } else {
            imprimirTabla(resultado);
        }
    }

    private void eliminarProducto() {
        int id = leerEntero("ID a eliminar: ");
        if (gestor.eliminarPorId(id)) {
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("No se encontro un producto con ese ID.");
        }
    }

    private void mostrarExtremos() {
        if (gestor.estaVacia()) {
            System.out.println("No hay productos registrados.");
            return;
        }
        System.out.println("Producto mas caro:");
        ArrayList<Producto> caro = new ArrayList<>();
        caro.add(gestor.masCaro());
        imprimirTabla(caro);

        System.out.println("Producto mas barato:");
        ArrayList<Producto> barato = new ArrayList<>();
        barato.add(gestor.masBarato());
        imprimirTabla(barato);
    }

    // ---------- Utilidades de salida y entrada ----------

    private void imprimirTabla(ArrayList<Producto> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }
        System.out.println(LINEA);
        System.out.println(ENCABEZADO);
        System.out.println(LINEA);
        for (Producto p : lista) {
            System.out.println(p);
        }
        System.out.println(LINEA);
        System.out.println("Total: " + lista.size() + " producto(s)");
    }

    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine().trim();
    }

    private int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un numero entero valido.");
            }
        }
    }

    private double leerDecimal(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un numero valido (ejemplo: 25.50).");
            }
        }
    }
}
