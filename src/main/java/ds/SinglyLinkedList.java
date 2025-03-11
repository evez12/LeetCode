package ds;


import java.util.EmptyStackException;

public class SinglyLinkedList {
    int value;
    SinglyLinkedList head;
    SinglyLinkedList next;
    SinglyLinkedList tail;
    int length;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        next = null;
    }

    public SinglyLinkedList(int value) {
        this();
        this.value = value;
    }


    /**
     * Adds a new element to the end of the list.
     *
     * @param val the value to be added to the list
     */
    public SinglyLinkedList push(int val) {
        SinglyLinkedList newNode = new SinglyLinkedList(val);
        this.length++;
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return this;
        }
        this.tail.next = newNode;
        this.tail = newNode;
        return this;
    }

    /**
     * Removes and returns the last element of the list.
     *
     * @return the value of the last element in the list
     * @throws EmptyStackException if the list is empty
     */
    public int pop() {
        if (this.length == 0) {
            throw new EmptyStackException();
        }

        int val = this.head.value;

        SinglyLinkedList newTail = this.head;
        if (newTail.next != null) {
            while (newTail.next != tail) {
                newTail = newTail.next;
            }
            val = newTail.next.value;
            newTail.next = null;
            this.tail = newTail;
        } else {
            this.head = null;
            this.tail = null;
        }
        this.length--;
        return val;
    }

    /**
     * Removes and returns the first element of the list.
     *
     * @return the value of the first element in the list
     * @throws EmptyStackException if the list is empty
     */
    public SinglyLinkedList shift() {
        if (this.length == 0) {
            throw new EmptyStackException();
        }

        this.head = this.head.next;
        if (this.head == null) {
            this.tail = null;
        }

        this.length--;
        return this;
    }

    /**
     * Adds a new element to the beginning of the list.
     *
     * @param val the value to be added to the list
     */
    public SinglyLinkedList unShift(int val) {
        SinglyLinkedList newHead = new SinglyLinkedList(val);
        if (this.length == 0) {
            this.tail = newHead;
        }

        newHead.next = this.head;
        this.head = newHead;

        this.length++;
        return this;
    }


    /**
     * Retrieves the value at the specified index in the list.
     *
     * @param index the index of the element to retrieve
     * @return the value of the element at the specified index
     * @throws EmptyStackException  if the list is empty
     * @throws NullPointerException if the index is out of bounds
     */
    public int getValue(int index) {

        if (index >= this.length || index < 0) throw new NullPointerException();

        return this.getNode(index).value;

    }

    public SinglyLinkedList getNode(int index) {
        if (index >= this.length || index < 0) throw new NullPointerException();

        SinglyLinkedList temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * Updates the value of the element at the specified index in the list.
     *
     * @param index the index of the element to update
     * @param val   the new value to set
     * @throws NullPointerException if the index is out of bounds
     */
    public SinglyLinkedList set(int index, int val) {

        if (index >= this.length || index < 0) throw new NullPointerException();

        SinglyLinkedList temp = this.getNode(index);
        temp.value = val;
        return this;
    }

    public SinglyLinkedList insert(int index, int val) {
        if (index > this.length || index < 0) throw new NullPointerException();

        if (index == 0) return this.unShift(val);
        if (index == this.length) return this.push(val);

        SinglyLinkedList newNode = new SinglyLinkedList(val);
        SinglyLinkedList temp = this.getNode(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        this.length++;
        return this;
    }

    /**
     * Removes the element at the specified index in the list.
     *
     * @param index the index of the element to remove
     * @throws NullPointerException if the index is out of bounds
     */
    public SinglyLinkedList remove(int index) {
        if (index >= this.length || index < 0) throw new NullPointerException();

        if (index == 0) return this.shift();
        if (index == this.length - 1) {
            this.pop();
            return this;
        }

        SinglyLinkedList temp = this.getNode(index - 1);

        temp.next = temp.next.next;
        return this;
    }

    public SinglyLinkedList reverse() {
        if (this.length <= 1) return this;

        this.tail = this.head;
        SinglyLinkedList prev = null;
        SinglyLinkedList current = this.head;

        while (current != null) {
            SinglyLinkedList next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        this.head = prev;
        return this;
    }

    public SinglyLinkedList rotate(int rotate) {
        if (rotate <= 0 || this.length <= 1) return this;

        SinglyLinkedList tail = getNode(rotate - 1);
        this.tail.next = this.head;
        this.tail = tail;
        this.head = getNode(rotate);
        tail.next = null;

        return this;
    }

    public SinglyLinkedList print() {
        SinglyLinkedList current = this.head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
        return this;
    }

}

class Main {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.push(1).push(2).push(3).push(4).push(5);
        System.out.print("Original ");
        list.print();
        list.reverse();
        list.print();

    }

}
