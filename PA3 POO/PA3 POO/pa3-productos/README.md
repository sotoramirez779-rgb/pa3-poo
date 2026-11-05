# PA3 - Gestión de productos con colecciones en Java

**Curso:** Programación Orientada a Objetos (30626) - ISIL
**Docente:** WILDER JULIO ESPINOZA BRAVO
**Sección:** 3663

## Integrantes

1. Natalia Milene Rojas Escudero  72776147@mail.isil.pe
2. Sergio Enrique Vargas Fernández  72917707@mail.isil.pe
3. Alejandro Vicente Cori Contreras 47972731@mail.isil.pe
4. Luigui Alva Sánchez 48584750@mail.isil.pe
5. Ronald Yamil Soto Ramirez 74003435@mail.isil.pe
 

## Video de exposición

[Ver video en YouTube](PEGAR_AQUI_EL_ENLACE)

## Descripción del trabajo

Aplicación de consola en Java que gestiona en memoria un inventario de **productos** usando colecciones. Se eligió `Producto` porque tiene atributos variados (id, nombre, categoría, precio, stock) que permiten practicar búsqueda, eliminación y ordenamiento.

## Lógica de almacenamiento

- Los productos se guardan en un `ArrayList<Producto>` dentro de la clase `GestorProductos`.
- Al iniciar, el programa carga 6 productos de ejemplo.
- **Métodos de ArrayList usados:** `add()`, `get()`, `remove()`, `size()`, `isEmpty()`.
- **Operaciones de Collections usadas:** `sort()` (por precio con `Comparable` y por nombre con `Comparator`), `reverse()`, `max()` y `min()`.

### ¿Por qué usar colecciones?

Un arreglo tiene tamaño fijo. Con `ArrayList` el inventario crece o se reduce al agregar o eliminar productos, sin manejar índices ni copiar datos a mano. Además, `Collections` ofrece ordenamiento y búsqueda de extremos ya implementados, lo que reduce código y errores.

## Estructura del proyecto

```
pa3-productos/
 ├── src/
 │    └── pa3/
 │         ├── Main.java                 // Punto de entrada
 │         ├── Menu.java                 // Menú y lectura de datos por consola
 │         ├── GestorProductos.java      // ArrayList + operaciones con Collections
 │         ├── Producto.java             // Modelo (implementa Comparable)
 │         └── ComparadorPorNombre.java  // Comparator para ordenar por nombre
 ├── README.md
 └── .gitignore
```

La lógica de datos (`GestorProductos`) está separada de la interacción con el usuario (`Menu`).

## Cómo ejecutar

### En IntelliJ IDEA

1. Abrir IntelliJ y elegir **File > Open**, luego seleccionar la carpeta `pa3-productos`.
2. Si aparece el aviso *Project SDK is not defined*, pulsar **Setup SDK** y elegir un JDK 8 o superior.
3. Abrir `src/pa3/Main.java` y pulsar el triángulo verde junto a `main` (**Run 'Main.main()'**).

### Desde la terminal

Requiere JDK 8 o superior.

```bash
cd pa3-productos
javac -d out src/pa3/*.java
java -cp out pa3.Main
```

## Menú

| Opción | Acción |
|---|---|
| 1 | Listar productos |
| 2 | Agregar producto |
| 3 | Buscar por ID |
| 4 | Buscar por nombre |
| 5 | Eliminar por ID |
| 6 | Ordenar por precio |
| 7 | Ordenar por nombre |
| 8 | Invertir orden actual |
| 9 | Producto más caro y más barato |
| 0 | Salir |



