// !DIAGNOSTICS: -UNUSED_EXPRESSION -UNUSED_PARAMETER -UNUSED_VARIABLE

// FILE: annotation.kt

package kotlin

annotation class ExperimentalBuilderInference

// FILE: test.kt

class GenericController<T> {
    suspend fun yield(t: T) {}
}

fun <S, P1, P2, R> generate(p1: P1, p2: List<P2>, @ExperimentalBuilderInference g: suspend GenericController<S>.(P1, P2) -> R): Four<S, P1, P2, R> = TODO()

val test1 = generate(1, listOf("")) { p1, p2 ->
    yield(p1)

    p2
}

fun <X> listOf(vararg x: X): List<X> = TODO()
class Four<X, Y, Z, T>
