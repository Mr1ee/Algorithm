package fresh.lee.algorithm.java.jk_algo;

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
    }
}
