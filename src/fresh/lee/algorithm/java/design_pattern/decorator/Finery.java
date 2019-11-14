package fresh.lee.algorithm.java.design_pattern.decorator;

public class Finery extends Person {
    protected Person person;

    public void decorate(Person person) {
        this.person = person;
    }

    public void show() {
        if (person != null) {
            person.show();
        }
    }
}
