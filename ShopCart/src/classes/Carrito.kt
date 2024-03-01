package classes
class Carrito {
    private val items: MutableList<Producto> = mutableListOf()
    fun agregarProducto(producto: Producto, cantidad:Int) {

        //Vemos si el producto ya fue agregado al carrito
        val revisarProducto = items.find{it.nombre.equals(producto.nombre, ignoreCase = true)}
        if(revisarProducto != null){
            //Si el item ya existe en la lista, solo actualizamos la cantidad
            revisarProducto.cantidad = revisarProducto.cantidad + cantidad
        }else{
            //Caso contrario, agregamos el producto a la lista
            producto.cantidad = cantidad
            items.add(producto)
        }
        println("\n${producto.nombre} ha sido añadido al carrito.")
        productos = productos + cantidad
        precioTotal = precioTotal + producto.precio * cantidad
    }

    fun mostrarCarrito() {
        if (items.isEmpty()) {
            println("\nEl carrito está vacío.")
        } else {
            println("\nProductos en el carrito:")
            val nombresVistos = HashSet<String>()
            for (producto in items) {
                if (nombresVistos.add(producto.nombre)) {
                    println("Nombre: ${producto.nombre} - Precio: $${producto.precio} - Cantidad: ${producto.cantidad} - Precio total: $${(producto.precio * producto.cantidad).toFloat()}")
                }
            }
            println("\nCantidad de productos totales: $productos")
            println("\nPrecio total: $${precioTotal.toFloat()}")
        }
    }

    companion object{
        var productos:Int = 0
        var precioTotal:Double = 0.0
    }
}
