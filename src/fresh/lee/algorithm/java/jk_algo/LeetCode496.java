package fresh.lee.algorithm.java.jk_algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * <p>
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 * 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 * 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-i
 */
public class LeetCode496 {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[findNums.length];
        for (int num : nums) {
            while (!stack.empty() && num > stack.peek())
                map.put(stack.pop(), num);
            stack.push(num);
        }
        while (!stack.empty())
            map.put(stack.pop(), -1);
        for (int i = 0; i < findNums.length; i++) {
            res[i] = map.get(findNums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new LeetCode496().nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4});

        System.out.println(Arrays.toString(arr));
    }
}
