package fresh.lee.algorithm.java.design_pattern.iterator;

import java.util.Iterator;

/**
 * 菜单接口
 * <p>
 * 每个菜单都应该提供一个提供迭代器
 */
public interface Menu<T> {
    Iterator<T> createIterator();
}
