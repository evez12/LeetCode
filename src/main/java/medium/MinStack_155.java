package medium;

import java.util.LinkedList;

public class MinStack_155 {
    LinkedList<Integer> list = new LinkedList();

    // her defe push edende min'nu orda teyin edek(her push'da gir push ile muqayise edek
    int min;

    public MinStack_155() {

    }

    public void push(int val) {
        if (min > val) {
            min = val;
        }
        list.push(val);
    }

    public void pop() {
        list.pop();
    }

    public int top() {
        return list.peek();
    }

    public int getMin() {
        return min;
    }
}