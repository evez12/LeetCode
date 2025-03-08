package medium;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print() {
        System.out.print(this.val + " ");
        if (this.next != null) {
            this.next.print();
        }
    }
}

public class AddTwoNumbers_2 {

    public static void main(String[] args) {

        addTwoNumbers(new ListNode(0), new ListNode(0)).print();
        System.out.println();

        addTwoNumbers(new ListNode(5), new ListNode(5)).print();
        System.out.println();

        addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))),
                new ListNode(5, new ListNode(6, new ListNode(4)))
        ).print();
        System.out.println();
        addTwoNumbers(new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))),
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))).print();
        System.out.println();
        addTwoNumbers(new ListNode(9, new ListNode(9, new ListNode(1))),
                new ListNode(1)
        ).print();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int remainder = 0;

        while (l1 != null || l2 != null || remainder > 0) {
            int sum = remainder;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            remainder = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        return dummy.next;
    }

}
