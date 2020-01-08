package fresh.lee.algorithm.java.jksj_algo

/**
 * 二分查找
 * 首先，二分查找依赖的是顺序表结构，简单点说就是数组。
 * 其次，二分查找针对的是有序数据
 * 再次，数据量太小不适合二分查找
 * 最后，数据量太大也不适合二分查找
 *
 * 避免BUG！！！
 * 终止条件、区间上下界更新方法、返回值选择
 */
object BSearch {

    /**
     * @param target 目标
     * @param list 必须是升序有序数组
     * * @return 返回一个等于target 的index，没有找到target返回-1
     */
    fun <T : Comparable<T>> bsearch(list: List<T>, target: T): Int {
        val NOT_FOUND = -1
        var low = 0
        var high = list.size - 1
        while (low <= high) {
//            val mid = (low + high) shr 1
            // 防止low+high溢出!!!!
            val mid = low + ((high - low) shr 1)
            when {
                list[mid] == target -> return mid
                list[mid] > target -> high = mid - 1
                list[mid] < target -> low = mid + 1
            }
        }

        return NOT_FOUND
    }

    /**
     * @param target 目标
     * @param list 必须是升序有序数组
     * @return 返回第一个等于target 的index，没有找到target返回-1
     */
    fun <T : Comparable<T>> bsearch1(list: List<T>, target: T): Int {
        val NOT_FOUND = -1
        var low = 0
        var high = list.size - 1
        while (low <= high) {
//            val mid = (low + high) shr 1
            // 防止low+high溢出!!!!
            val mid = low + ((high - low) shr 1)
            when {
                list[mid] == target -> if (mid == 0 || list[mid - 1] < target) {
                    return mid
                } else {
                    high = mid - 1
                }
                list[mid] > target -> high = mid - 1
                list[mid] < target -> low = mid + 1
            }
        }

        return NOT_FOUND
    }

    /**
     * @param target 目标
     * @param list 必须是升序有序数组
     * @return 返回最后一个等于target 的index，没有找到target返回-1
     */
    fun <T : Comparable<T>> bsearch2(list: List<T>, target: T): Int {
        val NOT_FOUND = -1
        var low = 0
        var high = list.size - 1
        while (low <= high) {
//            val mid = (low + high) shr 1
            // 防止low+high溢出!!!!
            val mid = low + ((high - low) shr 1)
            when {
                list[mid] == target -> if (mid == list.size - 1 || list[mid + 1] > target) {
                    return mid
                } else {
                    low = mid + 1
                }
                list[mid] > target -> high = mid - 1
                list[mid] < target -> low = mid + 1
            }
        }

        return NOT_FOUND
    }

    /**
     * @param target 目标
     * @param list 必须是升序有序数组
     * @return 返回第一个大于等于target 的index，没有找到target返回-1
     */
    fun <T : Comparable<T>> bsearch3(list: List<T>, target: T): Int {
        val NOT_FOUND = -1
        var low = 0
        var high = list.size - 1
        while (low <= high) {
//            val mid = (low + high) shr 1
            // 防止low+high溢出!!!!
            val mid = low + ((high - low) shr 1)
            when {
                list[mid] >= target -> if (mid == 0 || list[mid - 1] < target) {
                    return mid
                } else {
                    high = mid - 1
                }
                list[mid] < target -> low = mid + 1
            }
        }

        return NOT_FOUND
    }
}

fun main() {
    val list = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 17, 34, 36, 47, 65, 69, 78)
    val list2 = arrayListOf(1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 9, 12, 17, 34, 36, 47, 65, 69, 78)
    println("17 in list index is ${BSearch.bsearch(list, 17)}")
    println("0 in list index is ${BSearch.bsearch(list, 0)}")
    println("4 in list index is ${BSearch.bsearch(list, 4)}")

    println("first 6 in list index is ${BSearch.bsearch1(list2, 6)}")
    println("last 6 in list index is ${BSearch.bsearch2(list2, 6)}")
    println("first number who bigger than 10 in list index is ${BSearch.bsearch3(list2, 10)}, and value is ${list2[BSearch.bsearch3(list2, 12)]}")


}