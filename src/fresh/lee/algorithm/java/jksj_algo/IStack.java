package fresh.lee.algorithm.java.jksj_algo;

public interface IStack<T> {

    /**
     * 入栈
     *
     * @param val 待入栈value
     * @return 入栈是否成功
     */
    boolean push(T val);

    /**
     * 弹出栈顶value
     *
     * @return 栈顶value
     */
    T pop();

    /**
     * 获得栈顶value，但是不弹出栈
     *
     * @return 栈顶value
     */
    T top();

    /**
     * 栈是否为空
     */
    boolean isEmpty();

    default  void printAll(){

    }
}
