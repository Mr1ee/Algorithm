package fresh.lee.algorithm.java.jksj_algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * <p>
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "1 + 1"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: " 2-1 + 2 "
 * 输出: Problem3
 * 示例 Problem3:
 * <p>
 * 输入: "(1+(4+5+2)-Problem3)+(6+8)"
 * 输出: 23
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 */
class Solution {

    public static void main(String[] args) {
        // "(1+(4+5+2)-Problem3)+(6+8)"
        // infix expression = 1+(2-Problem3)*4+4/2
        // postfix expression = 1 2 Problem3 - 4* + 4 2 / +
        String expr = "1+(2-Problem3)*4+4/2";
        System.out.println("result = " + new Solution().calculate(expr));
    }


    public int calculate(String s) {
        List<Unit> postfix = postfixExpr(s);

        for (Unit unit : postfix) {
            if (unit.isOp) {
                System.out.print(unit.op + " ");
            } else {
                System.out.print(unit.number + " ");
            }
        }
        System.out.println();

        return (int) calculateCore(postfix);
    }

    private long calculateCore(List<Unit> postfix) {
        long n1, n2, n3 = 0;
        int length = postfix.size();
        Stack<Long> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            Unit c = postfix.get(i);

            if (c.isOp) {
                n2 = stack.pop();
                n1 = stack.pop();

                if (c.op == '+') {
                    n3 = n1 + n2;
                } else if (c.op == '-') {
                    n3 = n1 - n2;
                } else if (c.op == '*') {
                    n3 = n1 * n2;
                } else if (c.op == '/') {
                    n3 = n1 / n2;
                }
                stack.push(n3);
            } else {
                stack.push(c.number);
            }
        }

        return stack.pop();
    }

    public List<Unit> postfixExpr(String s) {
        List<Unit> list = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        StringBuilder tmp = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (c == ' ') {
                if (tmp.length() > 0) {
                    list.add(new Unit(Long.parseLong(tmp.toString())));
                    tmp = new StringBuilder();
                }
                continue;
            }

            //如果是括号
            if (isParentheses(c)) {
                if (tmp.length() > 0) {
                    list.add(new Unit(Long.parseLong(tmp.toString())));
                    tmp = new StringBuilder();
                }
                if ('(' == c) {
                    stack.push(c);
                } else {
                    while (stack.peek() != '(') {
                        list.add(new Unit(stack.pop()));
                    }
                    //弹出 "("
                    stack.pop();
                }
            } else if (isOperator(c)) { //如果是操作符
                if (tmp.length() > 0) {
                    list.add(new Unit(Long.parseLong(tmp.toString())));
                    tmp = new StringBuilder();
                }
                if (stack.empty()) {
                    stack.push(c);
                } else {
                    int prior = priority(c);
                    while (!stack.empty() && prior <= priority(stack.peek())) {
                        list.add(new Unit(stack.pop()));
                    }
                    stack.push(c);
                }
            } else {
                tmp.append(c);
                if (i == array.length-1) {
                    list.add(new Unit(Long.parseLong(tmp.toString())));
                }
                //如果是数字,这里只处理单个数，不处理10位数
                //list.add(new Unit((long) (c - '0')));
            }
        }

        while (!stack.empty()) {
            list.add(new Unit(stack.pop()));
        }

        return list;
    }

    public boolean isParentheses(char c) {
        return c == '(' || c == ')';
    }

    public boolean isOperator(char c) {
        return "+-*/%^".indexOf(c) != -1;
    }


    public int priority(char operator) {
        switch (operator) {
            case '(':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
            default:
                return 4;
        }
    }

    class Unit {
        public boolean isOp;
        public char op;
        public long number;

        public Unit(char op) {
            this.isOp = true;
            this.op = op;
        }

        public Unit(Long num) {
            this.isOp = false;
            this.number = num;
        }
    }
}