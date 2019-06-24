package fresh.lee.algorithm.java.tree;

import fresh.lee.algorithm.java.tree.PrintStrategy.IPrintStrategy;
import fresh.lee.algorithm.java.tree.node.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("unused")
public class BTree<K extends Comparable<K>, V> implements ITreeAction<K, V> {
    Node<K, V> root = null;

    @Override
    public boolean insert(K key, V value) {
        return false;
    }

    @Override
    public boolean remove(K key) {
        return false;
    }

    @Override
    public Node<K, V> find(K key) {
        return null;
    }

    @Override
    public boolean amend(K key, V value) {
        return false;
    }

    @Override
    public void print(IPrintStrategy strategy) {
        strategy.print(root);
    }

    public void buildTreeWithPreAndInSequence(List<KeyValue<K, V>> preOrder, List<KeyValue<K, V>> inOrder) {
        root = buildTreeWithPreAndInSequenceInternal(preOrder, inOrder);
    }

    private Node<K, V> buildTreeWithPreAndInSequenceInternal(List<KeyValue<K, V>> preOrder, List<KeyValue<K, V>> inOrder) {
        if (preOrder.isEmpty() || inOrder.isEmpty() || preOrder.size() != inOrder.size()) {
            return null;
        }

        int size = preOrder.size();
        int firstIndex = 0;
        if (size == 1) {
            return new Node<>(inOrder.get(0).key, inOrder.get(0).value);
        }

        Node<K, V> parent = new Node<>(preOrder.get(firstIndex).key, preOrder.get(firstIndex).value);
        int position = inOrder.indexOf(preOrder.get(firstIndex));
        parent.left = buildTreeWithPreAndInSequenceInternal(preOrder.subList(1, position + 1), inOrder.subList(0, position));
        parent.right = buildTreeWithPreAndInSequenceInternal(preOrder.subList(position + 1, size), inOrder.subList(position + 1, size));
        return parent;
    }

    public void buildTreeWithPostAndInSequence(List<KeyValue<K, V>> postOrder, List<KeyValue<K, V>> inOrder) {
        root = buildTreeWithPostAndInSequenceInternal(postOrder, inOrder);
    }

    private Node<K, V> buildTreeWithPostAndInSequenceInternal(List<KeyValue<K, V>> postOrder, List<KeyValue<K, V>> inOrder) {
        if (postOrder.isEmpty() || inOrder.isEmpty() || postOrder.size() != inOrder.size()) {
            return null;
        }

        int size = inOrder.size();
        int lastIndex = inOrder.size() - 1;
        if (size == 1) {
            return new Node<>(inOrder.get(0).key, inOrder.get(0).value);
        }
        Node<K, V> parent = new Node<>(postOrder.get(lastIndex).key, postOrder.get(lastIndex).value);
        int position = inOrder.indexOf(postOrder.get(lastIndex));
        parent.left = buildTreeWithPostAndInSequenceInternal(postOrder.subList(0, position), inOrder.subList(0, position));
        parent.right = buildTreeWithPostAndInSequenceInternal(postOrder.subList(position, lastIndex), inOrder.subList(position + 1, size));
        return parent;
    }

    /**
     * calculate all node's height
     */
    int calculateAllNodesHeight(Node<K, V> node) {
        if (node == null) {
            return 0;
        }
        int l = 0, r = 0;
        Node<K, V> left = node.left;
        Node<K, V> right = node.right;
        if (left != null) {
            l = calculateAllNodesHeight(left);
        }

        if (right != null) {
            r = calculateAllNodesHeight(right);
        }

        node.height = l > r ? l + 1 : r + 1;

        return node.height;
    }

    public void printTree() {
        printTree(root);
    }

