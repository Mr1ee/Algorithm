package fresh.lee.algorithm.java.tree.PrintStrategy;

import fresh.lee.algorithm.java.tree.node.Node;

import java.util.ArrayDeque;
import java.util.Queue;

@SuppressWarnings("unused")
public class LevelOrderTraversalPrint implements IPrintStrategy {
    @Override
    public void print(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        int depth = 0;
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                Node parent = queue.poll();
                Node.printNode(parent);

                Node left = parent.getLeft();
                if (left != null) {
                    queue.add(left);
                }

                Node right = parent.getRight();
                if (right != null) {
                    queue.add(right);
                }
            }

            depth++;
        }
        System.out.println("\ntree depth = " + depth);
    }

    public static int getTreeDepthWithLevelOrder(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        //用哨兵节点来标记是否开启下一层
        @SuppressWarnings("unchecked") Node guard = new Node(-1, -1);

        queue.add(guard);
        int depth = 0;
        while (!queue.isEmpty()) {
            Node parent = queue.poll();
            if (parent.equals(guard)) {
                depth++;
                if (queue.isEmpty()) {
                    //遍历结束
                    break;
                } else {
                    parent = queue.poll();
                }
                // 重新让哨兵节点进入队列
                queue.add(guard);
            }

            Node.printNode(parent);

            Node left = parent.getLeft();
            if (left != null) {
                queue.add(left);
            }

            Node right = parent.getRight();
            if (right != null) {
                queue.add(right);
            }
        }

        System.out.println("tree depth = " + depth);
        return depth;
    }
}
