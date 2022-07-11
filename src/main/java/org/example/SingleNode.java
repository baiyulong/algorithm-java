package org.example;

/**
 * @author YULONG
 */
public class SingleNode {
    public int value;
    public SingleNode next;

    public SingleNode(int value) {
        this.value = value;
    }

    public SingleNode next(int value) {
        this.next = new SingleNode(value);
        return this.next;
    }
}
