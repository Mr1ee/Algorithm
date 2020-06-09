package fresh.lee.algorithm.java.jz_offer;

public class LCS {

    public static void main(String[] args) {
        String a = "helloworld";
        String b = "loop";
        System.out.println("字符串 :" + a + "和字符串：" + b + "的最长公共子序列长度是： " + findLCS(a, b, true));
    }

    /**
     * [s1]和[s2]最长公共子序列
     *
     * @param sequence 是否是连续子序列
     */
    public static int findLCS(String s1, String s2, boolean sequence) {
        int m = s1.length();
        int n = s2.length();
        int res = 0;
        if (m == 0 || n == 0) {
            return 0;
        }

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                } else {
                    if (sequence) {
//                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }

                System.out.println("dp[" + i + "][" + j + "] = " + dp[i][j]);
            }
        }

        return res;
    }
}
