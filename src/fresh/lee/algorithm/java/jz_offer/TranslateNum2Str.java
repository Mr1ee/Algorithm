package fresh.lee.algorithm.java.jz_offer;

/**
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 * 面试题46. 把数字翻译成字符串
 * <p>
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TranslateNum2Str {

    int result = 0;

    public int translateNum(int num) {
        return translateCore(num + "");
    }

    // 递归
    private int translateCore(String num) {
        if (num.length() == 0 || num.length() == 1) return 1;
        String f1 = num.substring(0, 1);
        if (Integer.parseInt(f1) == 0) {
            return translateCore(num.substring(1));
        }
        String f2 = num.substring(0, 2);
        int v = Integer.parseInt(f2);
        if (v > 25) {
            return translateCore(num.substring(1));
        } else {
            return translateCore(num.substring(1)) + translateCore(num.substring(2));
        }
    }

    // 动规
    // f(i) = f(i-1) + f(i-2)   if X_(i-1)X_i 可翻译
    // f(i) = f(i-1)            if X_(i-1)X_i 不可可翻译
    public int core(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }

    // 倒着求贺正着求解 答案都是一样的，因为对称
    public int core2(int num) {
        int a = 1, b = 1, x, y = num % 10;
        while (num != 0) {
            num /= 10;
            x = num % 10;
            int tmp = 10 * x + y;
            int c = (tmp >= 10 && tmp <= 25) ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new TranslateNum2Str().translateNum(12258));
        System.out.println(new TranslateNum2Str().translateNum(506));
        System.out.println(new TranslateNum2Str().core(506));
        System.out.println(new TranslateNum2Str().core(12258));

    }
}
