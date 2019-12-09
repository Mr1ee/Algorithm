package fresh.lee.algorithm.kotlin.leetcode

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Problem3 {

    fun lengthOfLongestSubstring(s: String): Int {
        var result = 0
        var str = ""
        s.forEach { c ->
            if (str.contains(c)) {
                str = str.substring(str.indexOf(c) + 1) + c
            } else {
                str += c
            }
            result = if (str.length > result) {
                str.length
            } else {
                result
            }
        }

        return result
    }
}

/** 我是main入口函数 **/
fun main(args: Array<String>) {
    println(Problem3().lengthOfLongestSubstring("abcabcbb"))
    println(Problem3().lengthOfLongestSubstring(""))
    println(Problem3().lengthOfLongestSubstring(" "))
    println(Problem3().lengthOfLongestSubstring("a"))
    println(Problem3().lengthOfLongestSubstring("ab"))
    println(Problem3().lengthOfLongestSubstring("pwwkew"))
}