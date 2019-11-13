package fresh.lee.algorithm.java.design_pattern.factory;

public class OperationFactory {

    /**
     * 简答工厂模式，这个时候客户端（main）是知晓IOperation和OperationFactory方法的，耦合还是比较严重
     *
     * @param args
     */
    public static void main(String[] args) {
        IOperation<Integer> op = OperationFactory.createOp("+");
        System.out.println(op.op(1, 2));

        IOperation<Integer> op2 = OperationFactory.createOp("-");
        System.out.println(op2.op(1, 2));

        IOperation<Integer> op3 = OperationFactory.createOp("*");
        System.out.println(op3.op(1, 2));

        IOperation<Integer> op4 = OperationFactory.createOp("/");
        System.out.println(op4.op(1, 2));
    }

    public static IOperation<Integer> createOp(String op) {
        if (!checkOp(op)) {
            throw new IllegalArgumentException("operation only support + - * /");
        }

        IOperation<Integer> operation;
        switch (op) {
            case "-":
                operation = new Sub();
                break;
            case "*":
                operation = new Mul();
                break;
            case "/":
                operation = new Div();
                break;
            default:
                operation = new Add();
        }
        return operation;
    }

    private static boolean checkOp(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
    }
}


class Add implements IOperation<Integer> {
    @Override
    public Integer op(Integer a, Integer b) {
        return a + b;
    }
}

class Sub implements IOperation<Integer> {
    @Override
    public Integer op(Integer a, Integer b) {
        return a - b;
    }
}

class Mul implements IOperation<Integer> {
    @Override
    public Integer op(Integer a, Integer b) {
        return a * b;
    }
}

class Div implements IOperation<Integer> {
    @Override
    public Integer op(Integer a, Integer b) {
        if (b == 0) {
            throw new IllegalArgumentException("被除数是0！");
        } else {
            return a / b;
        }
    }
}
