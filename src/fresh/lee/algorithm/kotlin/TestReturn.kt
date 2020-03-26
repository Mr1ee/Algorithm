package fresh.lee.algorithm.kotlin

class TestReturn {

    fun test() {
        println("before loop")

        (1..6).forEach {
            if (it == 3) {
                return@test
            }

            println("i == $it")
        }

        println("after loop")
    }

    fun test1() {
        println("before loop")

        (1..6).forEach {
            if (it == 3) {
                return@forEach
            }

            println("i == $it")
        }

        println("after loop")
    }

    fun test2() {
        println("before loop")

        (1..6).forEach {
            println("i == $it")
        }

        println("after loop")
    }
}

fun main() {
    TestReturn().test()
    //before loop
    //i == 1
    //i == 2


    TestReturn().test1()
    //before loop
    //i == 1
    //i == 2
    //i == 4
    //i == 5
    //i == 6
    //after loop
    // 没有i == 3 但是其他都照样有


    TestReturn().test2()
    //before loop
    //i == 1
    //i == 2
    //i == 3
    //i == 4
    //i == 5
    //i == 6
    //after loop


}