package org.example;

import java.util.Objects;

/**
 * @author YULONG
 */
public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    public Node next(int value) {
        this.next = new Node(value);
        return this.next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node that = (Node) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
