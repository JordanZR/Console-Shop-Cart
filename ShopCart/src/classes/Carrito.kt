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

    fun comprarCarrito(){
        if (items.isEmpty()) {
            println("\nEl carrito está vacío.")
        } else {
            println("\nProductos comprados:")
            val nombresVistos = HashSet<String>()
            for (producto in items) {
                if (nombresVistos.add(producto.nombre)) {
                    println("Nombre: ${producto.nombre} - Precio unitario: $${producto.precio} - Cantidad: ${producto.cantidad} - Precio total: $${(producto.precio * producto.cantidad).toFloat()}")
                }
            }
            println("\nCantidad de productos totales: $productos")
            println("\nPrecio total: $${precioTotal.toFloat()}")
            println("\nIVA: ${(precioTotal.toFloat() * 0.13).toFloat()}")
            println("\nPrecio final: ${(precioTotal.toFloat() - precioTotal.toFloat() * 0.13).toFloat()}")

            //Eliminamos los productos del carrito
            items.clear()
        }
    }

    fun eliminarProducto(producto: Producto, cantidad: Int){

        if(cantidad >= producto.cantidad){
            if(items.removeIf{it.nombre.equals(producto.nombre, ignoreCase = true)}){
                println("\nProducto fue removido!")
            }
        }else{
            producto.cantidad = producto.cantidad - cantidad
            println("\nLa cantidad fue removida del producto seleccionado")
        }
        //Actualizamos la cantidad y precio total
        productos = productos - cantidad
        precioTotal = precioTotal - producto.precio * cantidad
        mostrarCarrito()
    }

    fun buscarProductoPorNombre(nombre: String):Producto? {
        val productoEncontrado = items.find { it.nombre.equals(nombre, ignoreCase = true) }
        if (productoEncontrado != null) {
            return productoEncontrado
        }else{return null}
    }

    companion object{
        var productos:Int = 0
        var precioTotal:Double = 0.0
    }
}
