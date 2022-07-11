package org.example.day3;

import org.example.DoubleNode;

/**
 * 2022-07-11
 * 双链表翻转
 *
 * @author YULONG
 */
public class D32 {

    public static void main(String[] args) {
        DoubleNode head = new DoubleNode(1);
        head.next = new DoubleNode(2);
        head.next.prev = head;
        System.out.println(head.value + " -> " + head.next.value);
        head.next.next = new DoubleNode(3);
        head.next.next.prev = head.next;
        head = f(head);
        System.out.println(head.value + " -> " + head.next.value);
    }

    public static DoubleNode f(DoubleNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        DoubleNode pre = null;
        DoubleNode tmp;
        while (head != null) {
            tmp = head.next;
            head.next = pre;
            if (tmp != null) {
                tmp.prev = null;
            }
            head.prev = tmp;
            pre = head;
            head = tmp;
        }
        return pre;
    }
}
