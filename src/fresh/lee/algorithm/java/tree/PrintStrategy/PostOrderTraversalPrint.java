package fresh.lee.algorithm.java.tree.PrintStrategy;


import fresh.lee.algorithm.java.tree.KeyValue;
import fresh.lee.algorithm.java.tree.node.Node;

import java.util.Stack;

@SuppressWarnings("unused")
public class PostOrderTraversalPrint implements IPrintStrategy {
    @Override
    public void print(Node node) {
        Stack<KeyValue<Boolean, Node>> stack = new Stack<>();
        stack.push(new KeyValue<>(false, node));
        while (!stack.isEmpty()) {
            KeyValue<Boolean, Node> pair = stack.pop();
            boolean visited = pair.key;
            Node parent = pair.value;
            if (visited) {
                Node.printNode(parent);
            } else {
                stack.push(new KeyValue<>(true, parent));

                Node right = parent.getRight();
                if (right != null) {
                    stack.push(new KeyValue<>(false, right));
                }

                Node left = parent.getLeft();
                if (left != null) {
                    stack.push(new KeyValue<>(false, left));
                }
            }
        }
    }
}
