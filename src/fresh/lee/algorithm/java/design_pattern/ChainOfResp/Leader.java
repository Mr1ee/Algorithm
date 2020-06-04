package fresh.lee.algorithm.java.design_pattern.ChainOfResp;

/**
 * 某公司的请假制度为：
 * <p>
 * 1. 请假小于等于 2 天，部门经理可以批准。
 * <p>
 * 2. 请假小于等于 5 天，总经理可以批准。
 * <p>
 * 3. 请假小于等于 15 天，董事长可以批准。
 * <p>
 * 4. 请假大于 15 天，不予批准。
 */
public abstract class Leader {

    /**
     * 职位
     */
    private String position;

    /**
     * 本职位的 leader
     */
    private Leader myLeader;

    public Leader(String position) {
        this(position, null);
    }

    public Leader(String position, Leader leader) {
        this.position = position;
        this.myLeader = leader;
    }

    /**
     * 处理请假的请求
     *
     * @param day 请假时间
     * @return 处理结果
     */
    public String handleRequest(int day) {
        if (canHandler(day)) {
            return position + "批准了你的请假";
        } else {
            if (myLeader != null) {
                System.out.println(position + " 无权批准你的假期，转交给" + myLeader.position + "处理");
                return myLeader.handleRequest(day);
            } else {
                return "抱歉，没人可以批准你的请假";
            }
        }
    }

    protected abstract boolean canHandler(int day);
}
