package Opgaver

class Discount {

}

fun main() {
    fun discountedPrice(discount: Int, price: Double): Double {
        return price * (1 - discount / 100.0)
    }

    fun discount10(price: Double): Double {
        return discountedPrice(10, price)
    }

    println("Price after 10 % discount = ${discount10(1000.0)}") // 900
    println("Price after 10 % discount = ${discount10(500.0)}") // 450
}