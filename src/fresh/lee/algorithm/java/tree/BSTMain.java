package fresh.lee.algorithm.java.tree;

import fresh.lee.algorithm.java.tree.node.Node;

/**
 * @author lihuayong
 * @version 1.0
 * @description BSTMain
 * @date 2019-08-07 17:12
 */
public class BSTMain {

    public static int count = 0;

    public static void main(String[] args) {


        BSTree<Integer, Integer> bst = new BSTree<>();


        bst.insert(10, 10);
        bst.insert(2, 2);
        bst.insert(11, 11);
        bst.insert(7, 7);
        bst.insert(18, 18);
        bst.insert(5, 5);
        bst.insert(1, 1);
        bst.insert(3, 3);
        bst.insert(9, 9);
        bst.insert(21, 21);
        bst.insert(15, 15);

        bst.printTree();

        System.out.println("is BST = " + isBST(bst.root));
        System.out.println("count = " + count);
    }

    public static boolean isBST(Node<Integer, Integer> node) {
        boolean left = true, right = true;
        if (node == null) {
            return false;
        }
        
        if (node.left != null) {
            left = node.left.key < node.key && isBST(node.left);
        }
        count++;

        if(!left) return false;

        if (node.right != null) {
            right = node.right.key > node.key && isBST(node.right);
        }
        count++;
        return right;
    }
}