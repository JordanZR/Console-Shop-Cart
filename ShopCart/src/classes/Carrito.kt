package classes
class Carrito {
    private val items: MutableList<Producto> = mutableListOf()

    fun agregarProducto(producto: Producto) {
        items.add(producto)
        println("${producto.nombre} ha sido añadido al carrito.")
    }

    fun mostrarCarrito() {
        if (items.isEmpty()) {
            println("El carrito está vacío.")
        } else {
            println("Productos en el carrito:")
            for ((index, producto) in items.withIndex()) {
                println("Indice: ${index + 1}. ${producto.nombre} - Precio: $${producto.precio}")
            }
        }
    }
}
