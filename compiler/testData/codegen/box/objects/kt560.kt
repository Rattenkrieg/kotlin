// IGNORE_BACKEND: JS_IR
// TODO: muted automatically, investigate should it be ran for JS or not
// IGNORE_BACKEND: JS, NATIVE

package while_bug_1

import java.io.*

open class AllEvenNum() {

    companion object {
        open public fun main(args : Array<String?>?) : Unit {
            var i : Int = 1
            while ((i <= 100)) {
                    {
                        if (((i % 2) == 0))
                        {
                            System.out?.print((i.toString() + ","))
                        }

                    }
                i = i + 1
            }
        }

    }
}

fun box() : String {
    AllEvenNum.main(arrayOfNulls<String>(0))
    return "OK"
}
