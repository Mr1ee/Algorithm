package fresh.lee.algorithm.java.tree;


import fresh.lee.algorithm.java.tree.node.Node;

public class BinarySearchTree<K extends Comparable<K>, V> extends BTree<K, V> {

    @Override
    public boolean insert(K key, V value) {
//        Node<K, V> node = find(key);
//        if (node == null) {
//            root = insertInternalR(root, null, key, value);
//            println("after insert <" + key + "," + value + ">");
//            printTree();
//            return true;
//        } else {
//            return false;
//        }
        return insertInternal(key, value);
    }

    @Override
    public boolean remove(K key) {
        Node<K, V> node = find(key);
        if (node == null) {
            return false;
        } else {
//            root = removeInternalR(root, key);
            removeInternal(node);
            return true;
        }
    }

    @Override
    public Node<K, V> find(K key) {
        return findInternalR(root, key);
    }

    @Override
    public boolean amend(K key, V value) {
        Node<K, V> node = find(key);
        if (node == null) {
            return false;
        } else {
            node.value = value;
            return true;
        }
    }

    /**
     * 二叉搜索树插入的非递归实现
     */
    private boolean insertInternal(K key, V value) {
        if (key == null || value == null) {
            return false;
        }
        Node<K, V> t = root;
        if (t == null) {
            root = new Node<>(key, value, null);
            return true;
        }
        Node<K, V> parent = null;
        int cpr = 0;
        while (t != null) {
            parent = t;
            cpr = key.compareTo(t.key);
            if (cpr < 0) {
                t = t.left;
            } else if (cpr > 0) {
                t = t.right;
            } else {
                System.out.println("tree has the same key,can not insert again.");
                return false;
            }
        }
        Node<K, V> e = new Node<>(key, value, parent);
        if (cpr < 0)
            parent.left = e;
        else
            parent.right = e;

        return true;
    }

    /**
     * 二叉搜索树插入的递归实现
     */
    private Node<K, V> insertInternalR(Node<K, V> node, Node<K, V> parent, K key, V value) {
        if (node == null) {
            return new Node<>(key, value, parent);
        }
        int cpr = key.compareTo(node.key);
        if (cpr > 0) {
            node.right = insertInternalR(node.right, node, key, value);
        } else if (cpr < 0) {
            node.left = insertInternalR(node.left, node, key, value);
        } else {
            //tree has the same key,can not insert again.
            System.out.println("tree has the same key,can not insert again.");
            return null;
        }

        return node;
    }

    /**
     * 二叉搜索树删除的递归实现
     */
    private Node<K, V> removeInternalR(Node<K, V> node, K key) {
        if (node == null) {
            return null;
        }
        int cpr = key.compareTo(node.getKey());
        if (cpr > 0) {
            node.right = removeInternalR(node.right, key);
        } else if (cpr < 0) {
            node.left = removeInternalR(node.left, key);
        } else {
            if (node.isLeaf()) {
                return null;
            } else if (node.noLeftChild()) {
                return node.right;
            } else if (node.noRightChild()) {
                return node.left;
            } else {
                //待删除结点左右孩子结点均不为null，这个时候可以去找待删除结点的后继节点，或者前驱结点，
                //根据二叉排序树的定义后继节点就是左子树的最大节点，前驱结点就是右子树的最小节点
                //找到前驱结点, 交换前驱结点与node的值,然后删除前驱结点
                Node<K, V> predecessorNode = node.successor();
                //将前驱结点的值交给node
                node.value = predecessorNode.value;
                node.key = predecessorNode.key;
                //删除 前驱节点
                node.right = removeInternalR(node.right, predecessorNode.key);
            }
        }

        return node;
    }

    /**
     * 二叉搜索树插入的非递归实现
     */
    private void removeInternal(Node<K, V> node) {
        if (node.left != null && node.right != null) {
            Node<K, V> s = node.successor();
            node.key = s.key;
            node.value = s.value;
            node = s;
        } // p has 2 children

        // Start fix up at replacement node, if it exists.
        Node<K, V> replacement = (node.left != null ? node.left : node.right);
        if (replacement != null) {
            // Link replacement to parent
            replacement.parent = node.parent;
            if (node.parent == null)
                root = replacement;
            else if (node == node.parent.left)
                node.parent.left = replacement;
            else
                node.parent.right = replacement;

            node.left = node.right = node.parent = null;

        } else if (node.parent == null) { // if we have the only node. then set root null
            root = null;
        } else { //  No children. leaf node.
            if (node == node.parent.left)
                node.parent.left = null;
            else if (node == node.parent.right)
                node.parent.right = null;
            node.parent = null;
        }
    }

    /**
     * 二叉搜索树查找的递归实现
     */
    private Node<K, V> findInternalR(Node<K, V> node, K key) {
        if (node == null) {
            return null;
        }
        int cpr = key.compareTo(node.key);
        if (cpr == 0) {
            return node;
        } else if (cpr > 0) {
            return findInternalR(node.right, key);
        } else {
            return findInternalR(node.left, key);
        }
    }
}
