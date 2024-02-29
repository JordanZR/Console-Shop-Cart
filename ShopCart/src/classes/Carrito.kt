package classes
class Carrito {
    private val items: MutableList<Producto> = mutableListOf()
    fun agregarProducto(producto: Producto) {
        producto.cantidad++
        items.add(producto)
        println("\n${producto.nombre} ha sido añadido al carrito.")
        productos++
    }

    fun mostrarCarrito() {
        if (items.isEmpty()) {
            println("\nEl carrito está vacío.")
        } else {
            println("\nProductos en el carrito:")
            val nombresVistos = HashSet<String>()
            for (producto in items) {
                if (nombresVistos.add(producto.nombre)) {
                    println("Nombre: ${producto.nombre} - Precio: $${producto.precio} - Cantidad: ${producto.cantidad}")
                }
            }
            println("\nCantidad de productos totales: $productos")
        }
    }

    companion object{
        var productos:Int = 0

    }
}
