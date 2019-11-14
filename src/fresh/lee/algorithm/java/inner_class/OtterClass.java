package fresh.lee.algorithm.java.inner_class;

public class OtterClass {

    public OtterClass() {
    }

    private String name;

    /**
     * 静态内部类
     */
    public static class StaticInnerClass {

        public StaticInnerClass(String id) {
            this.id = id;
        }

        private String id;

        public String idAppended() {
            return append(id);
        }

        private String append(String id) {
            return id + "added";
        }

    }

    /**
     * 非静态内部类
     */
    public class NonStaticInnerClass {

        public NonStaticInnerClass(String id) {
            this.id = id;
        }

        private String id;

        public String idAppended() {
            /*
             * dangerous!!! reference to Otter Class method！！！
             */
            return append(id);
        }
    }

    private String append(String id) {
        return id + "added";
    }

}
