package classes

class Producto(
    val nombre: String,
    val precio: Double,
    var cantidadDisponible: Int,
    var cantidad:Int
){
    companion object {
        val productos = mutableListOf<Producto>()
        fun agregarProductosIniciales(): List<Producto> {

            productos.add(Producto("Laptop", 999.99, 10,0))
            productos.add(Producto("Mouse", 19.99, 20,0))
            productos.add(Producto("Teclado", 49.99, 15,0))
            productos.add(Producto("Auriculares", 79.99, 30,0))
            productos.add(Producto("Monitor", 299.99, 8,0))
            return productos
        }

        fun buscarProductoPorNombre(nombre: String):Producto? {
            val productoEncontrado = productos.find { it.nombre.equals(nombre, ignoreCase = true) }
            if (productoEncontrado != null) {
                return productoEncontrado
            }else{return null}
        }
    }
}
