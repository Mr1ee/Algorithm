package fresh.lee.algorithm.java.jz_offer;

public class DeleteListNode {

    public static ListNode deleteNode(ListNode head, int val) {
        ListNode guard = new ListNode(-1);
        guard.next = head;
        if (head.val == val) {
            return head.next;
        }
        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
                return guard.next;
            }
            head = head.next;
        }

        return guard.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(9);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println("before delete");
        printList(n1);

        deleteNode(n1, 1);

        System.out.println("after delete");
        printList(n1);
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println();
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
