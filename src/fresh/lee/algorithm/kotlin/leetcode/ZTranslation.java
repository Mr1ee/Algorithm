package fresh.lee.algorithm.kotlin.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ZTranslation {

    /***
     * 1   5   9     13    17
     * 2 4 6 8 10 12 14 16 18
     * 3   7   11    15    19
     *
     * 1     7        13       19
     * 2   6 8     12 14    18 20
     * 3 5   9  11    15 17    21
     * 4     10       16       22
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder result = new StringBuilder();
        int length = s.length();
        int step;
        int maxStep = (numRows - 1) * 2;
        for (int i = 0; i < numRows; i++) {
            int index = i;
            step = i * 2;
            if (step == 0) {
                step = maxStep;
            }
            while (index < length) {
                result.append(s.charAt(index));
                step = maxStep - step == 0 ? maxStep : maxStep - step;
                index += step;
            }
        }
        return result.toString();
    }

    /**
     * 从左到右迭代 s，将每个字符添加到合适的行。可以使用当前行和当前方向这两个变量对合适的行进行跟踪。
     * <p>
     * 只有当我们向上移动到最上面的行或向下移动到最下面的行时，当前方向才会发生改变。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/zigzag-conversion/solution/z-zi-xing-bian-huan-by-leetcode/
     * 来源：力扣（LeetCode）
     */
    public static String convert2(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(ZTranslation.convert("LEETCODEISHIRING", 2));
        System.out.println(ZTranslation.convert2("LEETCODEISHIRING", 2));

        System.out.println(ZTranslation.convert("LEETCODEISHIRING", 3));
        System.out.println(ZTranslation.convert2("LEETCODEISHIRING", 3));

        System.out.println(ZTranslation.convert("LEETCODEISHIRING", 4));
        System.out.println(ZTranslation.convert2("LEETCODEISHIRING", 4));
    }
}
