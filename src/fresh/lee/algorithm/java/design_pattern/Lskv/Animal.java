package fresh.lee.algorithm.java.design_pattern.Lskv;

/**
 * 里斯替换原则（LSP）：子类型必须能够替换它的父类型
 *
 * 一个软件实体如果能够使用父类型的话，那么一定是用于它的子类，并且程序的行为没有变化
 *
 */
public interface Animal {

    void eat();

    void breath();

    void run();

    void sleep();
}
