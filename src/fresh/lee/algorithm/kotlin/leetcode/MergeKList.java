package fresh.lee.algorithm.kotlin.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKList {

    public static ListNode mergeKLists(ListNode[] lists) {
//        ListNode result = lists[0];
//        for (int i = 1; i < lists.length; i++) {
//            result = mergeTwoLists(result, lists[i]);
//        }

        return mergeKListPriorityQueue(lists);
    }


    /**
     * 优先级队列
     * 先用数组建立以小顶堆，比如有四个list，就建立一个capacity=4的小顶堆，每次拉出顶堆的那个node，然后node.next进堆
     */
    public static ListNode mergeKListPriorityQueue(ListNode[] lists) {
        //极端情况处理
        int len = 0;
        if (lists == null || (len = lists.length) == 0) return null;
        if (len == 1) return lists[0];
        //2个或以上个链表的情况
        ListNode preHead = new ListNode(-1);
        ListNode cur = preHead;
        //按节点数值大小比较建立最小堆
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(len, Comparator.comparingInt(n -> n.val));
        for (ListNode list : lists) {
            if (list != null) minHeap.offer(list);
        }
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            cur.next = minNode;
            cur = cur.next;
            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }
        return preHead.next;

    }

    public static ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode result = new ListNode(0);
        ListNode iterator = result;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                iterator.next = a;
                a = a.next;
            } else {
                iterator.next = b;
                b = b.next;
            }
            iterator = iterator.next;
        }
        if (a == null) {
            iterator.next = b;
        } else {
            iterator.next = a;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(3);
        ListNode f = new ListNode(4);
        ListNode g = new ListNode(2);
        ListNode i = new ListNode(6);

        a.next = b;
        b.next = c;
        d.next = e;
        e.next = f;
        g.next = i;

        ListNode a1 = a.deepCopy();
        ListNode d1 = d.deepCopy();
        ListNode g1 = g.deepCopy();

        ListNode a2 = a1.deepCopy();
        ListNode d2 = d1.deepCopy();
        ListNode g2 = g1.deepCopy();


        printList(mergeTwoLists(a, d));
        printList(mergeKLists(new ListNode[]{a1, d1, g1}));
        printList(mergeKLists(new ListNode[]{a2, d2, g2}));

    }

    private static void printList(ListNode node) {
        while (node.next != null) {
            System.out.print("" + node.val + "->");
            node = node.next;
        }
        System.out.print("" + node.val);
        System.out.println();
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode deepCopy() {
            ListNode newNode = new ListNode(val);
            if (this.next != null) {
                newNode.next = this.next.deepCopy();
            }
            return newNode;
        }
    }
}
