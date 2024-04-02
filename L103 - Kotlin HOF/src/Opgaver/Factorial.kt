package Opgaver

class Factorial {

    fun iterativFactorial (n: Int): Int {
        var result = 1;
        for (i in 1..n) {
            result *= i
        }
        return result
    }

    fun recursivFactorial (n: Int): Int {
        return if (n == 0) 1
        else n * recursivFactorial(n - 1)
    }

    fun tailFactorial (n: Int, acc: Int = 1): Int {
        return if (n == 0) acc
        else n * tailFactorial(n - 1, acc)
    }
}