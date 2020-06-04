package fresh.lee.algorithm.java.design_pattern.ChainOfResp;

/**
 * 部门主管
 */
public class DepartmentManager extends Leader {

    public DepartmentManager(String position, Leader leader) {
        super(position, leader);
    }

    @Override
    public boolean canHandler(int day) {
        return day <= 2;
    }
}
