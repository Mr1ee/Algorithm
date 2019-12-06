package fresh.lee.algorithm.java.jk_algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;

public class StackMain {

    //leetcode上关于栈的题目大家可以先做20,155,232,844,224,682,496.
    public static void main(String[] args) {
        IStack<String> stack = new ArrayStack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        stack.push("f");
        stack.push("g");
        stack.push("h");
        stack.push("i");

        stack.printAll();

        System.out.println("stack top = " + stack.top());
        System.out.println("stack pop = " + stack.pop());
        System.out.println("stack top = " + stack.top());

        stack.printAll();

        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }


    // leetcode 20
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        Map<Character, Character> hash = new HashMap<>(3);
        hash.put('(', ')');
        hash.put('[', ']');
        hash.put('{', '}');
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(c);
            }

            if (c == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if (stack.empty()) return false;
                char top = stack.pop();
                if (c != hash.get(top)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private static char op(char c) {
        switch (c) {
            case '(':
                return ')';
            case '{':
                return '}';
            case '[':
                return ']';
            default:
                return '(';
        }
    }
}
