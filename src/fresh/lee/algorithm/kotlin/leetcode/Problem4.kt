package fresh.lee.algorithm.kotlin.leetcode

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Problem4 {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        var mid = 0.0
//        if (nums1.isEmpty()) {
//            val size = nums2.size
//            mid = if (size % 2 == 1) {
//                nums2[size / 2].toDouble()
//            } else {
//                (nums2[size / 2 - 1] + nums2[size / 2]).toDouble() / 2
//            }
//        }
//
//        if (nums2.isEmpty()) {
//            val size = nums1.size
//            mid = if (size % 2 == 1) {
//                nums1[size / 2].toDouble()
//            } else {
//                (nums1[size / 2 - 1] + nums1[size / 2]).toDouble() / 2
//            }
//        }

        val array = merge2Array(nums1, nums2)
        val size = array.size
        mid = if (size % 2 == 1) {
            array[size / 2].toDouble()
        } else {
            (array[size / 2 - 1] + array[size / 2]).toDouble() / 2
        }

        return mid
    }

    private fun merge2Array(nums1: IntArray, nums2: IntArray): IntArray {
        val array = IntArray(nums1.size + nums2.size)
        var index1 = 0
        var index2 = 0

        while (index1 < nums1.size || index2 < nums2.size) {
            when {
                index1 == nums1.size -> {
                    array[index1 + index2] = nums2[index2]
                    index2++
                }
                index2 == nums2.size -> {
                    array[index1 + index2] = nums1[index1]
                    index1++
                }
                nums1[index1] <= nums2[index2] -> {
                    array[index1 + index2] = nums1[index1]
                    index1++
                }
                else -> {
                    array[index1 + index2] = nums2[index2]
                    index2++
                }
            }
        }
        return array
    }
}

/** 我是main入口函数 **/
fun main(args: Array<String>) {
    println(Problem4().findMedianSortedArrays(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)))
    println(Problem4().findMedianSortedArrays(intArrayOf(), intArrayOf(4, 5, 6)))
    println(Problem4Java().findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(4, 5, 6)))
    println(Problem4Java().findMedianSortedArrays(intArrayOf(), intArrayOf(4, 5, 6)))

    println(Problem4Java2().findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(4, 5, 6)))
    println(Problem4Java2().findMedianSortedArrays(intArrayOf(), intArrayOf(4, 5, 6)))
}