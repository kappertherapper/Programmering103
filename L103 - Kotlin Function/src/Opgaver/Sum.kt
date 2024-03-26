package Opgaver

class Sum {

    fun Sum(a: Int, b: Int): Int {
        return a + b;
    }

    fun iterativSum(n: Int): Int {
        var sum = 0;
        for (i in n downTo 1)
            sum += i;
        return sum;
    }

    fun recursivSum(n: Int): Int {
        return if (n == 1) 1;
        else recursivSum(n - 1) + n
    }

    fun tailSum(n: Int, acc: Int = 1): Int {
        return if (n == 0) acc
        else tailSum(n - 1, acc + n)
    }
}