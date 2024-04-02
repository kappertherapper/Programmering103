package Opgaver

class Calculate {
}

fun main() {
    fun calc(op: (Int, Int) -> Int): (Int, Int) -> Int {

        return fun (x: Int, y: Int): Int {
            return op(x, y)
        }
    }

    fun calc2(op: (Int, Int) -> Int) = { x: Int, y: Int -> op( x, y) }

    val add = calc { x, y -> x + y }
    val subtract = calc { x, y -> x - y }
    val multiply = calc { x, y -> x * y }

    println("add(8, 6) = ${add(8, 6)}") // 14
    println("subtract(8, 6) = ${subtract(8, 6)}") // 2
    println("multiply(8, 6) = ${multiply(8, 6)}") // 48
}

//val add: (Int, Int) -> Int = {x, y -> x + y}
//val subtract: (Int, Int) -> Int = { x, y -> x - y}
//val multiply: (Int, Int) -> Int = {x, y -> x * y}