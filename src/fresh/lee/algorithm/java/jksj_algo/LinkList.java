package fresh.lee.algorithm.java.jksj_algo;

/**
 * 练习题LeetCode对应编号：206，141，21，19，876
 */
public class LinkList {

    /**
     * 检测单链表中是否有环
     */
    public static <T> boolean hasRing(Node<T> root) {
        if (root == null) return false;

        Node<T> slow = root;
        Node<T> fast = root.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) return true;
        }

        return false;
    }

    /**
     * 反转单链表
     */
    public static <T> Node<T> reverse(Node<T> root) {
        Node<T> curr = root;
        Node<T> next;

        Node<T> head = null;

        while (curr != null) {
            //先保存旧链表下一个头节点
            next = curr.next;

            //当前节点指向反转节点的head
            curr.next = head;

            //把当前节点标记为head
            head = curr;

            //把旧节点的头节点作为当前节点，继续下一轮判断。
            curr = next;
        }

        return head;
    }

    /**
     * 合并两个有序链表
     */
    public static <T extends Comparable<T>> Node<T> merge2LinkedList(Node<T> list1, Node<T> list2) {
        Node<T> p1 = list1;
        Node<T> p2 = list2;
        // guard 守卫节点
        Node<T> guard = new Node<>();
        Node<T> tail = guard;

        while (p1 != null && p2 != null) {
            if (p1.value.compareTo(p2.value) <= 0) {
                tail.next = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                p2 = p2.next;
            }

            tail = tail.next;
        }

        if (p1 != null) {
            tail.next = p1;
        }
        if (p2 != null) {
            tail.next = p2;
        }

        return guard.next;
    }

    /**
     * 递归的方式合并两个有序链表
     */
    public static <T extends Comparable<T>> Node<T> mergeR(Node<T> list1, Node<T> list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.value.compareTo(list2.value) <= 0) {
            list1.next = merge2LinkedList(list1.next, list2);
            return list1;
        } else {
            list2.next = merge2LinkedList(list1, list2.next);
            return list2;
        }
    }

    /**
     * 删除单链表中倒数第N个节点
     * 单链表长度不足N，抛出异常
     */
    public static <T> Node<T> deleteLastN(Node<T> root, int n) {
        if (n < 1) {
            throw new IndexOutOfBoundsException("n must be bigger than 0");
        }
        //守卫头节点，方便后边统一判断
        Node<T> guard = new Node<>();
        guard.next = root;

        Node<T> p = guard;
        Node<T> tail = root;
        int i = 1;
        while (i++ < n) {
            tail = tail.next;
            if (tail == null) {
                throw new IndexOutOfBoundsException("linked list size < " + n);
            }
        }

        while (tail.next != null) {
            tail = tail.next;
            p = p.next;
        }

        //删除N节点
        p.next = p.next.next;
        return guard.next;
    }

    /**
     * 寻找单链表的中间节点
     * 如果单链表长度是奇数，则返回中间节点
     * 如果长度是偶数，则返回中间节点的靠左节点
     */
    public static <T> Node<T> findMiddleNode(Node<T> root) {
        Node<T> target = root;
        Node<T> tail = root;

        while (tail != null) {
            tail = tail.next;
            if (tail == null) {
                break;
            }

            tail = tail.next;
            if (tail == null) {
                break;
            }

            target = target.next;
        }
        return target;
    }


    public static void printLinkedList(Node root) {
        Node p = root;
        while (p != null) {
            System.out.print(p.value + "  ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
        Node<String> e = new Node<>("e");
        Node<String> f = new Node<>("f");
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        printLinkedList(a);

        System.out.println("reverse linked list");
        printLinkedList(reverse(a));


        int n = 2;
        System.out.println("\nafter delete last " + n + " node : ");
        printLinkedList(deleteLastN(e, n));

        System.out.println("reverse one node ");
        printLinkedList(reverse(f));

        System.out.println("reverse NULL ");
        printLinkedList(reverse(null));

        System.out.println("has ring ? = " + hasRing(e));

        a.next = c;
        System.out.println("has ring ? = " + hasRing(e));

        Node<Integer> a1 = new Node<>(1);
        Node<Integer> b1 = new Node<>(3);
        Node<Integer> c1 = new Node<>(5);
        Node<Integer> d1 = new Node<>(6);
        Node<Integer> e1 = new Node<>(10);
        a1.next = b1;
        b1.next = c1;
        c1.next = d1;
        d1.next = e1;

        Node<Integer> a2 = new Node<>(4);
        Node<Integer> b2 = new Node<>(7);
        Node<Integer> c2 = new Node<>(9);
        Node<Integer> d2 = new Node<>(10);
        Node<Integer> e2 = new Node<>(11);
        a2.next = b2;
        b2.next = c2;
        c2.next = d2;
//        d2.next = e2;

        System.out.println("middle node value = " + findMiddleNode(a1).value);
        System.out.println("middle node value = " + findMiddleNode(a2).value);


        System.out.println("merge two linked lists with null list");
        printLinkedList(mergeR(null, null));
        printLinkedList(mergeR(null, a2));
        printLinkedList(merge2LinkedList(a1, null));

        System.out.println("merge two non null linked list");
        printLinkedList(merge2LinkedList(a1, a2));

    }
}
