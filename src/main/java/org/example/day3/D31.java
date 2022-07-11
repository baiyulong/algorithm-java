package org.example.day3;

import org.example.SingleNode;

/**
 * 2022-07-11
 * 单链表翻转
 *
 * @author YULONG
 */
public class D31 {

    public static void main(String[] args) {
        SingleNode head = new SingleNode(1);
        head.next = new SingleNode(2);
        System.out.println(head.value + " -> " + head.next.value);
        head.next.next = new SingleNode(3);
        head = f(head);
        System.out.println(head.value + " -> " + head.next.value);
    }

    public static SingleNode f(SingleNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        SingleNode cur = null;
        SingleNode tmp;
        while (head != null) {
            tmp = head.next;
            head.next = cur;
            cur = head;
            head = tmp;
        }
        return cur;
    }
}
