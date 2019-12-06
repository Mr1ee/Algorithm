package fresh.lee.algorithm.java.jk_algo;


import java.util.Stack;

/**
 * leetcode 155 最小栈
 * <p>
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * <p>
 * 来源：力扣（LeetCode）
 */
class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    private int min = Integer.MAX_VALUE;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);

        if (x <= min) {
            min = x;
            minStack.push(x);
        }
    }

    public void pop() {
        int val = stack.pop();
        if (val == min) {
            minStack.pop();
            //WARNING 这里一定要注意判断边界条件！！！
            if (!stack.empty()) {
                min = minStack.peek();
            } else {
                min = Integer.MAX_VALUE;
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   //--> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());      //--> 返回 0.
        System.out.println(minStack.getMin());   //--> 返回 -2.

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */