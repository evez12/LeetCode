package easy;

public class ReverseLinkedList_206 {
    public static void main(String[] args) {
        reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))).print();
        reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))).print();

    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        return head;
    }
}
