package fresh.lee.algorithm.java;

import java.util.Arrays;

/**
 * @Description: KmpTest
 * @Author: lihuayong
 * @CreateDate: 2019/4/3 下午4:52
 * @UpdateUser:
 * @UpdateDate: 2019/4/3 下午4:52
 * @UpdateRemark:
 * @Version: 1.0
 */
public class KmpTest {

    public static void main(String[] args) {

        String t = "abaabaabbabaaabaabbabaab";
        String p = "abaabbabaab";
        Integer a = 13;
        Integer a2 = 13;

        Integer a3 = 133;
        Integer a4 = 133;

        Integer a5 = 2147483647;
        Integer a6 = 2147483647;
        System.out.println(a == a2);
        System.out.println(a3 == a4);
        System.out.println(a5 == a6);
        // true false false
        // IntegerCache [-128,127]

        System.out.println(KMP(t, p));
    }

    public static int KMP(String ts, String ps) {
        char[] t = ts.toCharArray();
        char[] p = ps.toCharArray();

        // 主串的位置
        int i = 0;
        // 模式串的位置
        int j = 0;
        int[] next = getNext(ps);
        System.out.println(Arrays.toString(next));

        while (i < t.length && j < p.length) {
            if (j == -1 || t[i] == p[j]) {
                // 当j为-1时，要移动的是i，当然j也要归0
                i++;
                j++;
            } else {
                // j回溯
                j = next[j];
            }
        }

        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }

    }

    public static int[] getNext(String ps) {
        char[] pattern = ps.toCharArray();
        int[] next = new int[pattern.length];

        // 初始条件
        int i = 0;
        int j = -1;
        next[0] = -1;

        // 根据已知的前j位推测第j+1位
        while (i < pattern.length - 1) {
            if (j == -1 || pattern[i] == pattern[j]) {
                i++;
                j++;
                /*
                    若在++后当前i值不与前缀j处相等，则next[i] = j

                    若相等，则证明当前串与前缀串相同，因此可以直接使用前缀串的next值
                */
                if (pattern[i] != pattern[j]) {
                    next[i] = j;
                    print(next);
                } else {
                    next[i] = next[j];
                    print(next);
                }
            } else {
                j = next[j];
                System.out.println("j = " + j);
            }
        }

        return next;
    }

    static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
