package fresh.lee.algorithm.java.jz_offer;

public class JosephusRing {
    /**
     * @param n 总人数
     * @param m 第m个踢出去
     * @return 最后剩下的人的编号
     */
    public static int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            throw new IllegalArgumentException("n or m must bigger than 1.");
        }

        int last = 0;
        for (int i = 2; i <= n; ++i) {
            last = (last + m) % i;
        }

        return last;
    }

    /**
     * @param sum 总人数
     * @param m   第m个踢出去
     * @param i   第几轮
     * @return 第i轮踢出去的编号
     */
    public static int recursionMethod(int sum, int m, int i) {
        if (i == 1) {
            return (sum + m - 1) % sum;
        } else {
            return (recursionMethod(sum - 1, m, i - 1) + m) % sum;
        }
    }

    /**
     * @param sum 总人数
     * @param m   第m个踢出去
     * @param i   第几轮
     * @return 第i轮踢出去的编号
     */
    public static int loopMethod(int sum, int m, int i) {
        if (sum < 1 || m < 1) {
            throw new IllegalArgumentException("n or m must bigger than 1.");
        }

        if (sum < i) {
            throw new IllegalArgumentException("parameter sum must bigger than i.");
        }
        int lastRemain = sum - i;
        int lastIndex = sum - i;
        for (int j = 1; j <= i; j++) {
            lastIndex = (lastIndex + m) % (lastRemain + j);
        }

        return lastIndex;
    }

    public static void main(String[] args) {
        int sum = 15;
        int m = 4;
        System.out.println("the last index is : " + lastRemaining(sum, m));

        System.out.println("recursion method");
        for (int i = 1; i <= sum; i++) {
            System.out.println("第" + i + "次出环的编号是 ：" + recursionMethod(sum, m, i));
        }

        System.out.println("loop method");
        for (int i = 1; i <= sum; i++) {
            System.out.println("第" + i + "次出环的编号是 ：" + loopMethod(sum, m, i));
        }
    }
}
