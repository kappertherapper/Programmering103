package opgaver

class TimeFib {
    val startTime: Long = System.nanoTime()
    val result: Long = fib(40)
    val endTime: Long = System.nanoTime()
    val duration: Double = (endTime - startTime) / 1_000_000.0
}

fun fib(n: Long): Long {
    return if (n <= 1) n
    else fib(n - 1) + fib(n - 2)
}

fun <T> valueAndTime(block: () -> T): Pair<T, Double> {
    val startTime = System.nanoTime()
    val result = block()
    val endTime = System.nanoTime()
    val duration = (endTime - startTime) / 1_000_000.0
    return Pair(result, duration)
}

fun main() {
    val (result: Long, duration: Double) = valueAndTime {
        fib(40)
    }
    println(String.format("Result = %,d",result))
    println(String.format("Duration = %.0f ms", duration))

}





