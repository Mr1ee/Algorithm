package fresh.lee.algorithm.java.design_pattern.Lskv;

public class Main {

    public static void main(String[] args) {
        AbstractAnimal animal = new Dog();
        animal.printAction();

        animal = new Cat();
        animal.printAction();
    }
}
