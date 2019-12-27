package fresh.lee.algorithm.kotlin


// kotlin to java
// Tools->Kotlin->Show Kotlin Bytecode :: Decompile
class InlineTest {

    fun print1(s1: String, s2: String) {
        println("this is method print1")
        common(s1, s2) { s11, s22 ->
            print(s11)
            println(",$s22")
        }
    }

    fun print2(s1: String, s2: String) {
        println("this is method print2")
        common(s1, s2, this@InlineTest::commonPrint)
//        commonPrintNoInline(s1, s2)
    }

    fun print3(s1: String, s2: String) {
        println("this is method print3")
        commonPrint(s1, s2)
    }


    inline fun <reified T> membersOf() = T::class.simpleName

    inline fun <T> common(s1: String, s2: String, block: (s1: String, s2: String) -> T): T {
        return block.invoke(s1, s2)
    }

    inline fun commonPrint(s1: String, s2: String) {
        print(s1)
        println(",$s2")
    }

    fun commonPrintNoInline(s1: String, s2: String) {
        print(s1)
        println(",$s2")
    }
}

fun main(args: Array<String>) {
    val test = InlineTest()
    println(test.membersOf<StringBuilder>())
    test.print1("hello", "world")
    test.print2("hello", "world")
    test.print3("hello", "world")
}
