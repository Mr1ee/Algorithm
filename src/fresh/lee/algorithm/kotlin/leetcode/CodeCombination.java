package fresh.lee.algorithm.kotlin.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class CodeCombination {

    private static String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };
    private static LinkedList<String> resList;
    public List<String> letterCombinations(String digits) {

        resList = new LinkedList<String>();
        if(!"".equals(digits))
            backtrace(0, digits, "", resList);

        return resList;
    }

    public void backtrace(int i, String digits, String s, LinkedList<String> resList) {
        if(s.length() == digits.length()) {
            resList.addLast(s);
            return;
        }

        char digit = digits.charAt(i);   // 获取第i为数字
        String letters = letterMap[digit - '0'];  // 获取第i为数字对应的各个字母
        for (int j = 0; j < letters.length(); j++) {
            backtrace(i + 1, digits, s + letters.charAt(j), resList);
        }
    }


    public static void main(String[] args) {
        System.out.println(new CodeCombination().letterCombinations("234"));
    }

}
