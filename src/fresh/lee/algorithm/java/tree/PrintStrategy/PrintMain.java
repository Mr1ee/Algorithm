package fresh.lee.algorithm.java.tree.PrintStrategy;

import fresh.lee.algorithm.java.tree.BSTree;
import fresh.lee.algorithm.java.tree.KeyValue;

import java.util.ArrayList;

public class PrintMain {

    private static String preOrderStr = "ABDEHICFJG";
    private static String preOrderVStr = "0123456789";
    private static String inOrderKStr = "DBHEIAFJCG";
    private static int[] inOrderV = new int[]{2, 1, 4, 3, 5, 0, 7, 8, 6, 9};

    private static String postOrderKStr = "DHIEBJFGCA";
    private static int[] postOrderV = new int[]{2, 4, 5, 3, 1, 8, 7, 9, 6, 0};

    private static ArrayList<KeyValue<Integer, Character>> preOrder = new ArrayList<>();
    private static ArrayList<KeyValue<Integer, Character>> inOrder = new ArrayList<>();
    private static ArrayList<KeyValue<Integer, Character>> postOrder = new ArrayList<>();

    public static void main(String[] args) {

        /*
         * 层序遍历构建串 [A B C D E F G # # H I # J]
         *
         * 先序遍历构建串 [A B D # # E H # # I # # C F # J # # G # #]
         *              A
         *            /   \
         *           B     C
         *         / \    / \
         *        D  E   F   G
         *          / \   \
         *         H  I    J
         */
        for (int i = 0; i < preOrderStr.length(); i++) {
            preOrder.add(new KeyValue<>(i, preOrderStr.charAt(i)));
        }

        for (int i = 0; i < inOrderKStr.length(); i++) {
            inOrder.add(new KeyValue<>(inOrderV[i], inOrderKStr.charAt(i)));
        }

        for (int i = 0; i < postOrderKStr.length(); i++) {
            postOrder.add(new KeyValue<>(postOrderV[i], postOrderKStr.charAt(i)));
        }
        BSTree<Integer, Character> tree = new BSTree<>();
//        tree.buildTreeWithPreAndInSequence(preOrder, inOrder);
//        tree.print(new PreOrderTraversalPrint());
        tree.buildTreeWithPostAndInSequence(postOrder, inOrder);
        tree.print(new LevelOrderTraversalPrint());

        System.out.println("tree depth = " + LevelOrderTraversalPrint.getTreeDepthWithLevelOrder(tree.root));

    }
}
