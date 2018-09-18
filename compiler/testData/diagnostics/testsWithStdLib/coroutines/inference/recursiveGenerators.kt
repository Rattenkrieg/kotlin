// !DIAGNOSTICS: -UNUSED_EXPRESSION -UNUSED_PARAMETER -UNUSED_VARIABLE

// FILE: annotation.kt

package kotlin

annotation class ExperimentalBuilderInference

// FILE: test.kt

class GenericController<T> {
    suspend fun yield(t: T) {}
}

fun <S> generate(@ExperimentalBuilderInference g: suspend GenericController<S>.() -> Unit): List<S> = TODO()

val test1 = generate {
    yield(generate {
        yield(generate {
            yield(generate {
                yield(3)
            })
        })
    })
}
