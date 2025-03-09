package medium;


public class RemoveNthNodeFromEndList_19 {
    public static void main(String[] args) {

        removeNthFromEnd2(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 5).print();
        removeNthFromEnd2(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 1).print();
        removeNthFromEnd2(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 3).print();

//        removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3))), 2).print();
//
//        removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 1).print();
//
//        removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 5).print();

//        removeNthFromEnd2(new ListNode(1), 1);
//
//        removeNthFromEnd2(new ListNode(1, new ListNode(2)), 1).print();
//
//        removeNthFromEnd2(new ListNode(1, new ListNode(2)), 2).print();
//        System.out.println();
    }

    // 2. Solution
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode left = head;
        ListNode right = head;

        while (n-- > 0) {
            right = right.next;
        }

        if (right == null) {
            return head.next;
        }

        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;

        return head;
    }


    // 1.Solution
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        int size = calculateSize(head);

        if (n == size) {
            head = head.next;
            return head;
        }
        ListNode current = head;
        for (int i = 0; i < size - n - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }

    public static int calculateSize(ListNode head) {
        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }
}
