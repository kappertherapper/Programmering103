package Opgaver

class Then {
}

fun main() {
    fun then1(f: (Int) -> Double, g: (Double) -> Double): (Int) -> Double {
        return {x: Int -> g(f(x)) }
    }

    fun ((Int) -> Int).then2(transform: (Int) -> Int): (Int) -> Int {
        return { x -> transform(this(x)) }
    }

    infix fun <A, B> (() -> A).then3(transform: (A) -> B): (A) -> B {
        return { transform(this()) }
    }

    val f1: (Int) -> Double = { 2.0 * it }
    val f2: (Double) -> Double = { it * it }

    println((1..10).map(then1(f1, f2)))
    //println((1..10).map(f1.then2(f2))) //TODO
    //println((1..10).map(f1 then3 f2))
// [4.0, 16.0, 36.0, 64.0, 100.0, 144.0, 196.0, 256.0, 324.0, 400.0]
}


//    fun Int.then2(): (Int) -> Double {
//        return {x -> this + x.toDouble() }
//    }