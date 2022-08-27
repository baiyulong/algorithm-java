package org.example.day3;

import org.example.Node;

/**
 * 2022-07-11
 * 单链表翻转
 *
 * @author YULONG
 */
public class D31 {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        System.out.println(head.value + " -> " + head.next.value);
        head.next.next = new Node(3);
        head = f(head);
        System.out.println(head.value + " -> " + head.next.value);
    }

    public static Node f(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node cur = null;
        Node tmp;
        while (head != null) {
            tmp = head.next;
            head.next = cur;
            cur = head;
            head = tmp;
        }
        return cur;
    }
}
