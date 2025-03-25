package easy;

public class MiddleLinkedList_876 {
    public static void main(String[] args) {
        ListNode middle1 = middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        ListNode middle2 = middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        ListNode middle3 = middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        System.out.println("Middle 1: " + middle1.val);
        System.out.println("Middle 2: " + middle2.val);
        System.out.println("Middle 3: " + middle3.val);
    }

    //        /*
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

//     */
}
