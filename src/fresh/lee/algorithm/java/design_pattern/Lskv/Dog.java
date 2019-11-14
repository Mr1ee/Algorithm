package fresh.lee.algorithm.java.design_pattern.Lskv;

public class Dog extends AbstractAnimal {

    @Override
    public void eat() {
        super.eat();
    }

    @Override
    public void breath() {
        super.breath();
    }

    @Override
    public void run() {
        super.run();
        System.out.println(this.species + " continue run");
    }

    @Override
    public void sleep() {
        System.out.println(this.species + " not sleep.");
    }

}
