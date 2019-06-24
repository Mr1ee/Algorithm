package fresh.lee.algorithm.kotlin.sort

import fresh.lee.algorithm.kotlin.sort.interfaces.ISort
import java.util.*

/**
 * 冒泡排序
 */
class BubbleSort : ISort<Int> {
    override fun sort(data: ArrayList<Int>): MutableList<Int> {
        println("algorithm " + this::class.java.simpleName + " start!!!")

        for (i in 0 until data.size) {
            var exchange = false
            for (j in 0 until data.size - 1 - i) {
                if (data[j] > data[j + 1]) {
                    data.swapByBit(j, j + 1)
                    exchange = true
                }
            }
            println("the $i time(s) sort, result : $data")

            if (!exchange) {
                println("array already in sequence! break!")
                break
            }
        }

        return data
    }
}