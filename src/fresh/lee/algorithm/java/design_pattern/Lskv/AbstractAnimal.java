package fresh.lee.algorithm.java.design_pattern.Lskv;

public abstract class AbstractAnimal implements Animal {
    protected String species;

    public AbstractAnimal() {
        String[] name = getClass().getName().split("\\.");
        this.species = name[name.length - 1];
    }

    @Override
    public void eat() {
        System.out.println(this.species + " eat.");
    }

    @Override
    public void breath() {
        System.out.println(this.species + " breath.");

    }

    @Override
    public void run() {
        System.out.println(this.species + " run.");

    }

    @Override
    public void sleep() {
        System.out.println(this.species + " sleep.");
    }

    public void printAction() {
        this.eat();
        this.breath();
        this.run();
        this.sleep();
    }
}
