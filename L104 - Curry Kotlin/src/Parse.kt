import com.sun.net.httpserver.Authenticator.Failure
import com.sun.net.httpserver.Authenticator.Success
import java.util.Scanner

fun String.tryParse(): Result<Int> {
    if (isEmpty()) {
        return Result.failure(IllegalArgumentException("Empty string not parsed buh huh"))
    }
    return try {
        Result.success(toInt())
    } catch (e: NumberFormatException) {
        Result.failure(e)
    }
}

infix fun Result<Int>.plus(other: Int): Result<Int> {
    return this.fold(
        onSuccess = { value ->
            Result.success(value + other)
        },
        onFailure = {
            this
        })
}

fun main() {
    val streng1 = "123"
    val resultat1 = streng1.tryParse()
    val streng2 = "hej"
    val resultat2 = streng2.tryParse()

    println(resultat1)
    println(resultat2)
}