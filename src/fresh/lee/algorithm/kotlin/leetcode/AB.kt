package fresh.lee.algorithm.kotlin.leetcode

import java.util.*

object AB {
    /**
     * 找出整数数组中符合如下条件的所有元素：
     *  小于等于其前面的所有元素，大于等于后面所有元素
     *  示例：
     *  输入: [10 8 9 7 6 5 1 3 2]
     *  输出:[10 7 6 5]
     *
     * 思路：从左向右依次扫描，准备一个栈，数组第一个先进栈，
     * 然后依次拿栈顶数据和当前数据比较，如果当前数据大于栈顶数据，
     * 则出栈，取下一个栈顶数据比较，直到栈顶数据大于当前数据为止，
     * 如果遇到栈空，则证明不存在符合条件的数，直接返回；
     * 还要记录一个当前最小值，如果value大于当前最小值，value也不用进栈了。
     *
     */

    fun list(array: Array<Int>): Stack<Int>? {
        val stack = Stack<Int>()
        if (array.size == 1) {
            stack.push(array[0])
            return stack
        }
        var min = Int.MAX_VALUE

        stack.push(array[0])
        val arr = array.slice(IntRange(1, array.lastIndex))
        for (value in arr) {
            var lastMin = stack.pop()
            min = kotlin.math.min(value, min)
            while (lastMin < value) {
                if (stack.isEmpty()) return null
                lastMin = stack.pop()
            }

            stack.push(lastMin)
            if (value <= min) {
                stack.push(value)
            }
        }
        if (stack.isEmpty()) return null

        return stack
    }

}

fun main() {
    val array = arrayOf(10, 8, 9, 7, 1, 5, 2, 1, 5)
    val stack = AB.list(array)
    print(stack)
}