package fresh.lee.algorithm.java.design_pattern.proxy;

public class SchoolGirl {
    private String name;

    public SchoolGirl(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
