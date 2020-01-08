package fresh.lee.algorithm.java.jksj_algo;


import java.util.Stack;

/**
 * 使用栈实现队列的下列操作：
 * <p>
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 */
class MyQueue {

    private Stack<Integer> pusher;
    private Stack<Integer> popper;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        pusher = new Stack<>();
        popper = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        pusher.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        int val = this.peek();
        popper.pop();
        return val;

    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (popper.empty()) {
            while (!pusher.empty()) {
                popper.push(pusher.pop());
            }
        }
        return popper.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return popper.empty() && pusher.empty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // 返回 1
        System.out.println(queue.pop());   // 返回 1
        System.out.println(queue.empty()); // 返回 false
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */