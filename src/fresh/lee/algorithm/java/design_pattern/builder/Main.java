package fresh.lee.algorithm.java.design_pattern.builder;

public class Main {

    /**
     * 构造器(Builder)模式，比JavaBean更具有优势
     */
    public static void main(String[] args) {
        House.Builder builder = new House.Builder();
        builder.wall("泥墙").door("木门").windows("小轩窗").roof("茅草屋顶");
        House house = builder.build();
        System.out.println(house);
    }
}
