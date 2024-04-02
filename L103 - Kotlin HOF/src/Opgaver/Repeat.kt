package Opgaver

class Repeat {

    fun repeatAction(times: Int, initial: Int, increment: Int, action: (Int) -> Unit) {
        var currentValue = initial
        for (i in 0 until times) {
            action(currentValue)
            currentValue += increment
        }
    }

    private fun action(initial: Int) {
    }
}