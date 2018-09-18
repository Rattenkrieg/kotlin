// !DIAGNOSTICS: -UNUSED_EXPRESSION -UNUSED_PARAMETER -UNUSED_VARIABLE

// FILE: annotation.kt

package kotlin

annotation class ExperimentalBuilderInference

// FILE: test.kt


class GenericController<T>

fun <S> generate(@ExperimentalBuilderInference g: suspend GenericController<S>.() -> Unit): List<S> = TODO()

suspend fun GenericController<List<String>>.test() {}

val test1 = generate {
    test()
}