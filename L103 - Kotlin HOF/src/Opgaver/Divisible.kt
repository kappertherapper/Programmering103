package Opgaver

class Divisible {

    fun Int.isDivisible(divisor: Int ): Boolean = this % divisor == 0

    val isDivisibleLambda: Int.(divisor : Int) -> Boolean = {divisor -> this % divisor == 0}


    fun average(list: List<Int>): Int {
        if (list.isEmpty()) return 0

        var sum = 0
        for (num in list.indices)
            sum += list[num]
                sum.also (::println ) // printer sum for hver tilføjelse
                sum.also{(println(it))}                        // :: = metodereference
                                        // it = whenever you have a function literal with exactly one parameter
                                        //      you don’t have to define the parameter explicitly but you can just use it.
                                        // so in this matter it = sum

        return sum / list.size
    }

    val averge: (List<Int>, sum: Int) -> Int = { list, sum ->
        if (list.isEmpty()) 0
        else sum / list.size
    }

    val avg = { list: List<Int> -> list.sum() / list.size}
}