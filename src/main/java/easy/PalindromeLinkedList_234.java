package easy;

import java.util.LinkedList;
import java.util.Objects;

public class PalindromeLinkedList_234 {
    public static void main(String[] args) {
        System.out.println(isPalindrome2(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));
        System.out.println(isPalindrome2(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(2)))))));
        System.out.println(isPalindrome2(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))))));

//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
//        System.out.println("Head value: " + head.val);
//        System.out.println(getLength(head));
//        System.out.println("Head value2: " + head.val);

//        System.out.println(isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));
//        System.out.println(isPalindrome(new ListNode(1, new ListNode(0, new ListNode(1)))));
//        System.out.println(isPalindrome(new ListNode(1, new ListNode(0, new ListNode(0)))));

    }


    /**
     * Given the head of a singly linked list, return true if it is a palindrome.
     */
// 1.Solution
//    Time complexity O(n) , Space complexity O(n)
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        LinkedList<Integer> list = new LinkedList<>();
        while (head != null) {
            int val = head.val;
            list.push(val);
            head = head.next;
        }
        while (!list.isEmpty()) {
            if (Objects.equals(list.peek(), list.peekLast())) {
                list.pop();
                list.pollLast();
            } else {
                return false;
            }
        }
        return true;
    }


    //    2.Solution
    // Time complexity O(n) , Space complexity O(1)
    public static boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) return true;
        int length = getLength(head);

        ListNode head1 = head;
        ListNode head2 = splitTwoPart(head, (double) length / 2);

//        head1.print();
        head2 = reverseList(head2);
        while (head2 != null) {
            if (head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
//        head2.print();
        return true;
    }


    public static ListNode splitTwoPart(ListNode head, double index) {
        ListNode head2 = head;
        index = Math.ceil(index);
        for (int i = 0; i < index; i++) {
            ListNode prev = head2;
            head2 = head2.next;
            if (i == index - 1) {
                prev.next = null;
            }
        }
        return head2;
    }

    public static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }


    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }


}
