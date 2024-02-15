package Ratio

class Rational(nom: Int, denom: Int = 1): Comparable<Rational> {
    var n: Int = nom
    var d: Int = denom

    init {
        if (denom == 0) throw RuntimeException("Demoniator is 0")
    }
    override fun compareTo(other: Rational): Int {
        TODO("Not yet implemented")
    }
}