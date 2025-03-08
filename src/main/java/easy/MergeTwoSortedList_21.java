package easy;

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

public class MergeTwoSortedList_21 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(4, new ListNode(5)));
        ListNode list4 = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println();
        mergeTwoLists(list1, list2).print();
        System.out.println();
        mergeTwoLists(list3, list4).print();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {


        if (list1 == null && list2 == null) return null;

        ListNode head = new ListNode();
        ListNode node = head; //for head node

        while (true) {
            int val1, val2;

            if (list1 != null && list2 != null) {
                val1 = list1.val;
                val2 = list2.val;
                if (val1 > val2) {
                    val2 = list2.val;
                    list2 = list2.next;
                    node.val = val2;
                } else {
                    val1 = list1.val;
                    list1 = list1.next;
                    node.val = val1;
                }
            } else if (list1 != null) {
                node.val = list1.val;
                list1 = list1.next;
            } else {
                node.val = list2.val;
                list2 = list2.next;
            }

            if (list1 != null || list2 != null) {
                node.next = new ListNode();
                node = node.next;
            } else {
                break;
            }

        }
        return head;
    }


}
