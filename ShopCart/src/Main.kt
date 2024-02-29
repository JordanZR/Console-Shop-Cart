import classes.Producto
fun main() {
    // Crear la lista mutable de productos
    val listaProductos = mutableListOf<Producto>()

    // Agregar 10 productos a la lista
    agregarProductos(listaProductos)

    // Mostrar la lista de productos de manera creativa
    mostrarListaProductos(listaProductos)
}

fun agregarProductos(listaProductos: MutableList<Producto>) {
    // Agregar 10 productos a la lista
    for (i in 1..5) {
        val producto = Producto("Producto $i", i * 10.0, i * 5)
        listaProductos.add(producto)
    }
}

fun mostrarListaProductos(listaProductos: List<Producto>) {
    // Mostrar un encabezado
    println("Lista de productos:")

    // Iterar sobre la lista de productos y mostrar cada uno de manera creativa
    for ( producto in listaProductos) {
        println("Nombre: ${producto.nombre}")
        println("Precio: $${producto.precio}")
        println("Cantidad Disponible: ${producto.cantidadDisponible}")
        println("-----------------------------------------")
    }
}
