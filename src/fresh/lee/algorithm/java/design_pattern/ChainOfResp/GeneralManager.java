package fresh.lee.algorithm.java.design_pattern.ChainOfResp;

/**
 * 总经理
 */
public class GeneralManager extends Leader {
    public GeneralManager(String position, Leader leader) {
        super(position, leader);
    }

    @Override
    public boolean canHandler(int day) {
        return day <= 5;
    }
}
