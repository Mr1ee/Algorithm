package fresh.lee.algorithm.java.jz_offer;

public class NumberOf1 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            if ((n & 1) == 1) res++;
            n = n >>> 1;
        }
        return res;
    }

    /**
     * n&(n−1) 解析： 二进制数字 nn 最右边的 11 变成 00 ，其余不变。
     *
     * @param n
     * @return
     */
    public int hammingWeightCore(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOf1().hammingWeight(19));
        System.out.println(new NumberOf1().hammingWeightCore(19));
    }
}
