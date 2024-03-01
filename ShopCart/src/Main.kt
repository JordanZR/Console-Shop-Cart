import classes.Producto
import classes.Carrito
fun main() {
    //Creamos un objeto de la clase Carrito
    val carrito = Carrito()
    //Ocupamos la función de productos iniciales para obtenerlos y mostrarlos
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
        println("4. Comprar productos en el carrito")
        println("5. Salir")

        print("Seleccione una opción: ")
        val opcion = readLine()?.toIntOrNull()

        when (opcion) {
            1 -> carrito.mostrarCarrito()
            2 -> {
                println("\nIngrese el nombre del producto a agregar: ")
                val nombreProducto = readLine().toString()
                //Revisamos si el producto existe
                val producto = Producto.buscarProductoPorNombre(nombreProducto)

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
                println("\nIngrese el nombre del producto a eliminar: ")
                val nombreProducto = readLine().toString()
                //Revisamos si el producto existe en el carrito
                val producto = carrito.buscarProductoPorNombre(nombreProducto)

                if(producto != null){
                    var validador = true
                    while(validador){

                        println("\nIngrese la cantidad que desea quitar del producto")
                        val cantidad = readLine()?.toIntOrNull()

                        if(cantidad is Int){
                            carrito.eliminarProducto(producto, cantidad)
                            validador = false
                        }else{
                            println("\nCantidad invalida")
                        }
                    }
                }else{
                    println("\nEl nombre del producto no existe, por favor ingreselo correctamente")
                }
            }
            4 -> {
                println("\nDesea confirmar la compra?. Escriba si o no")
                val respuesta = readLine()

                if (respuesta.equals("Si", ignoreCase = true)) {
                    //Se ejecuta el codigo para la compra
                    carrito.comprarCarrito()
                } else{
                    println("\nCompra cancelada. Puede seguir agregando o eliminando productos")
                }
            }
            5 -> {
                println("\nSaliendo del programa. ¡Hasta luego!")
                break
            }
            else -> println("\nOpción no válida. Inténtelo de nuevo.")
        }
    }
}


