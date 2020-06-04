package fresh.lee.algorithm.java.design_pattern.ChainOfResp;

public class ChainMain {

    public static void main(String[] args) {
        Leader chairman = new Chairman("董事长");
        Leader general = new GeneralManager("总经理", chairman);
        Leader department = new DepartmentManager("部门经理", general);

        System.out.println("甲 要请两天假");
        System.out.println(department.handleRequest(2));

        System.out.println("乙 要请4天假");
        System.out.println(department.handleRequest(4));

        System.out.println("丙 要请9天假");
        System.out.println(department.handleRequest(9));


        System.out.println("丁 要请16天假");
        System.out.println(department.handleRequest(16));
    }
}
