package Opgaver

class Fibonacci {

    fun iterativFibonacci(n: Int): Int {
        if (n == 0) return n

        if (n == 1) return n

        var first = 0
        var second = 1
        var nth = 1

        for (i in 2..n) {
            nth = first + second
            first = second
            second = nth
        }
        return nth
    }

    fun recursivFibonacci(n: Int): Int {
        return if (n <= 1) n
        else recursivFibonacci(n - 1) + recursivFibonacci(n - 2)
    }

    fun tailFibonacci(n: Int, a: Int = 0, b: Int = 1): Int {
        return if (n == 0) a
        else if (n == 1) b
        else tailFibonacci(n - 1, b, a + b)
    }
}