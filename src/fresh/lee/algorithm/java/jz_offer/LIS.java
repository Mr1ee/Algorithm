package fresh.lee.algorithm.java.jz_offer;

import java.util.Arrays;

public class LIS {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 9, 6, 10, 7, 1, 3};
        System.out.println("LIS = " + lis(arr));
    }

    /**
     * 最大升序序列个数
     */
    public static int lis(int[] array) {
        int length = array.length;
        int[] dp = new int[array.length];
        int ans = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) { // 如果求最大下降子序列则反之
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
