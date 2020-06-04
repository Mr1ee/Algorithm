package fresh.lee.algorithm.java.design_pattern.ChainOfResp;

/**
 * 董事长
 */
public class Chairman extends Leader {
    public Chairman(String position, Leader leader) {
        super(position, leader);
    }

    public Chairman(String position) {
        super(position);
    }

    @Override
    public boolean canHandler(int day) {
        return day <= 15;
    }
}