    /**
     * print tree
     * ┌────────────── #
     * ┌────── A ──────┐
     * ┌── B ──┐       ┌── C ──┐
     * ┌ D ┐   ┌ E ┐   ┌ F ┐   ┌ G ┐
     * H   I   #   J   #   #   #   #
     */
    void printTree(Node<K, V> r) {
        calculateAllNodesHeight(r);
        if (r == null) {
            println("tree has empty");
            return;
        }
        int height = r.getHeight();
        ArrayList<List<Node<K, V>>> fullNodesList = new ArrayList<>();
        fillTree(fullNodesList, r, height);

        int maxWidth = (int) Math.pow(2.0, height);
        for (int index = 0; index < fullNodesList.size(); index++) {
            List<Node<K, V>> subList = fullNodesList.get(index);
            int size = subList.size();
            if (index != fullNodesList.size() - 1) {
                //print value
                for (Node<K, V> node : subList) {
                    printChar(" ", (maxWidth / size - 3));
                    String key = node.getKey().toString();
                    if (key.equals("#")) {
                        printChar(" ", (maxWidth / size + 1));
                    } else {
                        boolean isRbNode = this instanceof RBTree;
                        String value = node.getValue().toString();
                        int length = value.length();
                        if (length <= 2) {
                            if (isRbNode && node.isRed()) {
                                print("[" + value + "]");
                                printChar(" ", (maxWidth / size - length - 1));
                            } else {
                                print(" ");
                                print(value);
                                printChar(" ", (maxWidth / size - length));
                            }
                        } else {
                            if (isRbNode) {
                                print("[" + value + "]");
                                printChar(" ", (maxWidth / size - length - 2));
                            } else {
                                print(value);
                                printChar(" ", (maxWidth / size - length - 1));
                            }
                        }
                    }
                }
                println("");
                //print key
                for (Node<K, V> kvNode : subList) {
                    printChar(" ", (maxWidth / size / 2 - 2));
                    if (!kvNode.getLeft().getKey().toString().equals("#")) {
                        print("┌");
                        printChar("─", (maxWidth / size / 2 - 3));
                    } else {
                        printChar(" ", (maxWidth / size / 2 - 2));
                    }
                    String key = kvNode.getKey().toString();
                    if (key.equals("#")) {
                        print("   ");
                    } else {
                        print(kvNode);
                    }

                    if (!kvNode.getRight().getKey().toString().equals("#")) {
                        printChar("─", (maxWidth / size / 2 - 3));
                        print("┐");
                    } else {
                        printChar(" ", (maxWidth / size / 2 - 2));
                    }
                    printChar(" ", (maxWidth / size / 2 - 1));
                }
                println("");
            } else {
                //print value
                for (Node<K, V> kvNode : subList) {
                    printChar(" ", (maxWidth / size - 3));
                    String key = kvNode.getKey().toString();
                    if (key.equals("#")) {
                        printChar(" ", (maxWidth / size + 1));
                    } else {
                        boolean isRbNode = this instanceof RBTree;
                        String value = kvNode.getValue().toString();
                        int length = value.length();
                        if (length <= 2) {
                            if (isRbNode && kvNode.isRed()) {
                                print("[" + value + "]");
                                printChar(" ", (maxWidth / size - length - 1));
                            } else {
                                print(" ");
                                print(value);
                                printChar(" ", (maxWidth / size - length));
                            }
                        } else {
                            if (isRbNode) {
                                print("[" + value + "]");
                                printChar(" ", (maxWidth / size - length - 2));
                            } else {
                                print(value);
                                printChar(" ", (maxWidth / size - length - 1));
                            }
                        }
                    }
                }
                println("");
                //print key
                for (Node<K, V> kvNode : subList) {
                    String key = kvNode.getKey().toString();
                    if (key.equals("#")) {
                        print("   ");
                    } else {
                        print(kvNode);
                    }
                    print(" ");
                }
                println("");
            }
        }

        deleteNull(r);
    }

    /**
     * full fill tree, replace null node with "#" node
     * <p>
     * ┌── B ──┐       ┌── C ──┐
     * ┌ D ┐   ┌ E ┐   ┌ F ┐   ┌ G ┐
     * H   I   #   J   #   #   #   #
     */
    @SuppressWarnings("unchecked cast")
    private void fillTree(
            List<List<Node<K, V>>> fullNodesList,
            Node<K, V> r,
            int height
    ) {
        fullNodesList.add(new ArrayList<>(Collections.singleton(r)));
        int i = 0;
        while (i++ < height - 1) {
            List<Node<K, V>> preNodes = fullNodesList.get(fullNodesList.size() - 1);
            List<Node<K, V>> newRowNodes = new ArrayList<>();
            for (Node<K, V> it : preNodes) {
                if (it.getKey() == "#") {
                    it.setLeft((Node<K, V>) new Node<>("#", "#"));
                    it.setRight((Node<K, V>) new Node<>("#", "#"));
                    newRowNodes.add((Node<K, V>) new Node<>("#", "#"));
                    newRowNodes.add((Node<K, V>) new Node<>("#", "#"));
                } else {
                    if (it.getLeft() == null) {
                        it.setLeft((Node<K, V>) new Node<>("#", "#"));
                        newRowNodes.add((Node<K, V>) new Node<>("#", "#"));
                    } else {
                        newRowNodes.add(it.getLeft());
                    }

                    if (it.getRight() == null) {
                        it.setRight((Node<K, V>) new Node<>("#", "#"));
                        newRowNodes.add((Node<K, V>) new Node<>("#", "#"));
                    } else {
                        newRowNodes.add(it.getRight());
                    }
                }
            }
            fullNodesList.add(newRowNodes);
        }
    }

    /**
     * delete all the "#" node
     */
    private void deleteNull(Node<K, V> node) {
        if (node == null) {
            return;
        }
        Node<K, V> left = node.getLeft();
        Node<K, V> right = node.getRight();

        if (left != null) {
            if (left.getKey() == "#") {
                node.setLeft(null);
            } else {
                deleteNull(left);
            }
        }

        if (right != null) {
            if (right.getKey() == "#") {
                node.setRight(null);
            } else {
                deleteNull(right);
            }
        }
    }

    /**
     * print [s] for [n] times
     */
    private void printChar(String s, int n) {
        for (int i = 0; i <= n; i++) {
            print(s);
        }
    }

    protected void print(CharSequence c) {
        System.out.print(c);
    }

    private void print(Node c) {
        System.out.print("<" + c.getKey() + ">");
    }


    protected void println(CharSequence c) {
        System.out.println(c);
    }
}
