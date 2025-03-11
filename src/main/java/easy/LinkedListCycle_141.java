package easy;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle_141 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode cycle = new ListNode(-4);

        head.next = node;
        node.next = node2;
        node2.next = cycle;
        cycle.next = node;

        System.out.println(hasCycle2(head));

        ListNode head2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);

        head2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        System.out.println(hasCycle2(head2));

    }

    /**
     * Given head, the head of a linked list, determine if the linked list has a cycle in it.
     * Solution 1: Using HashSet
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }


    /**
     * Given head, the head of a linked list, determine if the linked list has a cycle in it.
     * Solution 2: two pointers
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static boolean hasCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


}
