package fresh.lee.algorithm.java.jz_offer;

/**
 * see https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/solution/zhu-xing-xiang-xi-jiang-jie-you-qian-ru-shen-by-je/
 *
 * 解题思路
 * 假设主串为 AA，模式串为 BB 从最后一步出发，需要关注最后进来的字符。假设 AA 的长度为 nn ，BB 的长度为 mm ，关注正则表达式 BB 的最后一个字符是谁，它有三种可能，正常字符、*∗ 和 .（点），那针对这三种情况讨论即可，如下：
 *
 * 如果 BB 的最后一个字符是正常字符，那就是看 A[n-1]A[n−1] 是否等于 B[m-1]B[m−1]，相等则看 A_{0..n-2}A_0..n−2
 * ​
 *   与 B_{0..m-2}B_0..m−2
 * ​
 *  ，不等则是不能匹配，这就是子问题。
 *
 * 如果 BB 的最后一个字符是.，它能匹配任意字符，直接看 A_{0..n-2}A_0..n−2
 * ​
 *   与 B_{0..m-2}B_0..m−2
 * ​
 *
 *
 * 如果 BB 的最后一个字符是*它代表 B[m-2]=cB[m−2]=c 可以重复0次或多次，它们是一个整体 c*c∗
 *
 * 情况一：A[n-1]A[n−1] 是 00 个 cc，BB 最后两个字符废了，能否匹配取决于 A_{0..n-1}A_0..n−1
 * ​
 *   和 B_{0..m-3}B_0..m−3
 * ​
 *   是否匹配
 * 情况二：A[n-1]A[n−1] 是多个 cc 中的最后一个（这种情况必须 A[n-1]=cA[n−1]=c 或者 c='.'c=
 * ′
 *  .
 * ′
 *  ），所以 AA 匹配完往前挪一个，BB 继续匹配，因为可以匹配多个，继续看 A_{0..n-2}A
 * 0..n−2
 * ​
 *   和 B_{0..m-1}B
 * 0..m−1
 * ​
 *  是否匹配。
 * 转移方程
 * f[i] [j]f[i][j] 代表 AA 的前 ii 个和 BB 的前 jj 个能否匹配
 *
 * 对于前面两个情况，可以合并成一种情况 f[i][j] = f[i-1][j-1]f[i][j]=f[i−1][j−1]
 *
 * 对于第三种情况，对于 c*c∗ 分为看和不看两种情况
 *
 * 不看：直接砍掉正则串的后面两个， f[i][j] = f[i][j-2]f[i][j]=f[i][j−2]
 * 看：正则串不动，主串前移一个，f[i][j] = f[i-1][j]f[i][j]=f[i−1][j]
 * 初始条件
 * 特判：需要考虑空串空正则
 *
 * 空串和空正则是匹配的，f[0][0] = truef[0][0]=true
 * 空串和非空正则，不能直接定义 truetrue 和 falsefalse，必须要计算出来。（比如A=A= '' '' ,B=a*b*c*B=a∗b∗c∗）
 * 非空串和空正则必不匹配，f[1][0]=...=f[n][0]=falsef[1][0]=...=f[n][0]=false
 * 非空串和非空正则，那肯定是需要计算的了。
 *
 * 作者：jerry_nju
 * 链接：https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/solution/zhu-xing-xiang-xi-jiang-jie-you-qian-ru-shen-by-je/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class RegexMatcher {

    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] f = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //分成空正则和非空正则两种
                if (j == 0) {
                    f[i][j] = i == 0;
                } else {
                    //非空正则分为两种情况 * 和 非*
                    if (p.charAt(j - 1) != '*') {
                        if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        //碰到 * 了，分为看和不看两种情况
                        //不看
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        //看
                        if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("mississippi", "mis*is*p*."));
        System.out.println(isMatch("aab", "c*a*b."));
    }
}
