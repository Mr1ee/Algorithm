package fresh.lee.algorithm.java.design_pattern.decorator;

public class Main {

    /**
     * 装饰者模式
     * 装饰者模式为已有功能[动态]添加功能的一种方式。
     * 有效的把类的核心功能和装饰功能分开，而且可以去除相关类中重复的装饰逻辑
     * 客户端代码运行时，可以又选择的，按顺序使用装饰功能包装对象
     */
    public static void main(String[] args) {

        Person xc = new Person("小菜");
        Slipper slipper = new Slipper();
        BigTrouser bigTrouser = new BigTrouser();
        Tshirt tshirt = new Tshirt();

        System.out.println("第一种装扮的小菜");
        tshirt.decorate(xc);
        bigTrouser.decorate(tshirt);
        slipper.decorate(bigTrouser);
        slipper.show();

        System.out.println("换个穿着顺序");

        slipper.decorate(xc);
        bigTrouser.decorate(slipper);
        tshirt.decorate(bigTrouser);
        tshirt.show();

        System.out.println("换个装扮的小菜");
        Suit suit = new Suit();
        Tie tie = new Tie();
        suit.decorate(xc);
        tie.decorate(suit);
        slipper.decorate(tie);
        slipper.show();
    }
}
