package fresh.lee.algorithm.java.jz_offer;

import java.util.LinkedList;

/**
 * 打印从根节点到某一节点的值的和，为指定值（sum）的路径
 */
public class PathInTree {
    static class Node<T extends Comparable<T>> {
        Node(T value) {
            this.value = value;
        }

        public T value;
        public Node<T> left;
        public Node<T> right;
    }

    /**
     * 寻找书中两个节点最近的公共祖先
     *
     * @param root 树的根节点
     * @param a    节点A
     * @param b    节点B
     * @return the nearest common node if find, else return empty string.
     */
    public static String findNearestAncestors(Node<String> root, String a, String b) {
        if (root == null) {
            throw new IllegalArgumentException("tree must not null!");
        }
        Node<String> node = new Node<>("");
        findNearestAncestorsCore(root, a, b, node);
        return node.value;
    }

    /**
     * 寻找书中两个节点最近的公共祖先
     *
     * @param root   树的根节点
     * @param a      节点A
     * @param b      节点B
     * @param target 目标节点
     * @return 如果子树中包含A或者B节点返回true，否则返回false。
     */
    public static boolean findNearestAncestorsCore(Node<String> root, String a, String b, Node<String> target) {
        if (root == null) {
            return false;
        }
        boolean left = findNearestAncestorsCore(root.left, a, b, target);
        boolean right = findNearestAncestorsCore(root.right, a, b, target);

        System.out.println("遍历 : " + root.value);
        if (left && right) {
            System.out.println("find " + root.value);
            target.value = root.value;
            return true;
        }

        //case A or B itself is ancestors.
        if ((left || right) && (a.equalsIgnoreCase(root.value) || b.equalsIgnoreCase(root.value))) {
            System.out.println("find " + root.value);
            target.value = root.value;
            return true;
        }
        return left || right || a.equalsIgnoreCase(root.value) || b.equalsIgnoreCase(root.value);
    }

    public static void getPath(Node root, LinkedList<Node> list, int currentSum, int sum) {
        if (root == null) {
            return;
        }
        list.add(root);
        currentSum = currentSum + (int) root.value;
        if (currentSum == sum) {
            //print stack trace
            for (Node node : list) {
                System.out.print(node.value + " ");
            }
            System.out.println();
        } else if (currentSum - sum < 0) {
            getPath(root.left, list, currentSum, sum);
            getPath(root.right, list, currentSum, sum);
        }
        list.removeLast();
    }

    public static void main(String[] args) {
        /*
         *          1
         *         / \
         *        2   3
         *      /    / \
         *     1    5   6
         */
        Node<Integer> root = new Node<>(1);
        Node<Integer> l1 = new Node<>(2);
        Node<Integer> r1 = new Node<>(3);
        Node<Integer> ll1 = new Node<>(1);
        Node<Integer> rl1 = new Node<>(5);
        Node<Integer> rl2 = new Node<>(6);

        root.left = l1;
        root.right = r1;
        l1.left = ll1;
        r1.left = rl1;
        r1.right = rl2;

        getPath(root, new LinkedList<>(), 0, 4);

        /*
         *          A
         *         / \
         *       [B]   C
         *      /  \
         *     D    E
         *    /\    /\
         *   F  G  H  I
         */
        Node<String> rootA = new Node<>("A");
        Node<String> b = new Node<>("B");
        Node<String> c = new Node<>("C");
        Node<String> d = new Node<>("D");
        Node<String> e = new Node<>("E");
        Node<String> f = new Node<>("F");
        Node<String> g = new Node<>("G");
        Node<String> h = new Node<>("H");
        Node<String> i = new Node<>("I");

        rootA.left = b;
        rootA.right = c;
        b.left = d;
        b.right = e;
        d.left = f;
        d.right = g;
        e.left = h;
        e.right = i;

        String ancestors = findNearestAncestors(rootA, "F", "I");
        if (ancestors == null || ancestors.isEmpty()) {
            System.out.println("no ancestors find in tree!");
        } else {
            System.out.println("the nearest common ancestors node is " + ancestors);
        }
    }
}
