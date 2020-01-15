package fresh.lee.algorithm.java.jksj_algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lhy
 */
class BoyerMooerAlgo {
    private String pattern;

    private String str;

    private Map<Character, Integer> indexL = new HashMap<>();

    private int[] suffix;

    private int[] bmGs;

    public BoyerMooerAlgo(String t, String pattern) {
        this.str = t;
        this.pattern = pattern;
        indexL = createMap(pattern);
        suffix = suffix(pattern);
        bmGs = createBMGs(pattern);

        System.out.println(Arrays.toString(suffix));
    }

    private Map<Character, Integer> createMap(String pattern) {
        Map<Character, Integer> map = new HashMap<>(pattern.length());
        for (int i = pattern.length() - 1; i >= 0; i--) {
            char c = pattern.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, i);
            }
        }

        return map;
    }

    private int[] createBMGs(String pattern) {
        int length = pattern.length();
        int i, j;
        int[] array = new int[length];
        //模式串中没有子串匹配上好后缀，也找不到一个最大前缀
        for (i = 0; i < length; i++) {
            array[i] = length;
        }
        //模式串中没有子串匹配上好后缀，但找到一个最大前缀
        j = 0;
        for (i = length - 1; i >= 0; i--) {
            if (suffix[i] == i + 1) {
                for (; j < length - 1 - i; j++) {
                    if (array[j] == length) {
                        array[j] = length - 1 - i;
                    }
                }
            }
        }
        //模式串中有子串匹配上好后缀
        for (i = 0; i < length - 1; i++) {
            array[length - 1 - suffix[i]] = length - 1 - i;
        }
        System.out.print("bmGs:");
        System.out.println(Arrays.toString(array));

        return array;
    }

    /**
     * suffix[i] = s 表示以i为边界，与模式串后缀匹配的最大长度
     * 满足P[i-s, i] == P[m-s, m]的最大长度s
     *
     * @param pattern 模式串
     */
    private int[] suffix(String pattern) {
        int length = pattern.length();
        int[] array = new int[length];
        array[length - 1] = length;
        int q = 0;
        for (int i = length - 2; i >= 0; i--) {
            q = i;
            while (q >= 0 && pattern.charAt(q) == pattern.charAt(length - 1 - i + q)) {
                q--;
            }
            array[i] = i - q;
        }
        return array;
    }

    private int getIndex(char c) {
        //如果在规则中则返回相应的值，否则返回pattern的长度  
        if (indexL.containsKey(c)) {
            return indexL.get(c);
        }
        return pattern.length();
    }

    public int[] find() {
        int m = pattern.length();
        int n = str.length();
        int[] result = new int[n - m];
        //searching
        int j = 0;
        int i = 0;
        int index = 0;
        int count = 0;
        while (j <= n - m) {
            for (i = m - 1; i >= 0; i--) {   //用于计数
                if (pattern.charAt(i) != str.charAt(i + j)) {
                    break;
                }
            }
            if (i < 0) {
                System.out.println("one position is:" + j);
                result[index++] = j;
                j += bmGs[0];
            } else {
                j += Math.max(bmGs[i], getIndex(str.charAt(i + j)) - m + 1 + i);
            }
        }
        System.out.println("count:" + count);
        return result;
    }

    public static void main(String[] args) {
        String str = "here is a example and simple example";
        String pattern = "example";
        String pattern1 = "abcaaabcabc";
        BoyerMooerAlgo algo = new BoyerMooerAlgo(str, pattern);
        System.out.println("find index is " + Arrays.toString(algo.find()));

        System.out.println(BM.bm(str.toCharArray(), str.length(), pattern.toCharArray(), pattern.length()));
    }
}