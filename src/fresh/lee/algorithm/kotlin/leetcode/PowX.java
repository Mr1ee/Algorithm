package fresh.lee.algorithm.kotlin.leetcode;

public class PowX {

    public static double myPow(double x, int n) {
        if (n == 0) return 1;
        //太坑了！！！
        //最小值：Integer.MIN_VALUE= -2147483648 （-2的31次方）
        //最大值：Integer.MAX_VALUE= 2147483647  （2的31次方-1）
        //这里需要使用long类型，因为如果传入的n = -2147483648； 那么转成正数就丢失，所以要使用long
        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = -N;
        }
        return powCore(x, N);
    }

    public static double fastPow(double x, long N) {
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
    }

    public static double powCore(double x, long n) {
        if (n == 1) return x;
        double half = powCore(x, n / 2);
        if (n % 2 == 1) {
            return x * half * half;
        } else {
            return half * half;
        }
    }

    public static void main(String[] args) {
        System.out.println(PowX.myPow(2.10000, 3));
    }
}
