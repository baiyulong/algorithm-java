package org.example.day11;

import java.util.HashMap;
import java.util.Map;


/**
 * 2022-08-27
 * 克隆链表
 *
 * @author YULONG
 */
public class D111 {

    private static class Node implements Cloneable {
        public int value;
        public Node next;
        public Node random;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public Node clone() {
            Node clone = null;
            try {
                clone = (Node) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
            clone.value = value;
            return clone;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        Node nHead = f(head);
        System.out.println(nHead.value);
    }

    /**
     * Clone with hash map
     *
     * @param head 1
     * @return org.example.SingleNode
     * @author Bai Yulong
     * @since 0.1.0
     */
    public static Node f(Node head) {
        if (head == null) {
            return head;
        }
        Map<Node, Node> nodes = new HashMap<>(16);
        Node cur = head;
        while (cur != null) {
            nodes.put(head, head.clone());
            cur = cur.next;
        }
        // Reuse cur variable
        cur = head;
        while (cur != null) {
            nodes.get(cur).next = nodes.get(cur.next);
            nodes.get(cur).random = nodes.get(cur.random);
            cur = cur.next;
        }
        return nodes.get(head);
    }

    public static Node f1(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        while (cur != null) {
            Node nCur = cur.clone();
            nCur.next = cur.next;
            cur.next = nCur;
            cur = nCur.next;
        }
        cur = head;
        Node cur1 = head.next;
        while (cur1 != null) {
            cur1.random = cur.random.next;
            cur = cur1.next;
            cur1 = cur.next;
        }
        cur = head;
        cur1 = head.next;
        head = cur1;
        while (cur != null) {
            cur.next = cur1.next;
            cur = cur.next;
            if (cur1.next != null) {
                cur1.next = cur.next;
                cur1 = cur1.next;
            }
        }
        return head;
    }
}
