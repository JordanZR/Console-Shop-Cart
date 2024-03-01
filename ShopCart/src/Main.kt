import classes.Producto
import classes.Carrito
fun main() {
    val carrito = Carrito()
    val productosIniciales = Producto.agregarProductosIniciales()

    while (true) {
        // Imprimir los productos iniciales
        println("\nLista de productos iniciales:")
        for (producto in productosIniciales) {
            println("${producto.nombre} - Precio: $${producto.precio} - Disponibles: ${producto.cantidadDisponible}")
        }

        println("\nMenú:")
        println("1. Ver el carrito")
        println("2. Agregar producto al carrito")
        println("3. Remover producto del carrito")
        println("4. Salir")

        print("Seleccione una opción: ")
        val opcion = readLine()?.toIntOrNull()

        when (opcion) {
            1 -> carrito.mostrarCarrito()
            2 -> {
                println("\nIngrese el nombre del producto a agregar: ")
                val nombreProducto = readLine().toString()
                val producto = Producto.buscarProductoPorNombre(nombreProducto)
                //Revisamos si el producto existe
                if(producto != null){
                    var validador = true
                    while(validador){
                        println("\nIngrese la cantidad que desea del producto")
                        val cantidad = readLine()?.toIntOrNull()
                        if(cantidad is Int){
                            carrito.agregarProducto(producto, cantidad)
                            carrito.mostrarCarrito()
                            validador = false
                        }else{
                            println("\nCantidad invalida")
                        }
                    }
                }else{
                    println("\nPor favor ingrese el nombre del producto correctamente")
                }
            }
            3 ->{

            }
            4 -> {
                println("\nSaliendo del programa. ¡Hasta luego!")
                break
            }
            else -> println("\nOpción no válida. Inténtelo de nuevo.")
        }
    }
}


