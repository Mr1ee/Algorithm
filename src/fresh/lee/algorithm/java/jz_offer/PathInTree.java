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

    public static void getPath(Node root, LinkedList<Node> list, int currentSum, int sum) {
        if (root == null) {
            return;
        }
        list.add(root);
        currentSum = (int) currentSum + (int) root.value;
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
    }

    //getPath(root,0,123);
}
