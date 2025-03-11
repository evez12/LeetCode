package ds;

import java.util.EmptyStackException;

public class DoublyLinkedList {
    int value;
    int length;
    DoublyLinkedList head;
    DoublyLinkedList tail;
    DoublyLinkedList next;
    DoublyLinkedList prev;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        next = null;
        prev = null;
    }

    public DoublyLinkedList(int val) {
        this();
        this.value = val;
    }

    public DoublyLinkedList push(int val) {
        DoublyLinkedList newNode = new DoublyLinkedList(val);
        this.length++;
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return this;
        }

        newNode.prev = this.tail;
        this.tail.next = newNode;
        this.tail = newNode;
        return this;
    }

    public int pop() {
        if (this.length <= 0) throw new EmptyStackException();

        DoublyLinkedList oldTail = this.tail;
        if (this.length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
            oldTail.prev = null;
        }
        this.length--;
        return oldTail.value;
    }

    public DoublyLinkedList shift() {
        if (this.length <= 0) throw new EmptyStackException();

        DoublyLinkedList oldHead = this.head;
        this.head = oldHead.next;

        if (this.head == null) {
            this.tail = null;
        } else {
            this.head.prev = null;
            oldHead.next = null;
        }
        this.length--;
        return this;
    }

    public DoublyLinkedList unShift(int val) {
        DoublyLinkedList newNode = new DoublyLinkedList(val);

        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;

        }
        this.length++;
        return this;
    }

    public DoublyLinkedList getNode(int index) {
        if (index < 0 || index >= this.length) return null;

        if (index < this.length / 2) {
            return getNodeFromHead(index);
        } else {
            return getNodeFromTail(index);
        }

    }

    private DoublyLinkedList getNodeFromTail(int index) {
        DoublyLinkedList node = this.tail;
        for (int i = this.length - 1; i > index; i--) {
            node = node.prev;
        }
        return node;
    }

    private DoublyLinkedList getNodeFromHead(int index) {
        DoublyLinkedList node = this.head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public DoublyLinkedList insert(int index, int val) {
        if (index < 0 || index > this.length) return null;

        if (index == 0) return this.unShift(val);

        if (index == this.length) {
            this.push(val);
            return this;
        }

        DoublyLinkedList newNode = new DoublyLinkedList(val);
        DoublyLinkedList beforeNode = this.getNode(index - 1);
        DoublyLinkedList afterNode = beforeNode.next;

        afterNode.prev = newNode;
        newNode.prev = beforeNode;
        newNode.next = afterNode;
        beforeNode.next = newNode;

        this.length++;
        return this;
    }

    public DoublyLinkedList remove(int index) {

        if (index < 0 || index >= this.length) return null;

        if (index == this.length - 1) {
            this.pop();
            return this;
        }
        if (index == 0) return this.shift();

        DoublyLinkedList removedNode = this.getNode(index);
        DoublyLinkedList beforeNode = removedNode.prev;
        beforeNode.next = removedNode.next;
        removedNode.next.prev = beforeNode;
        removedNode.next = null;
        removedNode.prev = null;
        this.length--;
        return this;

    }

    public DoublyLinkedList reverse() {
        if (this.length <= 1) return this;

        DoublyLinkedList tempHead = this.head;
        this.head = this.tail;
        this.tail = tempHead;
        DoublyLinkedList current = this.head;
        for (int i = 0; i < this.length; i++) {
            DoublyLinkedList tempNext = current.next;
            // swap next and previous
            current.next = current.prev;
            current.prev = tempNext;

            current = current.next;
        }
        return this;
    }

    public DoublyLinkedList print() {
        DoublyLinkedList current = this.head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }
        System.out.println();
        return this;
    }

}

class Main2 {
    public static void main(String[] args) {
        testForReverse();
    }

    public static void testForPush() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.push(1).push(2).push(3);
        list.print();

        list.push(4);
        list.print();

        list.push(5);
        list.print();
    }

    public static void testForPop() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.push(1).push(2).push(3);
        list.print();

        System.out.println("Popped: " + list.pop());
        list.print();

        System.out.println("Popped: " + list.pop());
        list.print();

        System.out.println("Popped: " + list.pop());
        list.print();


    }

    public static void testForShift() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.push(1).push(2).push(3);
        list.print();

        list.shift();
        list.print();

        list.shift();
        list.print();

        list.shift();
        list.print();


    }

    public static void testForUnShift() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.push(1);//.push(2).push(3);
        list.print();

        list.unShift(0);
        list.print();

        list.unShift(-1);
        list.print();

        list.unShift(-2);
        list.print();
    }

    public static void testForGetNode() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.push(1).push(2).push(3).push(4).push(5);
        list.print();

        System.out.println("Node at index 0: " + list.getNode(0).value);
        System.out.println("Node at index 1: " + list.getNode(1).value);
        System.out.println("Node at index 2: " + list.getNode(2).value);
        System.out.println("Node at index 3: " + list.getNode(3).value);
        System.out.println("Node at index 4: " + list.getNode(4).value);
        System.out.println("Node at index 5: " + list.getNode(5)); // Should return null

    }

    public static void testForInsert() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.push(1).push(2).push(3).print();

        list.insert(2, 10).print();

        list.insert(2, 11).print();

        list.insert(4, 51).print();

        list.insert(3, 4).print();
    }

    public static void testForRemove() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.push(1).push(2).push(3).print();

        list.remove(0).print();
        list.push(4).print();
        list.remove(1).print();
        list.push(5).print();
        list.remove(2).print();

    }

    public static void testForReverse() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.push(1).push(2).push(3).push(4).push(5).print();

        list.reverse();
        list.print();

        list.reverse();
        list.print();
    }
}
