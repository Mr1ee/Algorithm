package fresh.lee.algorithm.java.tree;


import fresh.lee.algorithm.java.tree.PrintStrategy.IPrintStrategy;
import fresh.lee.algorithm.java.tree.node.Node;

/**
 * 树的一些基本操作，增、删、查、改、打印树
 */
@SuppressWarnings("unused")
public interface ITreeAction<K, V> {
    boolean insert(K key, V value);

    boolean remove(K key);

    Node<K, V> find(K key);

    boolean amend(K key, V value);

    void print(IPrintStrategy strategy);
}
