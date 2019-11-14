package fresh.lee.algorithm.java.design_pattern.Lskv;

public class Main {

    /**
     * 里斯替换原则（LSP）：子类型必须能够替换它的父类型
     *
     * 一个软件实体如果能够使用父类型的话，那么一定是用于它的子类，并且程序的行为没有变化
     *
     */
    public static void main(String[] args) {
        AbstractAnimal animal = new Dog();
        animal.printAction();

        animal = new Cat();
        animal.printAction();
    }
}
